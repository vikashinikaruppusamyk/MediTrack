package com.airtribe.meditrack;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.util.Validator;
import java.util.Scanner;

public class Main {

    static {
        System.out.println("MediTrack system initializing...");
        System.out.println("Loading configuration...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();

        if (args.length > 0 && args[0].equals("--loadData")) {
            System.out.println("Loading data from CSV...");
            CSVUtil.loadPatients().forEach(p -> patientService.addPatient(p));
            CSVUtil.loadDoctors().forEach(d -> doctorService.addDoctor(d));
            System.out.println("Data loaded successfully!");
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== MediTrack ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> handlePatientMenu(scanner, patientService);
                case 2 -> handleDoctorMenu(scanner, doctorService);
                case 3 -> handleAppointmentMenu(scanner, appointmentService, doctorService, patientService);
                case 4 -> System.out.println("Billing coming soon!");
                case 5 -> { System.out.println("Goodbye!"); running = false; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void handlePatientMenu(Scanner scanner, PatientService patientService) {
        System.out.println("\n=== Patient Management ===");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Search by ID");
        System.out.println("4. Search by Name");
        System.out.println("5. Search by Age");
        System.out.println("6. Delete Patient");
        System.out.println("7. Save Patients to CSV");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addPatient(scanner, patientService);
            case 2 -> patientService.getAllPatients().forEach(p -> p.displayInfo());
            case 3 -> {
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();
                Patient p = patientService.searchById(id);
                if (p != null) p.displayInfo();
                else System.out.println("Patient not found!");
            }
            case 4 -> {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                Patient p = patientService.searchByName(name);
                if (p != null) p.displayInfo();
                else System.out.println("Patient not found!");
            }
            case 5 -> {
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                patientService.searchByAge(age).forEach(p -> p.displayInfo());
            }
            case 6 -> {
                System.out.print("Enter ID to delete: ");
                String id = scanner.nextLine();
                patientService.deletePatient(id);
            }
            case 7 -> CSVUtil.savePatients(patientService.getAllPatients());
        }
    }

    private static void addPatient(Scanner scanner, PatientService patientService) {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            Validator.validateName(name);

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            Validator.validateAge(age);

            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();
            Validator.validatePhone(phone);

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            Validator.validateEmail(email);

            System.out.print("Enter Medical History: ");
            String medicalHistory = scanner.nextLine();

            System.out.print("Enter Date of Birth: ");
            String dob = scanner.nextLine();

            String id = IdGenerator.generatePatientId();
            Patient patient = new Patient(id, name, age, phone, email, medicalHistory, dob);
            patientService.addPatient(patient);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
    private static void handleDoctorMenu(Scanner scanner, DoctorService doctorService) {
        System.out.println("\n=== Doctor Management ===");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.println("3. Search by ID");
        System.out.println("4. Search by Name");
        System.out.println("5. Delete Doctor");
        System.out.println("6. Save Doctors to CSV");
        System.out.println("7. Filter by Specialization");
        System.out.println("8. Average Consultation Fee");
        System.out.println("9. Total Doctors");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addDoctor(scanner, doctorService);
            case 2 -> doctorService.getAllDoctors().forEach(d -> d.displayInfo());
            case 3 -> {
                System.out.print("Enter ID: ");
                String id = scanner.nextLine();
                Doctor d = doctorService.searchById(id);
                if (d != null) d.displayInfo();
                else System.out.println("Doctor not found!");
            }
            case 4 -> {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                Doctor d = doctorService.searchByName(name);
                if (d != null) d.displayInfo();
                else System.out.println("Doctor not found!");
            }
            case 5 -> {
                System.out.print("Enter ID to delete: ");
                String id = scanner.nextLine();
                doctorService.deleteDoctor(id);
            }
            case 6 -> CSVUtil.saveDoctors(doctorService.getAllDoctors());
            case 7 -> {
                System.out.print("Enter Specialization: ");
                String spec = scanner.nextLine();
                doctorService.filterBySpecialization(spec).forEach(d -> d.displayInfo());
            }
            case 8 -> System.out.println("Average Fee: " + doctorService.getAverageConsultationFee());
            case 9 -> System.out.println("Total Doctors: " + doctorService.countDoctors());
        }
    }

    private static void addDoctor(Scanner scanner, DoctorService doctorService) {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            Validator.validateName(name);

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            Validator.validateAge(age);

            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();
            Validator.validatePhone(phone);

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            Validator.validateEmail(email);

            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();

            System.out.print("Enter Consultation Fee: ");
            double fee = scanner.nextDouble();
            scanner.nextLine();

            String id = IdGenerator.generateDoctorId();
            Doctor doctor = new Doctor(id, name, age, phone, email, specialization, fee);
            doctorService.addDoctor(doctor);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    private static void handleAppointmentMenu(Scanner scanner, AppointmentService appointmentService,
                                              DoctorService doctorService, PatientService patientService) {
        System.out.println("\n=== Appointment Management ===");
        System.out.println("1. Create Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Cancel Appointment");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> createAppointment(scanner, appointmentService, doctorService, patientService);
            case 2 -> appointmentService.getAllAppointments().forEach(a -> a.displayInfo());
            case 3 -> {
                System.out.print("Enter Appointment ID to cancel: ");
                String id = scanner.nextLine();
                appointmentService.cancelAppointment(id);
            }
        }
    }

    private static void createAppointment(Scanner scanner, AppointmentService appointmentService,
                                          DoctorService doctorService, PatientService patientService) {
        try {
            System.out.print("Enter Doctor ID: ");
            String doctorId = scanner.nextLine();
            Doctor doctor = doctorService.searchById(doctorId);
            if (doctor == null) { System.out.println("Doctor not found!"); return; }

            System.out.print("Enter Patient ID: ");
            String patientId = scanner.nextLine();
            Patient patient = patientService.searchById(patientId);
            if (patient == null) { System.out.println("Patient not found!"); return; }

            System.out.print("Enter Date (DD-MM-YYYY): ");
            String date = scanner.nextLine();

            String id = IdGenerator.generateAppointmentId();
            Appointment appointment = new Appointment(id, doctor, patient, date, AppointmentStatus.PENDING);
            appointmentService.createAppointment(appointment);
            System.out.println("Appointment created successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}