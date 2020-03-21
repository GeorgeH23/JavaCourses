package rDatabases.hJDBCwithGUI.Model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static final String PATH = new File(DataSource.class.getResource("/rDatabases/dMusicDatabase/music.db").getFile()).getAbsolutePath();
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + PATH;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final String QUERY_ARTISTS_SORT =
            " ORDER BY " + COLUMN_ARTIST_NAME + " COLLATE NOCASE ";

    //**********************************************************************************************
    // Using prepared statement in order to defend against SQL injection attacks

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUMS_BY_ARTIST_ID = "SELECT * FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_ARTIST + " = ? ORDER BY " + COLUMN_ALBUM_NAME + " COLLATE NOCASE";

    public static final String UPDATE_ARTIST_NAME = "UPDATE " + TABLE_ARTISTS + " SET " + COLUMN_ARTIST_NAME +
            " = ? WHERE " + COLUMN_ARTIST_ID + " = ?";

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbumsByArtistId;
    private PreparedStatement updateArtistName;

    private Connection connection;

    // In order to be threadsafe we initialize the instance here and not in the .getInstance() method
    private static DataSource instance = new DataSource();

    private DataSource() {
    }

    public static DataSource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);

            queryArtist = connection.prepareStatement(QUERY_ARTIST);
            queryAlbumsByArtistId = connection.prepareStatement(QUERY_ALBUMS_BY_ARTIST_ID);
            updateArtistName = connection.prepareStatement(UPDATE_ARTIST_NAME);

            System.out.println("Successfully connected to the Database.");

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to Database.");
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbumsByArtistId != null) {
                queryAlbumsByArtistId.close();
            }
            if (updateArtistName != null) {
                updateArtistName.close();
            }
            if (connection != null) {
                connection.close();
            }

            System.out.println("Successfully disconnected from the Database.");
        } catch (SQLException e) {
            System.out.println("Couldn't close connection to the Database.");
            e.printStackTrace();
        }
    }

    public List<Artist> queryArtists(SortOrder sortOrder) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != SortOrder.NONE) {
            sb.append(sort(QUERY_ARTISTS_SORT, sortOrder));
        }

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                Artist artist = new Artist();
                //It's faster to use the INDEX rather than the COLUMN NAME
                //artist.setId(results.getInt(COLUMN_ARTIST_ID));
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                //artist.setName(results.getString(COLUMN_ARTIST_NAME));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Album> queryAlbumsForArtistId(int id) {
        try {
            queryAlbumsByArtistId.setInt(1, id);
            ResultSet results = queryAlbumsByArtistId.executeQuery();

            List<Album> albums = new ArrayList<>();
            while (results.next()) {
                Album album = new Album();
                album.setId(results.getInt(1));
                album.setName(results.getString(2));
                album.setArtistId(id);

                albums.add(album);
            }

            return albums;
        } catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public boolean updateArtistName(int id, String newName) {
        try {
            updateArtistName.setString(1, newName);
            updateArtistName.setInt(2, id);
            int affectedRecords = updateArtistName.executeUpdate();

            return affectedRecords == 1;

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    private String sort(String sortSubject, SortOrder sortOrder) {
        StringBuilder sb = new StringBuilder(sortSubject);
        if (sortOrder == SortOrder.DESCENDING) {
            sb.append("DESC");
        } else {
            sb.append("ASC");
        }
        return sb.toString();
    }
}



























