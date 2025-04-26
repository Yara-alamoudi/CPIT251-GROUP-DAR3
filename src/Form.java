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