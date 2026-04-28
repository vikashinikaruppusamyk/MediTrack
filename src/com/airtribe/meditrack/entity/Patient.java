package com.airtribe.meditrack.entity;

public class Patient extends Person implements Cloneable {
    private String medicalHistory;
    private String dateOfBirth;

    public Patient(String id, String name, int age, String phone, String email, String medicalHistory, String dateOfBirth){
        super(id, name, age, phone, email);
        this.dateOfBirth = dateOfBirth;
        this.medicalHistory = medicalHistory;
    }
    @Override
    public Patient clone() {
        return new Patient(
                getId(),
                getName(),
                getAge(),
                getPhone(),
                getEmail(),
                new String(medicalHistory),
                new String(dateOfBirth)
        );
    }
    @Override
    public void displayInfo(){
        System.out.println("Patient Id: " + getId()); // use getId() from Person
        System.out.println("Name: " + getName());
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Date of Birth: " + dateOfBirth);
    }

    public void setMedicalHistory(String medicalHistory){
        this.medicalHistory=medicalHistory;
    }
    public String getMedicalHistory(){
        return medicalHistory;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
}
