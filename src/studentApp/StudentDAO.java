package studentApp;

import java.sql.*;

public class StudentDAO {

    public static void addStudent(String name, int marks) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name, marks) VALUES (?, ?)"
            );

            ps.setString(1, name);
            ps.setInt(2, marks);

            ps.executeUpdate();
            System.out.println("Student Added ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}