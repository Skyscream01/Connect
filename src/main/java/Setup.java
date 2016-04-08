import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Setup
{
    public static Connection connection=null;
    public static String ip;
    public static String port;
    public static String db;
    public static String user;
    public static String password;

    public static void CreateConnection()
    {
        try
        {
            GetData();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://"+ip+":"+port+"/"+db,user, password);
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
    private static void GetData()
    {
        try
        {
            Ini ini = new Ini(new File("src/main/resources/SQL.ini"));
            ip = ini.get("connection 1", "ip");
            port = ini.get("connection 1", "port");
            db = ini.get("connection 1", "db");
            user = ini.get("connection 1", "user");
            password = ini.get("connection 1", "password");
        }
        catch (IOException ioExeption)
        {
            System.err.println(ioExeption.getMessage()+ioExeption.getStackTrace());
        }

    }
}

