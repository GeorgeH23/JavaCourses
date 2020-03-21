package rDatabases.xMySQL;

import rDatabases.xMySQL.Model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\gharpa\\Desktop\\93.Databases\\" + DB_NAME;
    public static List<Song> songs = new ArrayList<>();
    public static List<Artist> artists = new ArrayList<>();
    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {/*

        *//*try(Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement()) {

            ResultSet results = statement.executeQuery("SELECT * FROM songs");

            while (results.next()) {
                Song song = new Song();
                song.setId(results.getInt(1));
                song.setTrack(results.getInt(2));
                song.setName(results.getString(3));
                song.setAlbumId(results.getInt(4));

                songs.add(song);
            }

            ResultSet results = statement.executeQuery("SELECT * FROM artists");

            while (results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(1));
                artist.setName(results.getString(2));

                artists.add(artist);
            }

            ResultSet results = statement.executeQuery("SELECT * FROM albums");

            while (results.next()) {
                Album album = new Album();
                album.setId(results.getInt(1));
                album.setName(results.getString(2));
                album.setArtistId(results.getInt(3));

                albums.add(album);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*//*

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");
            Statement statement = connection.createStatement()) {

            ResultSet results = statement.executeQuery("SELECT * FROM employees ORDER BY department");
            while (results.next()) {
                System.out.println(results.getString("last_name") + ", " + results.getString("first_name") + ", " +
                        results.getString("email") + ", " + results.getString("department") + ", " + results.getInt("salary"));
            }

            *//*for (Song song : songs) {
               statement.executeUpdate("INSERT INTO songs (_id, track, title, album) VALUES (" + song.getId() +
               ", " + song.getTrack() + ", " + "\"" + song.getName() + "\"" + ", " + song.getAlbumId() + ")");
            }*//*

            *//*for (Artist artist : artists) {
                statement.executeUpdate("INSERT INTO artists (_id, name) VALUES (" + artist.getId() + ", \"" + artist.getName() + "\")");
            }*//*

            *//*for (Album album : albums) {
                statement.executeUpdate("INSERT INTO albums (_id, name, artist) VALUES (" + album.getId() + ", \"" + album.getName() + "\"" + ", " + album.getArtistId() + ")");
            }*//*

        } catch (SQLException e) {
            e.printStackTrace();
        }*/



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
