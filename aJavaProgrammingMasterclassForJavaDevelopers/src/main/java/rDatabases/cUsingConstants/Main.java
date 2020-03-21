package rDatabases.cUsingConstants;

import java.io.File;
import java.sql.*;

public class Main {

    public static final String PATH = new File(Main.class.getResource("/rDatabases/aIntroductionToDatabases/testjava.db").getFile()).getAbsolutePath();
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + PATH;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                  " (" + COLUMN_NAME + " text, " +
                                  COLUMN_PHONE + " integer, " +
                                  COLUMN_EMAIL + " text" +")");

            insertContact(statement,"Tim", 6545678, "tim@email.com");
            insertContact(statement,"Joe", 4567891, "joe@its.jnj.com");
            insertContact(statement,"George", 698979, "george@its.jnj.com");
            insertContact(statement,"Claudia", 1111111, "claudia@love.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                                    COLUMN_PHONE + " = 123123" +
                                    " WHERE " + COLUMN_NAME + " = 'George'");

            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                                    " WHERE " + COLUMN_NAME + " = 'Joe'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()){
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getString(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));
            }

            results.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ") " +
                "VALUES ('" + name + "', " + phone + ", '" + email + "')");
    }
}
