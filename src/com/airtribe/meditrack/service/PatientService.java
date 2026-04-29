package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing patient records.
 * Handles add, search, delete and analytics operations.
 */
public class PatientService {
    private DataStore<Patient> patientStore = new DataStore<>();

    /**
     * Adds a new patient after validating all fields.
     * @param patient the patient to add
     */
    public void addPatient(Patient patient) {
        Validator.validateName(patient.getName());
        Validator.validateAge(patient.getAge());
        Validator.validatePhone(patient.getPhone());
        Validator.validateEmail(patient.getEmail());
        patientStore.add(patient);
        System.out.println("Patient added successfully!");
    }

    /**
     * Returns all patients in the system.
     * @return list of all patients
     */
    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }

    /**
     * Searches for a patient by their unique ID.
     * @param id the patient ID
     * @return the patient if found, null otherwise
     */
    public Patient searchById(String id) {
        return patientStore.findById(p -> p.getId().equals(id));
    }

    /**
     * Searches for a patient by name.
     * @param name the patient name
     * @return the patient if found, null otherwise
     */
    public Patient searchByName(String name) {
        return patientStore.findById(p -> p.getName().equals(name));
    }

    /**
     * Searches for patients by age.
     * @param age the age to search for
     * @return list of patients with matching age
     */
    public List<Patient> searchByAge(int age) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patientStore.getAll()) {
            if (p.getAge() == age) {
                result.add(p);
            }
        }
        return result;
    }

    /**
     * Deletes a patient by their unique ID.
     * @param id the patient ID to delete
     */
    public void deletePatient(String id) {
        patientStore.delete(p -> p.getId().equals(id));
        System.out.println("Patient deleted successfully!");
    }
}