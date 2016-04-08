import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Setup
{
    public static Connection connection=null;

    public static void CreateConnection()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.126.128:5001/test_database","tester", "qwaszx@1");
            System.out.println("Connection successfull");
        }
        catch (ClassNotFoundException classExeption)
        {
            System.out.println("Setup error appeared");
            System.err.println(classExeption.getMessage() + classExeption.getStackTrace());
        }
        catch (SQLException sqlExeption)
        {
            System.out.println("Setup error appeared");
            System.err.println(sqlExeption.getMessage() + sqlExeption.getStackTrace());
        }
    }
    public static  void CloseConnection()
    {
        try
        {
            connection.close();
        }
        catch (SQLException sqlExeption)
        {
            System.out.println("TearDown error appeared");
            System.err.println(sqlExeption.getMessage() + sqlExeption.getStackTrace());
        }
    }
}

