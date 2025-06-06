
import java.io.IOException;
import java.util.Scanner;

public class App1_251 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("neighborhoods.txt");

        System.out.println("Welcome to Jeddah Municipality Complaint System");
        System.out.print("Are you an Applicant or Employee? (a/e): ");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("a")) {
            Applicate applicant = new Applicate(scanner, fileHandler);
            applicant.Applicnte_Complaint();
        } else if (role.equalsIgnoreCase("e")) {
            Employee employee = new Employee(scanner);
            employee.view_Update_Complaints();

        } else {
            System.out.println("Invalid role selected.");
        }

    }
    }