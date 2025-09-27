/*Description: Develop a ride-hailing application:
Define an abstract class Vehicle with fields like vehicleId, driverName, and ratePerKm.
Add abstract methods calculateFare(double distance) and a concrete method getVehicleDetails().
Create subclasses Car, Bike, and Auto, overriding calculateFare() based on type-specific rates.
Use an interface GPS with methods getCurrentLocation() and updateLocation().
Secure driver and vehicle details using encapsulation.
Demonstrate polymorphism by creating a method to calculate fares for different vehicle types dynamically. */
abstract class Vehicles {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    Vehicles(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public int getVehicleId() { 
        return vehicleId; 
    }

    public String getDriverName() { 
        return driverName;
     }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getCurrentLocation() { 
        return currentLocation; 
    }

    public void setCurrentLocation(String location) { 
        this.currentLocation = location; 
    }

    abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per km: " + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicles implements GPS {
    Car(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() { 
        return super.getCurrentLocation(); 
    }

    @Override
    public void updateLocation(String newLocation) { 
        setCurrentLocation(newLocation); 
    }
}

class Bike extends Vehicles implements GPS {
    Bike(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; 
    }

    @Override
    public String getCurrentLocation() { 
        return super.getCurrentLocation(); 
    }

    @Override
    public void updateLocation(String newLocation) { 
        setCurrentLocation(newLocation); 
    }
}

class Auto extends Vehicles implements GPS {
    Auto(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8; 
    }

    @Override
    public String getCurrentLocation() { 
        return super.getCurrentLocation(); 
    }

    @Override
    public void updateLocation(String newLocation) { 
        setCurrentLocation(newLocation); 
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicles vehicle1 = new Car(101, "Tia", 15, "Downtown");
        Vehicles vehicle2 = new Bike(102, "Pia", 10, "Uptown");
        Vehicles vehicle3 = new Auto(103, "Sia", 8, "Suburbs");

        double distance = 12;

        vehicle1.getVehicleDetails();
        System.out.println("Fare for " + distance + " km: " + vehicle1.calculateFare(distance));
        System.out.println();

        vehicle2.getVehicleDetails();
        System.out.println("Fare for " + distance + " km: " + vehicle2.calculateFare(distance));
        System.out.println();

        vehicle3.getVehicleDetails();
        System.out.println("Fare for " + distance + " km: " + vehicle3.calculateFare(distance));
    }
}
