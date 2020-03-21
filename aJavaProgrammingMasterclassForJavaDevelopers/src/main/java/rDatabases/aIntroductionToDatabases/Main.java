package rDatabases.aIntroductionToDatabases;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        final String PATH = new File(Main.class.getResource("/rDatabases/aIntroductionToDatabases/testjava.db").getFile()).getAbsolutePath();

        // Use try with resources in order for the resources to be closed automatically at the end of the try catch block

        /*try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + PATH);
             Statement statement = connection.createStatement()){

            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

        } catch (SQLException e){
            e.printStackTrace();
        }*/

        // Or use try catch and close the resources manually at the end of the try block
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + PATH);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
