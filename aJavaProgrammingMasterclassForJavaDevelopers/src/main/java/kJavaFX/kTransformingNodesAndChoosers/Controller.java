package kJavaFX.kTransformingNodesAndChoosers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize() {
       /* label.setScaleX(2.0);
        label.setScaleY(2.0);*/
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        if (label.isHover()){
            label.setScaleX(2.0);
            label.setScaleY(2.0);
        }
        if (button1.isHover()){
            button1.setScaleX(1.2);
            button1.setScaleY(1.2);
        }
        if (button2.isHover()){
            button2.setScaleX(1.2);
            button2.setScaleY(1.2);
        }
        if (button3.isHover()){
            button3.setScaleX(1.2);
            button3.setScaleY(1.2);
        }
    }

    @FXML
    public void handleMouseExit() {
        if (!label.isHover()) {
            label.setScaleX(1.0);
            label.setScaleY(1.0);
        }
        if (!button1.isHover()) {
            button1.setScaleX(1.0);
            button1.setScaleY(1.0);
        }
        if (!button2.isHover()) {
            button2.setScaleX(1.0);
            button2.setScaleY(1.0);
        }
        if (!button3.isHover()) {
            button3.setScaleX(1.0);
            button3.setScaleY(1.0);
        }
    }

    @FXML
    public void handleClick(ActionEvent e) {
        if (e.getSource().equals(button2)) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                    new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            //File file = fileChooser.showOpenDialog(gridPane.getScene().getWindow());
            List<File> files = fileChooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
            if (files != null) {
                for (File f : files) {
                    System.out.println(f.getPath());
                }
            } else {
                System.out.println("File chooser was cancelled");
            }
        } else if (e.getSource().equals(button1)) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File file = directoryChooser.showDialog(gridPane.getScene().getWindow());
            if (file != null) {
                System.out.println(file.getPath());
            } else {
                System.out.println("Directory chooser was cancelled");
            }
        } else if (e.getSource().equals(button3)) {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Save Application File");
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("PDF", "*.pdf"));
            File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
            if (file != null) {
                System.out.println(file.getPath());
            } else {
                System.out.println("Save file dialog was cancelled");
            }
        }
    }

    @FXML
    public void handleLinkClick(){
        System.out.println("The Link was clicked!");
        /*try {
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
        } catch (IOException e){
            e.printStackTrace();
        } catch (URISyntaxException e){
            e.printStackTrace();
        }*/

        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
    }

}
