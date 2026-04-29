package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;

import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.Validator;
import java.util.stream.Collectors;
import java.util.List;

public class DoctorService {
    private DataStore<Doctor> doctorStore = new DataStore<>();
    public void addDoctor(Doctor doctor) {
        Validator.validateName(doctor.getName());
        Validator.validateAge(doctor.getAge());
        Validator.validatePhone(doctor.getPhone());
        Validator.validateEmail(doctor.getEmail());
        doctorStore.add(doctor);
        System.out.println("Doctor added successfully!");
    }
    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    public Doctor searchById(String id) {
        return doctorStore.findById(p -> p.getId().equals(id));
    }

    public Doctor searchByName(String name) {
        return doctorStore.findById(p -> p.getName().equals(name));
    }

    public void deleteDoctor(String id) {
        doctorStore.delete(d -> d.getId().equals(id));
        System.out.println("Doctor deleted successfully!");
    }
    public List<Doctor> filterBySpecialization(String specialization) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getSpecialization().equals(specialization))
                .collect(Collectors.toList());
    }
    public double getAverageConsultationFee() {
        return doctorStore.getAll()
                .stream()
                .mapToDouble(Doctor::getConsultationFee)
                .average()
                .orElse(0.0);
    }
    public long countDoctors() {
        return doctorStore.getAll()
                .stream()
                .count();
    }
}
