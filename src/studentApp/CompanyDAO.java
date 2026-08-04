package studentApp;

import java.sql.*;

public class CompanyDAO {

    public static void addCompany(String name, String role, double pkg) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO companies(name, role, package) VALUES (?, ?, ?)"
            );

            ps.setString(1, name);
            ps.setString(2, role);
            ps.setDouble(3, pkg);

            ps.executeUpdate();
            System.out.println("Company Added ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}