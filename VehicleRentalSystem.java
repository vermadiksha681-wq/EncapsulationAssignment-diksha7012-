
/*  Vehicle Rental System
Description: Design a system to manage vehicle rentals:
Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
Add an abstract method calculateRentalCost(int days).
Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance costs for each.
 */
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public void setType(String type) { this.type = type; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    public void getVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Rate per day: " + rentalRate);
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private int policyNumber;

    Car(String vehicleNumber, double rentalRate, int policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    public void getInsuranceDetails() {
        System.out.println("Policy No: " + policyNumber);
        System.out.println("Insurance Cost: " + calculateInsurance());
    }

    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Rental Cost for 5 days: " + calculateRentalCost(5));
        getInsuranceDetails();
    }
}

class Bike extends Vehicle implements Insurable {
    private int policyNumber;

    Bike(String vehicleNumber, double rentalRate, int policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.02;
    }

    public void getInsuranceDetails() {
        System.out.println("Policy No: " + policyNumber);
        System.out.println("Insurance Cost: " + calculateInsurance());
    }

    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Rental Cost for 5 days: " + calculateRentalCost(5));
        getInsuranceDetails();
    }
}

class Truck extends Vehicle implements Insurable {
    private int policyNumber;

    Truck(String vehicleNumber, double rentalRate, int policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; 
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    public void getInsuranceDetails() {
        System.out.println("Policy No: " + policyNumber);
        System.out.println("Insurance Cost: " + calculateInsurance());
    }

    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Rental Cost for 5 days: " + calculateRentalCost(5));
        getInsuranceDetails();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle obj1 = new Car("111", 900, 22);
        Vehicle obj2 = new Bike("234", 800, 33);
        Vehicle obj3 = new Truck("678", 700, 55);

        obj1.getVehicleDetails();
        System.out.println();
        obj2.getVehicleDetails();
        System.out.println();
        obj3.getVehicleDetails();
    }
}
