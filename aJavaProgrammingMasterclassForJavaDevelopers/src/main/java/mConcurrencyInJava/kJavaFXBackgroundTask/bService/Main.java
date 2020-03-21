package mConcurrencyInJava.kJavaFXBackgroundTask.bService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene root = new Scene((FXMLLoader.load(getClass().getResource("/mConcurrencyInJava/kJavaFXBackgroundTask/bService/sample.fxml"))), 300, 500);
        primaryStage.setTitle("Service");
        primaryStage.setScene(root);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
