package week3.practice_problems;


abstract class Vehicle {
    String name;
    double ratePerDay;
    boolean available = true;

    Vehicle(String name, double ratePerDay) {
        this.name = name;
        this.ratePerDay = ratePerDay;
    }

    // Each vehicle calculates its own rental charge
    abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name, 1000);
    }

    @Override
    double calculateCharge(int days) {
        return ratePerDay * days;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name, 1500);
    }

    @Override
    double calculateCharge(int days) {
        return ratePerDay * days;
    }
}

class Truck extends Vehicle {
    Truck(String name) {
        super(name, 2500);
    }

    @Override
    double calculateCharge(int days) {
        return ratePerDay * days;
    }
}

class RentCustomer {
    String name;

    RentCustomer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    void rent() {
        if (vehicle.available) {
            vehicle.available = false;
            System.out.println(vehicle.name + " rented successfully by "
                    + customer.name);
            System.out.println("Rental charge: Rs."
                    + vehicle.calculateCharge(days));
        } else {
            System.out.println(vehicle.name + " is currently unavailable.");
        }
    }

    void returnVehicle() {
        vehicle.available = true;
        System.out.println(vehicle.name + " returned by " + customer.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Sedan("Sedan A");
        Vehicle v2 = new SUV("SUV B");

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");

        Rental r1 = new Rental(v1, c1, 3);
        r1.rent();

        // Another customer tries to rent the same vehicle
        Rental r2 = new Rental(v1, c2, 2);
        r2.rent();

        r1.returnVehicle();

        // Now the vehicle can be rented again
        r2.rent();

        Rental r3 = new Rental(v2, new Customer("Customer 3"), 2);
        r3.rent();
    }
}

