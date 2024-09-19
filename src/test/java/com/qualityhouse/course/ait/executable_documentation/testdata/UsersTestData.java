package com.qualityhouse.course.ait.executable_documentation.testdata;

import com.qualityhouse.course.ait.executable_documentation.testdata.models.User;

import java.util.HashMap;

public class UsersTestData {

    private static HashMap<String, User> users = new HashMap<>();

    static {
        // Populate users using the builder pattern
        users.put("User1", new User.UserBuilder()
                .setUsername("student1")
                .setPassword("stpass1")
                .setName("Student One")
                .setEmail("student1@example.com")
                .setPhone("+111")
                .setAddress("Student Str. 1")
                .build());

        users.put("User2", new User.UserBuilder()
                .setUsername("student2")
                .setPassword("stpass2")
                .setName("Student Two")
                .setEmail("student2@example.com")
                .setPhone("+222")
                .setAddress("Student Str. 2")
                .build());

        users.put("User3", new User.UserBuilder()
                .setUsername("student3")
                .setPassword("stpass3")
                .setName("Student Three")
                .setEmail("student3@example.com")
                .setPhone("+333")
                .setAddress("Student Str. 3")
                .build());

        users.put("User4", new User.UserBuilder()
                .setUsername("student4")
                .setPassword("stpass4")
                .setName("Student Four")
                .setEmail("student4@example.com")
                .setPhone("+444")
                .setAddress("Student Str. 4")
                .build());

        users.put("User5", new User.UserBuilder()
                .setUsername("student5")
                .setPassword("stpass5")
                .setName("Student Five")
                .setEmail("student5@example.com")
                .setPhone("+555")
                .setAddress("Student Str. 5")
                .build());

        users.put("Invalid User", new User.UserBuilder()
                .setUsername("student1")
                .setPassword("wrong password")
                .build());
    }

    /* User actions */
    public static String getUsername(String user) {
        if (!users.containsKey(user)) {
            throw new NullPointerException("User '" + user + "' not found.");
        }
        return users.get(user).getUsername();
    }

    public static String getPassword(String user) {
        if (!users.containsKey(user)) {
            throw new NullPointerException("User '" + user + "' not found.");
        }
        return users.get(user).getPassword();
    }

    public static String getName(String user) {
        if (!users.containsKey(user)) {
            throw new NullPointerException("User '" + user + "' not found.");
        }
        return users.get(user).getName();
    }

    public static String getEmail(String user) {
        if (!users.containsKey(user)) {
            throw new NullPointerException("User '" + user + "' not found.");
        }
        return users.get(user).getEmail();
    }

    public static String getPhone(String user) {
        if (!users.containsKey(user)) {
            throw new NullPointerException("User '" + user + "' not found.");
        }
        return users.get(user).getPhone();
    }

    public static String getAddress(String user) {
        if (!users.containsKey(user)) {
            throw new NullPointerException("User '" + user + "' not found.");
        }
        return users.get(user).getAddress();
    }
}
