/*Description: Design a system to manage patients in a hospital:
Create an abstract class Patient with fields like patientId, name, and age.
Add an abstract method calculateBill() and a concrete method getPatientDetails().
Extend it into subclasses InPatient and OutPatient, implementing calculateBill() with 
different billing logic.
Implement an interface MedicalRecord with methods addRecord() and viewRecords().
Use encapsulation to protect sensitive patient data like diagnosis and medical history.
Use polymorphism to handle different patient types and display their billing details dynamically. */

abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalhistory;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return name;
    }

    public int getPatientAge() {
        return age;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setMedicalHistory(String medicalhistory) {
        this.medicalhistory = medicalhistory;
    }

    public String getMedicalHistory() {
        return medicalhistory;
    }

    abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("----Patient Details----");
        System.out.println("Patient id : " + patientId);
        System.out.println("Patient name : " + name);
        System.out.println("Patient age : " + age);
        System.out.println("Diagnosis : " + diagnosis);
        System.out.println("Medical History : " + medicalhistory);

    }

}

interface MedicalRecord {
    void addRecord(String diagnosis, String medicalhistory);

    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomRate;
    private double treatmentCost;

    InPatient(int patientId, String name, int age, int daysAdmitted, double roomRate, double treatmentCost) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomRate = roomRate;
        this.treatmentCost = treatmentCost;
    }

    public double calculateBill() {
        return (daysAdmitted * roomRate) + treatmentCost;

    }

    public void addRecord(String diagnosis, String medicalhistory) {
        setDiagnosis(diagnosis);
        setMedicalHistory(medicalhistory);

    }

    public void viewRecords() {
        getPatientDetails();
        System.out.println("Total bill of InPatient : " + calculateBill());
        System.out.println();

    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double treatmentCost;
    private double consultationFee;

    OutPatient(int patientId, String name, int age, double treatmentCost, double consultationFee) {
        super(patientId, name, age);
        this.treatmentCost = treatmentCost;
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return treatmentCost + consultationFee;

    }

    public void addRecord(String diagnosis, String medicalhistory) {
        setDiagnosis(diagnosis);
        setMedicalHistory(medicalhistory);

    }

    public void viewRecords() {
        getPatientDetails();
        System.out.println("Total bill of OutPatient : " + calculateBill());

    }

}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        MedicalRecord ip = new InPatient(12, "Diksha", 12, 3, 2500, 1000);
        MedicalRecord op = new OutPatient(21, "sejal", 18, 1100, 200);

        ip.addRecord("Fever", "No prior illness");
        op.addRecord("Malaria", "Jaundice earlier");

        ip.viewRecords();
        op.viewRecords();

    }
}