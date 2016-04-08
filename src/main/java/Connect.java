import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class Connect {
    public static void main(String[] args)
    {
     //   String current = System.getProperty("user.dir");
     //  System.out.println("Current working directory in Java : " + current);

       // Read more: http://javarevisited.blogspot.com/2012/04/how-to-find-current-directory-in-java.html#ixzz45Dib5oj9
        Setup.CreateConnection();
        Table first = new Table();
        first.CreateTable("first");
        first.FillValues("first");
        Setup.CloseConnection();
    }
}


