module cAdvancedJavaProgrammingWithJavaFX {

    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.web;
    requires java.desktop;
    requires activation;
    requires java.mail;

    opens com.emailClient;
    opens com.emailClient.controller;
    opens com.emailClient.view;
    opens fxmlFiles;
    opens com.emailClient.model;

    exports com.emailClient;
    exports com.emailClient.controller;
    exports com.emailClient.view;
    exports com.emailClient.model;
}