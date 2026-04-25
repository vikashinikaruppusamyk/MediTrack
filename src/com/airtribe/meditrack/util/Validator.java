package com.airtribe.meditrack.util;

public class Validator {

    public static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
    }

    public static void validateAge(int age) {
        if (age <= 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 1 and 150!");
        }
    }

    public static void validatePhone(String phone){
        if(phone.length()!=10){
            throw new IllegalArgumentException("Phone number must contain 10 digits!");
        }
    }

    public static void validateEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address!");
        }
    }

    public static void validateId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be empty!");
        }
    }
}