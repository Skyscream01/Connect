import java.sql.SQLException;
import java.sql.Statement;

public class Table
{
    public void CreateTable(String name)
    {
        try
        {
            Statement stmt = Setup.connection.createStatement();
            String sql = "CREATE TABLE "+name+" " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch (SQLException sqlExeption)
        {
            System.err.println(sqlExeption.getMessage()+sqlExeption.getStackTrace());
        }
    }
    public void FillValues(String name)
    {
        try
        {
            Statement stmt = Setup.connection.createStatement();
            String sql = "INSERT INTO "+name+" (ID,NAME,AGE) "
                    + "VALUES (1, 'sky', 28);";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO "+name+" (ID,NAME,AGE) "
                    + "VALUES (2, 'ihar', 30);";
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch (SQLException sqlExeption)
        {
            System.err.println(sqlExeption.getMessage()+sqlExeption.getStackTrace());
        }
    }

}
