package studentApp;
import java.sql.*;

public class PlacementDAO {

    public static void assignPlacement(int studentId, int companyId) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO placements(student_id, company_id) VALUES (?, ?)"
            );

            ps.setInt(1, studentId);
            ps.setInt(2, companyId);

            ps.executeUpdate();
            System.out.println("Placement Assigned ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void viewPlacements() {
        try {
            Connection con = DBConnection.getConnection();

            String query = """
                SELECT s.name, c.name, c.role, c.package
                FROM placements p
                JOIN students s ON p.student_id = s.id
                JOIN companies c ON p.company_id = c.id
            """;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\nStudent | Company | Role | Package");

            while (rs.next()) {
                System.out.println(
                    rs.getString(1) + " → " +
                    rs.getString(2) + " → " +
                    rs.getString(3) + " → " +
                    rs.getDouble(4)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
