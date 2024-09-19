package com.qualityhouse.course.ait.executable_documentation.testdata.models;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;

    // Private constructor
    private User() {}

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Inner Builder class
    public static class UserBuilder {
        private String username;
        private String password;
        private String name;
        private String email;
        private String phone;
        private String address;

        // Builder methods
        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        // Build method to create a User object
        public User build() {
            User user = new User();
            user.username = this.username;
            user.password = this.password;
            user.name = this.name;
            user.email = this.email;
            user.phone = this.phone;
            user.address = this.address;
            return user;
        }
    }
}

