import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Form {
     private final Scanner scanner;
    private final String userId;
    private final String neighborhood;
    private final String phone;
    private final String fileName;
    private final List<String> content = new ArrayList<>();

    public Form(Scanner scanner, String userId, String neighborhood, String phone) {
        this.scanner = scanner;
        this.userId = userId;
        this.neighborhood = neighborhood;
        this.phone = phone;
        this.fileName = "complaint_" + userId + "_" + System.currentTimeMillis() + ".txt";
    }

    public void fill() {
        System.out.print("Describe your issue: ");
        String issue = scanner.nextLine();

        System.out.print("When did it start?: ");
        String startDate = scanner.nextLine();

        System.out.print("Is it still ongoing? ");
        String ongoing = scanner.nextLine();

        content.add("User ID: " + userId);
        content.add("Neighborhood: " + neighborhood);
        content.add("Phone Contact: " + phone);
        content.add("Date: " + new Date());
        content.add("");
        content.add("Complaint:");
        content.add("Issue: " + issue);
        content.add("Start Date: " + startDate);
        content.add("Ongoing: " + ongoing);
        content.add("Status: Submitted");
    }

    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String line : content) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
        System.out.println("Complaint submitted ");
    }

    public static void printAllForms() throws IOException {
        File currentDir = new File(".");
        File[] files = currentDir.listFiles((dir, name) -> name.startsWith("complaint_") && name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No complaints found.");
            return;
        }

        for (File file : files) {
            System.out.println("\n--- " + file.getName() + " ---");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
    }

    public static void updateStatus(String fileName, String newStatus) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Status:")) {
                lines.add("Status: " + newStatus);
            } else {
                lines.add(line);
            }
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (String l : lines) {
            writer.write(l);
            writer.newLine();
        }
        writer.close();

        System.out.println("Status updated. User will be notified.");
    }
}