package com.airtribe.meditrack.entity;
/**
 * Represents an appointment between a doctor and patient.
 * Extends MedicalEntity and implements Cloneable.
 */
public class Appointment extends MedicalEntity implements Cloneable{
    private Doctor doctor;
    private Patient patient;

    private String date;
    private AppointmentStatus status;
    /**
     * Creates a new Appointment with the given details.
     * @param appointmentId unique identifier
     * @param doctor the assigned doctor
     * @param patient the assigned patient
     * @param date appointment date
     * @param status current appointment status
     */
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

    /**
     * Creates and returns a deep copy of this appointment.
     * @return deep copied Appointment object
     */
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
    /**
     * Displays the appointment's information to the console.
     */
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
