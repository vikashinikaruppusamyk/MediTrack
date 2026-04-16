package com.airtribe.meditrack.entity;

public class Doctor extends Person{
    private String doctorId;
    private String specialization;
    private double consultationFee;

    public Doctor(String name, int age, String phone, String email, String doctorId, String specialization, double consultationFee) {
        super(name, age, phone, email); // sends these 4 to Person's constructor
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    @Override
    public void displayInfo(){
        System.out.println("Doctor ID: "+doctorId);
        System.out.println("Name: " + getName());
        System.out.println("Specialization: "+specialization);
        System.out.println("Consultation Fee: "+consultationFee);
    }

    public String getDoctorId(){
        return doctorId;
    }
    public void setDoctorId(String doctorId){
        this.doctorId = doctorId;
    }

    public String getSpecialization(){
        return specialization;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public double getConsultationFee(){
        return consultationFee;
    }
    public void setConsultationFee(double consultationFee){
        this.consultationFee = consultationFee;
    }
}
