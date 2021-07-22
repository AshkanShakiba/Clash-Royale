import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The data base connector.
 */
public class DataBaseConnection {
    /**
     * The Database link.
     */
    public Connection databaseLink;

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        String databaseName = "clashroyalehub";
        String databaseUser = "root";
        String databasePassword = "password";
        String url = "jdbc:mysql://localhost:3306/" + databaseName + "?characterEncoding=latin1";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(
                    url, databaseUser, databasePassword);


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
