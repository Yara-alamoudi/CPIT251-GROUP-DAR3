
    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String line : content) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
        System.out.println("Complaint submitted ");
    }
}
