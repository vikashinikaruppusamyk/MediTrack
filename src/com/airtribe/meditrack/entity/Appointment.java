package com.airtribe.meditrack.entity;

public class Appointment extends MedicalEntity implements Cloneable{
    private Doctor doctor;
    private Patient patient;

    private String date;
    private AppointmentStatus status;

    public Appointment(String appointmentId, Doctor doctor, Patient patient, String date, AppointmentStatus status) {
        super(appointmentId);
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.status = status;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    public Doctor getDoctor(){
        return doctor;
    }

    public void setPatient(Patient patient){
        this.patient=patient;
    }
    public Patient getPatient(){
        return patient;
    }

    @Override
    public Appointment clone() {
        return new Appointment(
                getId(),
                doctor,              // same doctor reference is fine
                patient.clone(),     // deep copy patient
                new String(date),
                status
        );
    }

    @Override
    public void displayInfo(){
        System.out.println("Appointment ID: "+getId());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Patient: " + patient.getName());
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public AppointmentStatus getStatus() { return status; }
    public void setStatus(AppointmentStatus status) { this.status = status; }
}
