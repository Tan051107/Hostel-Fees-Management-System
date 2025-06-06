/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sylvester
 */
public class UserLoader {
    private String filePath;

    public UserLoader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> loadUsers(boolean includeAll, boolean onlyUnapproved, List<String> rolesFilter) {
        List<String[]> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; 
                    continue;
                }
                String[] userDetails = line.split(",");
                if (userDetails.length == 8) {
                    String status = userDetails[7];
                    String role = userDetails[2];

                    boolean isStatusMatch = includeAll || (onlyUnapproved && status.equalsIgnoreCase("Not Approved"));
                    boolean isRoleMatch = rolesFilter == null || rolesFilter.isEmpty() || rolesFilter.contains(role);

                    if (isStatusMatch && isRoleMatch) {
                        users.add(userDetails);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return users;
    }
}


class ManagerUserLoader extends UserLoader {
    public ManagerUserLoader(String filePath) {
        super(filePath);
    }

    public List<String[]> loadAllUsers() {
        return loadUsers(true, false, null); // Include all users regardless of status
    }

    public List<String[]> loadUnapprovedUsers() {
        return loadUsers(false, true, null); // Only load unapproved users
    }
}


class AssistantUserLoader extends UserLoader {
    public AssistantUserLoader(String filePath) {
        super(filePath);
    }

    public List<String[]> loadAllUsers() {
        return loadUsers(true, false, Arrays.asList("Staff", "Resident")); // Load all users with specific roles
    }

    public List<String[]> loadUnapprovedUsers() {
        return loadUsers(false, true, Arrays.asList("Staff", "Resident")); // Load only unapproved users with specific roles
    }
}
