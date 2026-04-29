package com.airtribe.meditrack.entity;
/**
 * Abstract base class representing a person in the MediTrack system.
 */
public abstract class Person {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String email;
    /**
     * Creates a new Person with the given details.
     * @param id unique identifier
     * @param name full name
     * @param age age in years
     * @param phone 10-digit phone number
     * @param email valid email address
     */
    public Person(String id, String name, int age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
    /**
     * Displays the person's information to the console.
     */
    public abstract void displayInfo();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}