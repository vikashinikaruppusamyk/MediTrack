package com.airtribe.meditrack.test;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.IdGenerator;

public class TestRunner {

    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        System.out.println("=== MediTrack Test Runner ===\n");
        testAddPatient();
        testSearchPatientById();
        testCancelAppointment();
        testInvalidAge();
        System.out.println("\n=== Results: " + passed + " passed, " + failed + " failed ===");
    }

    static void assert_true(String testName, boolean condition) {
        if (condition) {
            System.out.println("✅ PASSED: " + testName);
            passed++;
        } else {
            System.out.println("❌ FAILED: " + testName);
            failed++;
        }
    }
    static void testAddPatient() {
        PatientService patientService = new PatientService();
        Patient patient = new Patient(IdGenerator.generatePatientId(), "John", 25,
                "9876543210", "john@email.com", "Fever", "01-01-1999");
        patientService.addPatient(patient);
        assert_true("Add Patient", patientService.getAllPatients().size() == 1);
    }

    static void testSearchPatientById() {
        PatientService patientService = new PatientService();
        String id = IdGenerator.generatePatientId();
        Patient patient = new Patient(id, "Jane", 30,
                "9876543211", "jane@email.com", "Diabetes", "15-06-1994");
        patientService.addPatient(patient);
        Patient found = patientService.searchById(id);
        assert_true("Search Patient By ID", found != null && found.getName().equals("Jane"));
    }

    static void testCancelAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Doctor doctor = new Doctor(IdGenerator.generateDoctorId(), "Dr Smith", 45,
                "9876543212", "smith@email.com", "Cardiology", 500.0);
        Patient patient = new Patient(IdGenerator.generatePatientId(), "John", 25,
                "9876543210", "john@email.com", "Fever", "01-01-1999");
        Appointment appointment = new Appointment(IdGenerator.generateAppointmentId(),
                doctor, patient, "29-04-2026", AppointmentStatus.PENDING);
        appointmentService.createAppointment(appointment);
        appointmentService.cancelAppointment(appointment.getId());
        assert_true("Cancel Appointment", appointment.getStatus() == AppointmentStatus.CANCELLED);
    }

    static void testInvalidAge() {
        try {
            com.airtribe.meditrack.util.Validator.validateAge(-5);
            assert_true("Invalid Age Rejected", false);
        } catch (IllegalArgumentException e) {
            assert_true("Invalid Age Rejected", true);
        }
    }
}