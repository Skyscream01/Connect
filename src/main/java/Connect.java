import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class Connect {
    public static void main(String[] args)
    {
        Setup.CreateConnection();
        Table first = new Table();
        first.CreateTable("first");
        first.FillValues("first");
        Setup.CloseConnection();
    }
}


