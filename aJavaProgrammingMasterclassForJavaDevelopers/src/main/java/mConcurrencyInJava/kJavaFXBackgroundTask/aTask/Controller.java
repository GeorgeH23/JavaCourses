package mConcurrencyInJava.kJavaFXBackgroundTask.aTask;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {

    private Task<ObservableList> task;

    @FXML
    private ListView listView;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;

    public void initialize() {
        // BAD way of doing it!!!
        /*task = new Task<ObservableList>() {
            @Override
            protected ObservableList call() throws Exception {
                Thread.sleep(1000);
                final ObservableList<String> employees = FXCollections.observableArrayList("Tim Buchalka", "Bill Rogers", "Jack Jill", "Joan Andrews", "Mary Johnson", "Bob McDonald");

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        listView.setItems(employees);
                    }
                });
                return employees;
            }
        };*/

        // GOOD way of doing it!!!
        task = new Task<ObservableList>() {
            @Override
            protected ObservableList call() throws Exception {

                String[] names = {"Tim Buchalka", "Bill Rogers", "Jack Jill", "Joan Andrews", "Mary Johnson", "Bob McDonald"};

                //final ObservableList<String> employees = FXCollections.observableArrayList("Tim Buchalka", "Bill Rogers", "Jack Jill", "Joan Andrews", "Mary Johnson", "Bob McDonald");
                ObservableList<String> employees = FXCollections.observableArrayList();
                for (int i = 0; i < 6; i++) {
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list.");
                    updateProgress(i + 1, 6);
                    Thread.sleep(200);
                }

                return employees;
            }
        };

        listView.itemsProperty().bind(task.valueProperty());

        progressBar.progressProperty().bind(task.progressProperty());

        progressLabel.textProperty().bind(task.messageProperty());
    }

    @FXML
    public void buttonPressed(){
        new Thread(task).start();
    }
}
