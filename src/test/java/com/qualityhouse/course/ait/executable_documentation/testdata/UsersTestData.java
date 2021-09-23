package com.qualityhouse.course.ait.executable_documentation.testdata;

import java.util.HashMap;

public class UsersTestData {

    private static HashMap<String, String[]> users = new HashMap<String, String[]>();

    static {
        users.put("User1", new String[] {"student1", "stpass1", "Student One", "student1@example.com", "+111", "Student Str. 1"});
        users.put("User2", new String[] {"student2", "stpass2", "Student Two", "student2@example.com", "+222", "Student Str. 2"});
        users.put("User3", new String[] {"student3", "stpass3", "Student Three", "student3@example.com", "+333", "Student Str. 3"});
        users.put("User4", new String[] {"student4", "stpass4", "Student Four", "student4@example.com", "+444", "Student Str. 4"});
        users.put("User5", new String[] {"student5", "stpass5", "Student Five", "student5@example.com", "+555", "Student Str. 5"});

        users.put("Invalid User", new String[] {"student1","wrong password","","","",""});
    }

    /* users actions */
    public static String getUsername(String user) {
        if (!users.containsKey(user))
            throw new NullPointerException("User '" + user + "' not found.");
        return users.get(user)[0];
    }

    public static String getPassword(String user) {
        if (!users.containsKey(user))
            throw new NullPointerException("User '" + user + "' not found.");
        return users.get(user)[1];
    }

    public static String getName(String user) {
        if (!users.containsKey(user))
            throw new NullPointerException("User '" + user + "' not found.");
        return users.get(user)[2];
    }

    public static String getEmail(String user) {
        if (!users.containsKey(user))
            throw new NullPointerException("User '" + user + "' not found.");
        return users.get(user)[3];
    }

    public static String getPhone(String user) {
        if (!users.containsKey(user))
            throw new NullPointerException("User '" + user + "' not found.");
        return users.get(user)[4];
    }

    public static String getAddress(String user) {
        if (!users.containsKey(user))
            throw new NullPointerException("User '" + user + "' not found.");
        return users.get(user)[5];
    }
}
