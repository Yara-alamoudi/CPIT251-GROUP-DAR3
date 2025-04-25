
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maysqh
 */
public class Applicate {

    private final Scanner scanner;
    private final FileHandler fileHandler;

    public Applicate(Scanner scanner, FileHandler fileHandler) {
        this.scanner = scanner;
        this.fileHandler = fileHandler;
    }
    private String getUserId() {
        System.out.print("Enter your National ID: ");
        return scanner.nextLine();
    }
           private boolean Previous_Complaints(String userId) throws IOException {
        File currentDir = new File(".");
        File[] files = currentDir.listFiles();
        boolean found = false;
    
        if (files != null && files.length > 0) {
            for (File file : files) {
                String fileName = file.getName();
                if (fileName.startsWith("complaint_" + userId + "_") && fileName.endsWith(".txt")) {
                    if (!found) {
                        System.out.println("You have previous complaints:");
                        found = true;
                    }
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("Status:")) {
                            System.out.println(" - " + file.getName() + " | " + line);
                            break;
                        }
                    }
                    reader.close();
                }
            }
        }
        return found;
    }
}
private boolean Submit_Complaint() {
    System.out.print("Do you want to submit a new complaint? (yes/no): ");
    String choice = scanner.nextLine();
    return choice.equalsIgnoreCase("yes");
}
private Form createForm(String userId) {
    System.out.print("Enter your neighborhood name: ");
    String neighborhood = scanner.nextLine();

    String phone = fileHandler.getPhoneNumber(neighborhood);
    if (phone == null) {
        System.out.println("Neighborhood not found.");
        return null;
    }

    System.out.println("Contact number for " + neighborhood + ": " + phone);

    return new Form(scanner, userId, neighborhood, phone);
}//