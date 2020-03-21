package kJavaFX.kTransformingNodesAndChoosers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/kJavaFX/kTransformingNodesAndChoosers/sample.fxml"));
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1400, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
