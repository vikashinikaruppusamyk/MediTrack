package com.airtribe.meditrack.util;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.entity.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    // Write patients to CSV
    public static void savePatients(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.PATIENTS_FILE))) {
            for (Patient p : patients) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getAge() + ","
                        + p.getPhone() + "," + p.getEmail() + ","
                        + p.getMedicalHistory() + "," + p.getDateOfBirth());
                writer.newLine();
            }
            System.out.println("Patients saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving patients: " + e.getMessage());
        }
    }
    public static void saveDoctors(List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.DOCTORS_FILE))) {
            for (Doctor d : doctors) {
                writer.write(d.getId() + "," + d.getName() + "," + d.getAge() + ","
                        + d.getPhone() + "," + d.getEmail() + ","
                        + d.getSpecialization() + "," + d.getConsultationFee());
                writer.newLine();
            }
            System.out.println("Doctors saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving doctors: " + e.getMessage());
        }
    }
    public static List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.PATIENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Patient p = new Patient(parts[0], parts[1], Integer.parseInt(parts[2]),
                        parts[3], parts[4], parts[5], parts[6]);
                patients.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error loading patients: " + e.getMessage());
        }
        return patients;
    }

    public static List<Doctor> loadDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.DOCTORS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Doctor d = new Doctor(parts[0], parts[1], Integer.parseInt(parts[2]),
                        parts[3], parts[4], parts[5], Double.parseDouble(parts[6]));
                doctors.add(d);
            }
        } catch (IOException e) {
            System.out.println("Error loading doctors: " + e.getMessage());
        }
        return doctors;
    }
}