package week3.practice_problems;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

abstract class Room {
    int roomNumber;
    double pricePerNight;

    Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    abstract double calculatePrice(long nights);
}

class StandardRoom extends Room {
    StandardRoom(int number) {
        super(number, 2000);
    }

    @Override
    double calculatePrice(long nights) {
        return pricePerNight * nights;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int number) {
        super(number, 3500);
    }

    @Override
    double calculatePrice(long nights) {
        return pricePerNight * nights;
    }
}

class Suite extends Room {
    Suite(int number) {
        super(number, 5000);
    }

    @Override
    double calculatePrice(long nights) {
        return pricePerNight * nights;
    }
}

class RentalCustomer {
    String name;

    RentalCustomer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate cancellationDeadline;
    boolean cancelled = false;

    Reservation(Customer customer, Room room,
                LocalDate startDate, LocalDate endDate,
                LocalDate cancellationDeadline) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancellationDeadline = cancellationDeadline;
    }

    boolean overlaps(LocalDate start, LocalDate end) {
        // Checkout date is not included in the stay
        return !cancelled && startDate.isBefore(end)
                && start.isBefore(endDate);
    }

    void confirm() {
        long nights = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println("Reservation confirmed for "
                + customer.name + ", Room " + room.roomNumber
                + " (" + startDate + " to " + endDate + ").");

        System.out.println("Price: Rs." + room.calculatePrice(nights));
    }

    void cancel(LocalDate today) {
        if (cancelled) {
            System.out.println("Reservation is already cancelled.");
        } else if (today.isAfter(cancellationDeadline)) {
            System.out.println("Cancellation deadline has passed.");
        } else {
            cancelled = true;
            System.out.println("Reservation cancelled successfully.");
        }
    }
}

class Hotel {
    List<Reservation> reservations = new ArrayList<>();

    boolean isAvailable(Room room, LocalDate start, LocalDate end) {
        if (!start.isBefore(end)) {
            return false;
        }

        for (Reservation r : reservations) {
            if (r.room == room && r.overlaps(start, end)) {
                return false;
            }
        }

        return true;
    }

    void book(Customer customer, Room room,
              LocalDate start, LocalDate end,
              LocalDate cancellationDeadline) {

        if (!isAvailable(room, start, end)) {
            System.out.println("Room " + room.roomNumber
                    + " is not available for these dates.");
            return;
        }

        Reservation r = new Reservation(customer, room, start,
                end, cancellationDeadline);

        reservations.add(r);
        r.confirm();
    }
}

public class Main3 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Room r1 = new StandardRoom(101);
        Room r2 = new DeluxeRoom(201);

        Customer c1 = new Customer("Customer A");
        Customer c2 = new Customer("Customer B");
        Customer c3 = new Customer("Customer C");

        LocalDate start1 = LocalDate.of(2026, 11, 1);
        LocalDate end1 = LocalDate.of(2026, 11, 5);

        hotel.book(c1, r1, start1, end1,
                LocalDate.of(2026, 10, 28));

        // These dates overlap with Customer A's reservation
        hotel.book(c2, r1, LocalDate.of(2026, 11, 3),
                LocalDate.of(2026, 11, 7),
                LocalDate.of(2026, 10, 30));

        // A different room can be booked for the same period
        hotel.book(c3, r2, start1, end1,
                LocalDate.of(2026, 10, 28));
    }
}

