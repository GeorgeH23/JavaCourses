package nLambdaExpressions.bContinuingLambdaExpressions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button clickMeButton;

    public void initialize() {
        //USUAL way
        /*clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You clicked me!");
            }
        });*/
        //LAMBDA way
        clickMeButton.setOnAction(event -> System.out.println("You clicked me!!!"));
    }

}
