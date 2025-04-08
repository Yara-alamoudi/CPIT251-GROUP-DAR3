import java.io.*;
import java.util.*;

public class MunicipalityApp {
    public static void main(String[] args) throws IOException {
        new App().run();
    }
}

class App {
    private static final String CONTACT_FILE = "contacts.txt";
    private static final String USER_FILE = "users.txt";
    private static final String SIGNUP_FILE = "signup_requests.txt";

    private ContactManager contactManager = new ContactManager(CONTACT_FILE);

    public void run() throws IOException {
        System.out.println("Welcome to Jeddah Municipality System\n");

        File inputFile = new File(SIGNUP_FILE);
        if (!inputFile.exists()) {
            System.out.println("signup_requests.txt not found.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length != 2) continue;

            String userId = parts[0].trim();
            String neighborhood = parts[1].trim();

            signUpUser(userId, neighborhood);
            searchNeighborhoodContact(neighborhood);
            System.out.println("--------------------------------------------------");
        }
        reader.close();
    }

    private void signUpUser(String userId, String neighborhood) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true));
        writer.write(userId + "," + neighborhood + "\n");
        writer.close();
        System.out.println(" Signed up user: " + userId + " from " + neighborhood);
    }

    private void searchNeighborhoodContact(String neighborhood) throws IOException {
        String phone = contactManager.getPhoneNumber(neighborhood);
        if (phone != null) {
            System.out.println(" Contact number for " + neighborhood + ": " + phone);
        } else {
            System.out.println("️ No contact number found for " + neighborhood);
        }
    }
}

class ContactManager {
    private final String contactFile;

    public ContactManager(String contactFile) {
        this.contactFile = contactFile;
    }

    public String getPhoneNumber(String neighborhood) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(contactFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length == 2 && parts[0].trim().equalsIgnoreCase(neighborhood.trim())) {
                reader.close();
                return parts[1].trim();
            }
        }
        reader.close();
        return null;
    }
}
