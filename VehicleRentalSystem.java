import java.util.Scanner;
interface Rentable {
    double calculateRent(int value, String mode); 
}
abstract class Vehicle implements Rentable {
    protected String vehicleNumber;
    protected String model;
    protected double ratePerHour;
    protected double ratePerKm;

    public Vehicle(String vehicleNumber, String model, double ratePerHour, double ratePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.ratePerHour = ratePerHour;
        this.ratePerKm = ratePerKm;
    }

    public abstract void displayDetails();
}
class Car extends Vehicle {
    public Car(String vehicleNumber, String model) {
        super(vehicleNumber, model, 200.0, 15.0); 
    }

    public void displayDetails() {
        System.out.println("Car - Model: " + model + ", Number: " + vehicleNumber);
    }

    public double calculateRent(int value, String mode) {
        if (mode.equals("time")) {
            return ratePerHour * value;
        } else if (mode.equals("distance")) {
            return ratePerKm * value;
        } else {
            return 0;
        }
    }
}
class Bike extends Vehicle {
    public Bike(String vehicleNumber, String model) {
        super(vehicleNumber, model, 100.0, 5.0);
    }

    public void displayDetails() {
        System.out.println("Bike - Model: " + model + ", Number: " + vehicleNumber);
    }

    public double calculateRent(int value, String mode) {
        if (mode.equals("time")) {
            return ratePerHour * value;
        } else if (mode.equals("distance")) {
            return ratePerKm * value;
        } else {
            return 0;
        }
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = null;

        System.out.println("===== Vehicle Rental System =====");
        System.out.println("Select vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter vehicle number: ");
        String number = scanner.nextLine();

        System.out.print("Enter model name: ");
        String model = scanner.nextLine();

        if (choice == 1) {
            vehicle = new Car(number, model);
        } else if (choice == 2) {
            vehicle = new Bike(number, model);
        } else {
            System.out.println("Invalid vehicle type!");
            return;
        }

        System.out.println("Select rental mode:");
        System.out.println("1. By Time (hours)");
        System.out.println("2. By Distance (km)");
        System.out.print("Enter choice: ");
        int rentMode = scanner.nextInt();

        String mode = rentMode == 1 ? "time" : "distance";

        System.out.print("Enter " + (mode.equals("time") ? "number of hours: " : "distance in km: "));
        int value = scanner.nextInt();

        double rent = vehicle.calculateRent(value, mode);

        System.out.println("\n===== Invoice =====");
        vehicle.displayDetails();
        System.out.println("Rental Mode: " + (mode.equals("time") ? "Time (per hour)" : "Distance (per km)"));
        System.out.println((mode.equals("time") ? "Hours" : "Distance") + ": " + value);
        System.out.println("Total Rent: Rs. " + rent);
        System.out.println("===================");
    }
}



