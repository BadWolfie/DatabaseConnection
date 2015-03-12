package dbConnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author BadWolfie
 */
public class DBOperation {
    private final DBConnection dbConnection;
    
    public DBOperation() {
        dbConnection = new DBConnection();
    }
    
    private Connection getConnection() {
        return dbConnection.getConnection();
    }

    /**
     * Used to close the connection to the data base
     */
    public void closeConnection() {
        dbConnection.closeConnection();
    }
    
    /**
     * Used for SELECT operations
     * 
     * @param query Query to be executed
     * @param scrollable If the return value is scroll sensitive or not
     * @return ResultSet for the query executed.
     */
    public ResultSet getQueryResult(String query, boolean scrollable) {
        ResultSet rs = (ResultSet)null;
        Statement st;

        try {
            if (scrollable) {
                st = getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            } else
                st = getConnection().createStatement();

            rs = st.executeQuery(query);
        } catch (SQLException sqle) {
            System.out.print(sqle);
        }

        return rs;
    }
    
    /** 
     * Used for INSERT, UPDATE and DELETE operations
     * 
     * @param query Query to be executed
     * @return Operation successfull or not
     */
    public boolean executeOperation(String query) {
        int affRows = 0;

        try {
            Statement st = getConnection().createStatement();
            affRows = st.executeUpdate(query);
        } catch (SQLException sqle) {
            System.out.print(sqle);
        }

        return affRows != 0;
    }
}