package week3.assignments;


abstract class PremiereSeat {
    String seatId;

    PremiereSeat(String seatId) {
        this.seatId = seatId;
    }

    abstract int getPrice();
}

class RegularSeat extends PremiereSeat {
    RegularSeat(String id) { super(id); }

    @Override
    int getPrice() { return 150; }
}

class PremiumSeat extends PremiereSeat {
    PremiumSeat(String id) { super(id); }

    @Override
    int getPrice() { return 250; }
}

class ReclinerSeat extends PremiereSeat {
    ReclinerSeat(String id) { super(id); }

    @Override
    int getPrice() { return 400; }
}

class PremiereCustomer {
    String name;

    PremiereCustomer(String name) {
        this.name = name;
    }
}

class PremiereShow {
    String name;
    boolean started = false;

    PremiereShow(String name) {
        this.name = name;
    }
}

class SeatBooking {
    PremiereCustomer customer;
    PremiereShow show;
    java.util.List<PremiereSeat> seats =
            new java.util.ArrayList<>();

    SeatBooking(PremiereCustomer customer, PremiereShow show) {
        this.customer = customer;
        this.show = show;
    }

    boolean bookSeats(PremiereSeat... requestedSeats) {
        if (show.started) {
            System.out.println("Booking failed: show has already started.");
            return false;
        }

        if (requestedSeats.length == 0 || requestedSeats.length > 6) {
            System.out.println("Booking must contain 1 to 6 seats.");
            return false;
        }

        java.util.Set<String> uniqueIds = new java.util.HashSet<>();

        // Check every seat before booking any of them
        for (PremiereSeat seat : requestedSeats) {
            if (!uniqueIds.add(seat.seatId)) {
                System.out.println("Duplicate seat in booking: "
                        + seat.seatId);
                return false;
            }

            for (SeatBooking b : showBookings) {
                if (b.show == show && b.hasSeat(seat.seatId)) {
                    System.out.println("Seat " + seat.seatId
                            + " is already booked for this show.");
                    return false;
                }
            }
        }

        seats.addAll(java.util.Arrays.asList(requestedSeats));

        System.out.print("Booking confirmed for " + customer.name + ": ");

        int total = 0;
        for (PremiereSeat seat : seats) {
            System.out.print(seat.seatId + " ");
            total += seat.getPrice();
        }

        System.out.println(". Total: Rs." + total + ".00");

        showBookings.add(this);
        return true;
    }

    boolean hasSeat(String id) {
        for (PremiereSeat seat : seats) {
            if (seat.seatId.equals(id)) {
                return true;
            }
        }
        return false;
    }

    void cancel() {
        if (show.started) {
            System.out.println("Cannot cancel after the show starts.");
            return;
        }

        seats.clear();
        showBookings.remove(this);

        System.out.println("Booking cancelled for " + customer.name
                + ". Seats released.");
    }

    static java.util.List<SeatBooking> showBookings =
            new java.util.ArrayList<>();
}

public class Main2 {
    public static void main(String[] args) {
        PremiereShow show = new PremiereShow("7 PM Show");

        PremiereCustomer asha = new PremiereCustomer("Asha");
        PremiereCustomer ravi = new PremiereCustomer("Ravi");
        PremiereCustomer neha = new PremiereCustomer("Neha");

        SeatBooking b1 = new SeatBooking(asha, show);
        b1.bookSeats(
                new RegularSeat("A1"),
                new RegularSeat("A2"),
                new PremiumSeat("F5"));

        SeatBooking b2 = new SeatBooking(ravi, show);
        b2.bookSeats(new RegularSeat("A2"));

        SeatBooking b3 = new SeatBooking(ravi, show);
        b3.bookSeats(new ReclinerSeat("R1"));

        b1.cancel();

        SeatBooking b4 = new SeatBooking(neha, show);
        b4.bookSeats(new RegularSeat("A2"));
    }
}
