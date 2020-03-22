package com.emailClient.controller;

import com.emailClient.EmailManager;
import com.emailClient.controller.services.MessageRendererService;
import com.emailClient.model.EmailMessage;
import com.emailClient.model.EmailTreeItem;
import com.emailClient.model.SizeInteger;
import com.emailClient.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.web.WebView;
import javafx.util.Callback;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private TreeView<String> emailsTreeView;
    @FXML
    private TableView<EmailMessage> emailsTableView;
    @FXML
    private TableColumn<EmailMessage, String> senderColumn;
    @FXML
    private TableColumn<EmailMessage, String> subjectColumn;
    @FXML
    private TableColumn<EmailMessage, String> recipientColumn;
    @FXML
    private TableColumn<EmailMessage, SizeInteger> sizeColumn;
    @FXML
    private TableColumn<EmailMessage, Date> dateColumn;
    @FXML
    private WebView emailWebView;

    private MessageRendererService messageRendererService;
    private MenuItem markUnreadMenuItem = new MenuItem("Mark as unread");
    private MenuItem deleteMessageMenuItem = new MenuItem("Delete message");

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpEmailsTreeView();
        setUpEmailsTableView();
        setUpFolderSelection();
        setUpBoldRows();
        setUpMessageRendererService();
        setUpMessageSelection();
        setUpContextMenus();
    }

    @FXML
    void composeMessageOption(ActionEvent event) {
        viewFactory.showComposeMessageWindow();
    }

    @FXML
    void optionsAction(ActionEvent event) {
        viewFactory.showOptionsWindow();
    }

    @FXML
    void addAccountAction(ActionEvent event) {
        viewFactory.showLoginWindow();
    }

    private void setUpEmailsTreeView() {
        emailsTreeView.setRoot(emailManager.getFoldersRoot());
        emailsTreeView.setShowRoot(false);
    }

    private void setUpEmailsTableView() {
        senderColumn.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("sender"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("subject"));
        recipientColumn.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("recipient"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<EmailMessage, SizeInteger>("size"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<EmailMessage, Date>("date"));

        emailsTableView.setContextMenu(new ContextMenu(markUnreadMenuItem, deleteMessageMenuItem));
    }

    private void setUpFolderSelection() {
        emailsTreeView.setOnMouseClicked( e -> {
            EmailTreeItem<String> item = (EmailTreeItem<String>) emailsTreeView.getSelectionModel().getSelectedItem();
            if (item != null) {
                emailManager.setSelectedFolder(item);
                emailsTableView.setItems(item.getEmailMessages());
            }
        });
    }

    private void setUpBoldRows() {
        emailsTableView.setRowFactory(new Callback<TableView<EmailMessage>, TableRow<EmailMessage>>() {
            @Override
            public TableRow<EmailMessage> call(TableView<EmailMessage> emailMessageTableView) {
                return new TableRow<EmailMessage>() {
                    @Override
                    protected void updateItem(EmailMessage item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            if (item.isRead()) {
                                setStyle("");
                            } else {
                                setStyle("-fx-font-weight: bold");
                            }
                        }
                    }
                };
            }
        });
    }

    private void setUpMessageRendererService() {
        this.messageRendererService = new MessageRendererService(emailWebView.getEngine());
    }

    private void setUpMessageSelection() {
        emailsTableView.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                EmailMessage emailMessage = emailsTableView.getSelectionModel().getSelectedItem();
                if ((emailMessage != null) && (messageRendererService.getEmailMessage() != emailMessage)) {
                    emailManager.setSelectedMessage(emailMessage);
                    if (!emailMessage.isRead()) {
                        emailManager.setRead();
                    }
                    emailManager.setSelectedMessage(emailMessage);
                    messageRendererService.setEmailMessage(emailMessage);
                    messageRendererService.restart();
                }
            }
        });
    }

    private void setUpContextMenus() {
        markUnreadMenuItem.setOnAction(event -> {
            emailManager.setUnread();
        });
        deleteMessageMenuItem.setOnAction(event -> {
            emailManager.deleteSelectedMessage();
            emailWebView.getEngine().loadContent("");
        });
    }

}