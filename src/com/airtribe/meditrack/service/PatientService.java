package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private DataStore<Patient> patientStore = new DataStore<>();

    public void addPatient(Patient patient) {
        Validator.validateName(patient.getName());
        Validator.validateAge(patient.getAge());
        Validator.validatePhone(patient.getPhone());
        Validator.validateEmail(patient.getEmail());
        patientStore.add(patient);
        System.out.println("Patient added successfully!");
    }
    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }
    public List<Patient> searchByAge(int age) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patientStore.getAll()) {
            if (p.getAge() == age) {
                result.add(p);
            }
        }
        return result;
    }
    public void deletePatient(String id) {
        patientStore.delete(p -> p.getId().equals(id));
        System.out.println("Patient deleted successfully!");
    }

    public Patient searchById(String id) {
        return patientStore.findById(p -> p.getId().equals(id));
    }

    public Patient searchByName(String name) {
        return patientStore.findById(p -> p.getName().equals(name));
    }
}