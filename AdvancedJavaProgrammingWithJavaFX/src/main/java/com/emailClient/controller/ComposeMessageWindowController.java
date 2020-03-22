package com.emailClient.controller;

import com.emailClient.EmailManager;
import com.emailClient.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import java.net.URL;
import java.util.ResourceBundle;

public class ComposeMessageWindowController extends BaseController implements Initializable {

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

    }

    @FXML
    void sendButtonAction(ActionEvent event) {
        System.out.println(htmlEditor.getHtmlText());
        System.out.println("send button!");
    }
}
