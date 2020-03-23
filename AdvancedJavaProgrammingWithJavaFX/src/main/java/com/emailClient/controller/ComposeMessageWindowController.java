package com.emailClient.controller;

import com.emailClient.EmailManager;
import com.emailClient.controller.services.EmailSenderService;
import com.emailClient.model.EmailAccount;
import com.emailClient.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ComposeMessageWindowController extends BaseController implements Initializable {

    @FXML
    private ChoiceBox<EmailAccount> emailAccountChoiceBox;
    @FXML
    private TextField recipientTextField;
    @FXML
    private TextField subjectTextField;
    @FXML
    private HTMLEditor htmlEditor;
    @FXML
    private Label errorLabel;

    public ComposeMessageWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailAccountChoiceBox.setItems(emailManager.getEmailAccounts());
        emailAccountChoiceBox.setValue(emailManager.getEmailAccounts().get(0));
    }

    @FXML
    void sendButtonAction(ActionEvent event) {
        EmailSenderService emailSenderService = new EmailSenderService(
                emailAccountChoiceBox.getValue(),
                subjectTextField.getText(),
                recipientTextField.getText(),
                htmlEditor.getHtmlText()
        );
        emailSenderService.start();
        emailSenderService.setOnSucceeded( e -> {
            EmailSendingResult emailSendingResult = emailSenderService.getValue();
            switch (emailSendingResult) {
                case SUCCESS:
                    Stage stage = (Stage) recipientTextField.getScene().getWindow();
                    viewFactory.closeStage(stage);
                    break;
                case FAILED_BY_PROVIDER:
                    errorLabel.setText(" Provider error!");
                    break;
                case FAILED_BY_UNEXPECTED_ERROR:
                    errorLabel.setText(" Unexpected error!");
                    break;
            }
        });
    }
}
