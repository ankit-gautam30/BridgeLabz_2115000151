import java.util.ArrayList;
import java.util.List;

// Patient class
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);
        }
    }

    public String getName() {
        return name;
    }

    public void listDoctors() {
        System.out.println("Patient: " + name);
        for (Doctor doctor : doctors) {
            System.out.println("  Consulted Doctor: " + doctor.getName());
        }
    }
}

// Doctor class
class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting with " + patient.getName());
        addPatient(patient);
    }

    public void listPatients() {
        System.out.println("Doctor: " + name);
        for (Patient patient : patients) {
            System.out.println("  Patient: " + patient.getName());
        }
    }
}

// Hospital class
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void listHospitalDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  " + doctor.getName());
        }
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("  " + patient.getName());
        }
    }
}

// Main class to demonstrate association and communication
public class HospitalSystem {
    public static void main(String[] args) {
        // Creating a hospital
        Hospital hospital = new Hospital("City Hospital");

        // Creating doctors
        Doctor doctor1 = new Doctor("Dr. Adams");
        Doctor doctor2 = new Doctor("Dr. Brown");
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Creating patients
        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Patients consulting doctors
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        // Displaying hospital details
        hospital.listHospitalDetails();
        System.out.println();

        // Displaying doctor-patient relationships
        doctor1.listPatients();
        doctor2.listPatients();
        System.out.println();

        // Displaying patient-doctor relationships
        patient1.listDoctors();
        patient2.listDoctors();
    }
}
