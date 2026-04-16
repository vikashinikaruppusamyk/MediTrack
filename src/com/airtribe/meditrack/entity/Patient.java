package com.airtribe.meditrack.entity;

public class Patient extends Person{
    private String patientId;
    private String medicalHistory;
    private String dateOfBirth;

    public Patient(String name, int age, String phone, String email, String patientId,String medicalHistory, String dateOfBirth){
        super(name,age,phone,email);
        this.patientId = patientId;
        this.dateOfBirth=dateOfBirth;
        this.medicalHistory = medicalHistory;
    }

    @Override
    public void displayInfo(){
        System.out.println("Patient Id: "+patientId);
        System.out.println("Name: "+getName());
        System.out.println("Medical History: "+medicalHistory);
        System.out.println("Date of Birth: "+dateOfBirth);
    }

    public void setPatientId(String patientId){
        this.patientId=patientId;
    }
    public String getPatientId(){
        return patientId;
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
