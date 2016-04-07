import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class Connect
{
    public static void main(String[] args) throws ClassNotFoundException , SQLException
    {
      CreateConnection();
    }

    public static void CreateConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(
                "jdbc:postgresql://192.168.126.128:5001/test_database","tester", "qwaszx@1");
        System.out.println("You made it, take control your database now!");
        connection.close();
    }
}
