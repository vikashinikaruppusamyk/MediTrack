package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.Validator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing doctor records.
 * Handles add, search, delete and analytics operations.
 */
public class DoctorService {
    private DataStore<Doctor> doctorStore = new DataStore<>();

    /**
     * Adds a new doctor after validating all fields.
     * @param doctor the doctor to add
     */
    public void addDoctor(Doctor doctor) {
        Validator.validateName(doctor.getName());
        Validator.validateAge(doctor.getAge());
        Validator.validatePhone(doctor.getPhone());
        Validator.validateEmail(doctor.getEmail());
        doctorStore.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    /**
     * Returns all doctors in the system.
     * @return list of all doctors
     */
    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    /**
     * Searches for a doctor by their unique ID.
     * @param id the doctor ID
     * @return the doctor if found, null otherwise
     */
    public Doctor searchById(String id) {
        return doctorStore.findById(p -> p.getId().equals(id));
    }

    /**
     * Searches for a doctor by name.
     * @param name the doctor name
     * @return the doctor if found, null otherwise
     */
    public Doctor searchByName(String name) {
        return doctorStore.findById(p -> p.getName().equals(name));
    }

    /**
     * Deletes a doctor by their unique ID.
     * @param id the doctor ID to delete
     */
    public void deleteDoctor(String id) {
        doctorStore.delete(d -> d.getId().equals(id));
        System.out.println("Doctor deleted successfully!");
    }

    /**
     * Filters doctors by their specialization.
     * @param specialization the specialization to filter by
     * @return list of doctors with matching specialization
     */
    public List<Doctor> filterBySpecialization(String specialization) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getSpecialization().equals(specialization))
                .collect(Collectors.toList());
    }

    /**
     * Computes the average consultation fee across all doctors.
     * @return average consultation fee
     */
    public double getAverageConsultationFee() {
        return doctorStore.getAll()
                .stream()
                .mapToDouble(Doctor::getConsultationFee)
                .average()
                .orElse(0.0);
    }

    /**
     * Returns the total number of doctors in the system.
     * @return total doctor count
     */
    public long countDoctors() {
        return doctorStore.getAll()
                .stream()
                .count();
    }
}