package studentApp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT PLACEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Company");
            System.out.println("4. Assign Placement");
            System.out.println("5. View Placements");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    StudentDAO.addStudent(name, marks);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Company Name: ");
                    String cname = sc.nextLine();

                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();

                    System.out.print("Enter Package: ");
                    double pkg = sc.nextDouble();

                    CompanyDAO.addCompany(cname, role, pkg);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();

                    System.out.print("Enter Company ID: ");
                    int cid = sc.nextInt();

                    PlacementDAO.assignPlacement(sid, cid);
                    break;

                case 5:
                    PlacementDAO.viewPlacements();
                    break;

                case 6:
                    System.out.println("Exiting..");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void viewStudents() {
        try {
            var con = DBConnection.getConnection();
            var st = con.createStatement();
            var rs = st.executeQuery("SELECT * FROM students");

            System.out.println("\n===== STUDENT LIST =====");
            System.out.println("ID\tName\tMarks");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("marks")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
