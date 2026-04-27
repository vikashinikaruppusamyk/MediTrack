package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.AppointmentStatus;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;

public class AppointmentService {
    private DataStore<Appointment> appointmentDataStore = new DataStore<>();

    public void createAppointment(Appointment appointment){
        appointmentDataStore.add(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentDataStore.getAll();
    }

    public void cancelAppointment(String id) {
        Appointment appointment = findById(id);
        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment " + id + " not found!");
        }
        appointment.setStatus(AppointmentStatus.CANCELLED);
        System.out.println("Appointment cancelled successfully!");
    }
    public Appointment findById(String id){
        return appointmentDataStore.findById(a -> a.getId().equals(id));
    }
}
