package rDatabases.eMusicDatabaseExtended;

import rDatabases.eMusicDatabaseExtended.Model.Artist;
import rDatabases.eMusicDatabaseExtended.Model.DataSource;
import rDatabases.eMusicDatabaseExtended.Model.SongArtist;
import rDatabases.eMusicDatabaseExtended.Model.SortOrder;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open data source.");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(SortOrder.ASCENDING);
        if ((artists == null) || (artists.isEmpty())) {
            System.out.println("No artists!");
            return;
        }

        artists.forEach(System.out::println);
        System.out.println(artists.size() + " artists were found in the Database.\n");

        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Pink Floyd", SortOrder.ASCENDING);
        if ((albumsForArtist == null) || (albumsForArtist.isEmpty())) {
            System.out.println("No albums for artist.");
            return;
        }

        albumsForArtist.forEach(System.out::println);
        System.out.println(albumsForArtist.size() + " albums were found in the Database.\n");

        List<SongArtist> artistForSong = dataSource.queryArtistsForSong("Go Your Own Way",SortOrder.ASCENDING);
        if ((artistForSong == null) || (artistForSong.isEmpty())) {
            System.out.println("No artist for song.");
            return;
        }

        artistForSong.forEach(System.out::println);
        System.out.println("\n");

        dataSource.querySongsMetadata();
        System.out.println("\n");

        int count = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count + "\n");

        if (dataSource.createViewForSongArtists()) {
            System.out.println("View was created successfully.\n");
        }
        List<SongArtist> artistForSong2 = dataSource.querySongInfoView("Go Your Own Way");
        if ((artistForSong2 == null) || (artistForSong2.isEmpty())) {
            System.out.println("No artist for song.");
            return;
        }

        artistForSong2.forEach(System.out::println);
        System.out.println("\n");


        dataSource.close();
    }
}
