package com.airtribe.meditrack.util;

public class IdGenerator {
    private static int doctorCount = 0;
    private static int patientCount = 0;
    private static int appointmentCount = 0;
    private static int billCount = 0;
    public static String generateDoctorId() {
        return String.format("D%03d", ++doctorCount);
    }
    public static String generatePatientId() {
        return String.format("P%03d", ++patientCount);
    }
    public static String generateAppointmentId() {
        return String.format("A%03d", ++appointmentCount);
    }
    public static String generateBillId() {
        return String.format("B%03d", ++billCount);
    }

}
