package services.mysql;

import java.sql.*;

/**
 * Created by bazzaouichaymae on 12/26/16.
 */
public class Mysql {
    private static Mysql sharedInstance = new Mysql();
    public static Mysql sharedInstance() {
        return sharedInstance;
    }
    private Connection connection;

    Statement currentStatement;

    private Mysql() {

    }

    // Connection

    private void connect() {

        try {

            // register the driver
            String sDriverName = "org.sqlite.JDBC";
            Class.forName(sDriverName);
            System.out.println("here is the problem");

            // Connect
            connection = DriverManager.getConnection("jdbc:sqlite:src/resources/database/database.db");

        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            System.exit(1);
        }

    }

    // Queries Methods

    public ResultSet executeQuery(String query) {
        try {
            connect();

            currentStatement = connection.createStatement();
            ResultSet result = currentStatement.executeQuery(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean executeUpdate(String update) {
        Statement stmt = null;
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(update);
            stmt.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect() {

        try {
            currentStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
