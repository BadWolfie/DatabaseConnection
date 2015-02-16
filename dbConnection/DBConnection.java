package dbConnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author BadWolfie
 */
public class DBConnection implements ConnectionParameters {
    private Connection connection;
    private final String fullUrl;
	
    public DBConnection() {
        connection = (Connection)null;
        fullUrl = dbURL + database;
    }
    
    private boolean loadDriver() {
        boolean loaded = false;

        try {
            Class.forName(driver).newInstance();
            loaded = true;
        } catch (InstantiationException | ClassNotFoundException | 
            IllegalAccessException ie) {
            System.out.print(ie);
        }

        return loaded;
    }
    
    public Connection getConnection() {
        connection = (Connection)null;

        if (loadDriver()) {
            try {
                connection = DriverManager.getConnection(
                    fullUrl,username,password);
            } catch (SQLException sqle) {
                System.out.println("SQL Exception: "+sqle.getMessage());
                System.out.println("Vendor Code: "+sqle.getErrorCode());
                System.out.println("SQL State: "+sqle.getSQLState());
            }
        } else {
            System.out.println("Error al cargar el Driver JDBC.");
        }

        return connection;
    }
    
    public void closeConnection() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
}