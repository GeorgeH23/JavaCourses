package rDatabases.dMusicDatabase;

import rDatabases.dMusicDatabase.Model.Artist;
import rDatabases.dMusicDatabase.Model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open data source.");
            return;
        }

        List<Artist> artists = dataSource.queryArtists();
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        artists.forEach(System.out::println);

        System.out.println(artists.size() + " artists were found in the Database.");

        dataSource.close();
    }
}
