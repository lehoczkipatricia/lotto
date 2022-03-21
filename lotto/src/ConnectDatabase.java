import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectDatabase {
    private Connection conn;
    public ConnectDatabase(){
        conn = null;
        connectToDatabase();
    }
    private void connectToDatabase(){
        String url = "jdbc:mariadb://localhost:3306/lotto";
        try {
            conn = DriverManager.getConnection(url, "root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(conn != null){
            System.out.println("ok");
        }
        else{
            System.out.println("nincs");
        }
    }
    public void closeConnect() {
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return conn;
    }
}
