package rDatabases.fSQLInjectionAttacksAndPreparedStatements;

import rDatabases.fSQLInjectionAttacksAndPreparedStatements.Model.DataSource;
import rDatabases.fSQLInjectionAttacksAndPreparedStatements.Model.SongArtist;
import rDatabases.fSQLInjectionAttacksAndPreparedStatements.Model.SortOrder;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open data source.");
            return;
        }

        List<SongArtist> artistForSong = dataSource.queryArtistsForSong("Go Your Own Way", SortOrder.NONE);
        if ((artistForSong == null) || (artistForSong.isEmpty())) {
            System.out.println("No artist for song.");
            return;
        }

        artistForSong.forEach(System.out::println);
        System.out.println("\n");

        if (dataSource.createViewForSongArtists()) {
            System.out.println("View was created successfully.\n");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();

        // *********************************************************************************
        // **********************SQL INJECTION ATTACK***************************************
        /*Enter a song title:
        Go Your Own Way" or 1=1 or"
        SELECT name, album, track FROM artist_list WHERE title = "Go Your Own Way" or 1=1 or""*/
        // **********************SQL INJECTION ATTACK***************************************
        // *********************************************************************************

        List<SongArtist> artistForSong2 = dataSource.querySongInfoView(title);
        if ((artistForSong2 == null) || (artistForSong2.isEmpty())) {
            System.out.println("No artist for song.");
            return;
        }

        artistForSong2.forEach(System.out::println);
        System.out.println("\n");

        dataSource.close();
    }
}
