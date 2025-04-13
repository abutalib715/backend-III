/*
Background: A vehicle tracking system calculates the speed for various vehicle types (e.g., bikes, cars, airplanes).
The base Vehicle class defines basic speed-related methods, and subclasses such as Bike, Car, and Airplane may
need different speed limit handling. The system should calculate speeds consistently across all vehicle types.

Question: How would you design the Vehicle and its subclasses to allow consistent speed calculations without
needing different handling for each type?*/

// Interface for Speed Calculation
interface SpeedCalculator {
    double calculateSpeed();
}

abstract class Vehicle implements SpeedCalculator {
    protected double distance; // in kilometers
    protected double time;     // in hours

    public Vehicle(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public abstract double calculateSpeed();
}

// Concrete Vehicle Classes
class Bike extends Vehicle {
    public Bike(double distance, double time) {
        super(distance, time);
    }

    @Override
    public double calculateSpeed() {
        return distance / time;
    }
}

class Car extends Vehicle {
    public Car(double distance, double time) {
        super(distance, time);
    }

    @Override
    public double calculateSpeed() {
        return (distance / time) * 1.1;
    }
}

class Airplane extends Vehicle {
    public Airplane(double distance, double time) {
        super(distance, time);
    }

    @Override
    public double calculateSpeed() {
        return (distance / time) * 1.5;
    }
}

class VehicleTrackingService {
    public trackSpeed() {
        Vehicle bike = new Bike(50, 2);       // 50 km in 2 hours
        Vehicle car = new Car(200, 4);        // 200 km in 4 hours
        Vehicle airplane = new Airplane(1000, 2); // 1000 km in 2 hours

        System.out.println("Bike Speed: " + bike.calculateSpeed() + " km/h");
        System.out.println("Car Speed: " + car.calculateSpeed() + " km/h");
        System.out.println("Airplane Speed: " + airplane.calculateSpeed() + " km/h");
    }
}
