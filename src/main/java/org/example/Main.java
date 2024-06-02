package org.example;
// Interface for Electric Vehicles
interface Electric {
    void displayBattery();
}

// Interface for Hybrid Vehicles
interface Hybrid {
    void displayFuelType();
}

// Vehicle class implementing Electric and Hybrid interfaces
class Vehicle implements Electric, Hybrid {
    int maxSpeed;

    Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void displaySpeed() {
        System.out.println("Max speed: " + maxSpeed);
    }

    public void displayBattery() {
        System.out.println("Battery: Electric");
    }

    public void displayFuelType() {
        System.out.println("Fuel Type: Hybrid");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(200);
        vehicle.displaySpeed();
        vehicle.displayBattery();
        vehicle.displayFuelType();
    }
}
