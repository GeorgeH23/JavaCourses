package com.emailClient;

import com.emailClient.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcer extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();

        viewFactory.updateStyles();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
