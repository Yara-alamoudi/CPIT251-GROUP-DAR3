package com.mycompany.cpit251_test;

import java.io.*;
import java.util.*;

class FileHandler {
    private final Map<String, String> contactMap = new HashMap<>();

    public FileHandler(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                contactMap.put(parts[0].trim().toLowerCase(), parts[1].trim());
            }
        }
        reader.close();
    }
}