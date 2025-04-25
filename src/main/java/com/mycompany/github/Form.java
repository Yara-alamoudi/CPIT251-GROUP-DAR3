/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.github;

/**
 *
 * @author Yaraa
 */
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
        this.fileName = "complaint_" + userId + "_" + System.currentTimeMillis() + ".txt" ;
}
}