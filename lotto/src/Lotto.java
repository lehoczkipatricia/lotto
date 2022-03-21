import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Lotto {

    private static Vector<String> numbers;
    
    public static void main(String[] args) throws Exception{
        numbers = new Vector<>();
        Reader reader = new Reader();
        numbers = reader.readFile();
        ConnectDatabase connDb = new ConnectDatabase();
        Connection conn = connDb.getConnection();

        numbers.forEach(rows -> rowsToDatabase(conn, rows));
    }

    private static void rowsToDatabase( Connection conn, String row) {

        String sql = "INSERT INTO drawed (draw) VALUES ('" + row + "');";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
