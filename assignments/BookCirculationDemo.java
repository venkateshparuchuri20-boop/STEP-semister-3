package week3.assignments;

class BookInventory3 {

    private int copiesTotal;
    private int copiesAvailable;

    // Constructor
    BookInventory3(int copiesTotal) {

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    // Check out one copy
    void checkOut() {

        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    // Check in one copy
    void checkIn() {

        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    // Get available copies
    int getCopiesAvailable() {

        return copiesAvailable;
    }
}


public class BookCirculationDemo {

    public static void main(String[] args) {

        // Create inventory with 3 copies
        BookInventory3 b = new BookInventory3(3);

        // Check out 4 times
        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut();

        // 4th checkout is rejected
        System.out.println(
                "Available copies: " +
                        b.getCopiesAvailable()
        );


        System.out.println();


        // Check in 4 times
        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn();

        // 4th check-in is rejected
        System.out.println(
                "Available copies: " +
                        b.getCopiesAvailable()
        );
    }
}
