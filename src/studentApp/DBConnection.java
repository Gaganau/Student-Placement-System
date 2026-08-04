package studentApp;
import java.sql.*;
public class DBConnection {
    static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_managment",
                    "root",
                    "Gaganau@2004"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
