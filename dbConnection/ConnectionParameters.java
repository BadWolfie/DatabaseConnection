package dbConnection;

/**
 *
 * @author BadWolfie
 */
public interface ConnectionParameters {
	// Set `ip-address` to either the one you need to use or to `localhost`
	public final String dbURL = "jdbc:mysql://ip-address:3306/";
	public final String driver = "com.mysql.jdbc.Driver";

	// Set this parameters according to your credentials
    public final String database = "database_name";
    public final String username = "username";
    public final String password = "password";
}