package rDatabases.bJDBCInsertUpdateDelete;

import java.io.File;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        final String PATH = new File(Main.class.getResource("/rDatabases/aIntroductionToDatabases/testjava.db").getFile()).getAbsolutePath();

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + PATH);

            //connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
            //statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Tim', 6545678, 'tim@email.com')");
            //statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Joe', 4567891, 'joe@its.jnj.com')");
            //statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('George', 698979, 'george@its.jnj.com')");
            //statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Claudia', 1111111, 'claudia@love.com')");
            //statement.execute("UPDATE contacts SET phone = 121212 WHERE name = 'George'");
            //statement.execute("DELETE FROM contacts WHERE name = 'Joe'");

            /*statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();*/
            // Shorter way
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while (results.next()){
                System.out.println(results.getString("name") + " " +
                                    results.getString("phone") + " " +
                                    results.getString("email"));
            }

            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
