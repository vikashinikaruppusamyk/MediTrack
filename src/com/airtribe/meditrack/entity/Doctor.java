package com.airtribe.meditrack.entity;

public class Doctor extends Person{
    private String doctorId;
    private String specialization;
    private double consultationFee;

    public Doctor(String id, String name, int age, String phone, String email, String specialization, double consultationFee) {
        super(id, name, age, phone, email);
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
