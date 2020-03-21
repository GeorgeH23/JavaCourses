package rDatabases.hJDBCwithGUI;

import rDatabases.hJDBCwithGUI.Model.Album;
import rDatabases.hJDBCwithGUI.Model.Artist;
import rDatabases.hJDBCwithGUI.Model.DataSource;
import rDatabases.hJDBCwithGUI.Model.SortOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    private TableView artistTable;

    @FXML
    private ProgressBar progressBar;

    @FXML
    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        progressBar.progressProperty().bind(task.progressProperty());
        //progressBar.visibleProperty().bind(task.runningProperty());

        progressBar.setVisible(true);
        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnFailed(e -> progressBar.setVisible(false));

        new Thread(task).start();
    }

    @FXML
    public void listalbumsForArtist() {
        if (artistTable.getSelectionModel().getSelectedItem() != null) {
            if (artistTable.getSelectionModel().getSelectedItem().getClass() != Artist.class) {
                System.out.println("SELECTED ITEM IS NOT AN ARTIST");
                return;
            }
        }
        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if (artist == null) {
            System.out.println("NO ARTIST SELECTED");
            return;
        }
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(DataSource.getInstance().queryAlbumsForArtistId(artist.getId()));
            }
        };
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void updateArtist() {
        final Artist artist = (Artist) artistTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return DataSource.getInstance().updateArtistName(artist.getId(), "AC/DC");
            }
        };

        task.setOnSucceeded( e -> {
            if (task.valueProperty().get()) {
                artist.setName("AC/DC");
                artistTable.refresh();
            }
        });

        new Thread(task).start();
    }

}

class GetAllArtistsTask extends Task {
    @Override
    protected ObservableList<Artist> call() {
        return FXCollections.observableArrayList(DataSource.getInstance().queryArtists(SortOrder.ASCENDING));
    }
}