package com.airtribe.meditrack.entity;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String appointmentId;
    private String date;
    private AppointmentStatus status;

    public Appointment(String appointmentId, Doctor doctor, Patient patient, String date, AppointmentStatus status) {
        this.appointmentId = appointmentId;
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

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public AppointmentStatus getStatus() { return status; }
    public void setStatus(AppointmentStatus status) { this.status = status; }
}
