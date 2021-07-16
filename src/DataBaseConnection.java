import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "clashroyalehub";
        String databaseUser = "root";
        String databasePassword = "56325632aA";
        String url = "jdbc:mysql://localhost:3306/" + databaseName + "?characterEncoding=latin1";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clashroyalehub?characterEncoding=latin1","root","password");


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
