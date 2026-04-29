package com.airtribe.meditrack.entity;
/**
 * Represents a patient in the MediTrack system.
 * Extends Person with medical history and date of birth.
 */
public class Patient extends Person implements Cloneable {
    private String medicalHistory;
    private String dateOfBirth;
    /**
     * Creates a new Patient with the given details.
     * @param id unique identifier
     * @param name full name
     * @param age age in years
     * @param phone 10-digit phone number
     * @param email valid email address
     * @param medicalHistory patient's medical history
     * @param dateOfBirth patient's date of birth
     */
    public Patient(String id, String name, int age, String phone, String email, String medicalHistory, String dateOfBirth){
        super(id, name, age, phone, email);
        this.dateOfBirth = dateOfBirth;
        this.medicalHistory = medicalHistory;
    }

    /**
     * Creates and returns a deep copy of this patient.
     * @return deep copied Patient object
     */
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
    /**
     * Displays the patient's information to the console.
     */
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
