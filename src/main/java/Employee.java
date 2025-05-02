import java.io.IOException;
import java.util.Scanner;

public class Employee {
     private final Scanner scanner;

    public Employee(Scanner scanner) {
        this.scanner = scanner;
    }

    public void view_Update_Complaints() throws IOException {
        System.out.print("1. View complaints\n2. Update complaint status\nChoose option: ");
        String option = scanner.nextLine();

        if (option.equals("1")) {
            Form.printAllForms();
        } else if (option.equals("2")) {
            System.out.print("Enter file name to update: ");
            String fileName = scanner.nextLine();
            System.out.print("Enter new status: ");
            String status = scanner.nextLine();
            Form.updateStatus(fileName, status);
        } else {
            System.out.println("Invalid option.");
        }
    }
}