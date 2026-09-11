package week3.practice_problems;

class CineScreen034 {

    private int seatsTotal_034;
    private int seatsAvailable_034;


    CineScreen034(int seatsTotal_034) {

        if (seatsTotal_034 <= 0) {
            throw new IllegalArgumentException(
                    "construction rejected"
            );
        }

        this.seatsTotal_034 = seatsTotal_034;
        this.seatsAvailable_034 = seatsTotal_034;
    }


    void bookSeat() {

        if (seatsAvailable_034 > 0) {
            seatsAvailable_034--;
        }
    }


    void cancelBooking() {

        if (seatsAvailable_034 < seatsTotal_034) {
            seatsAvailable_034++;
        }
    }


    int getSeatsAvailable() {
        return seatsAvailable_034;
    }


    public static void main(String[] args_034) {

        CineScreen034 c_034 =
                new CineScreen034(2);

        c_034.bookSeat();
        c_034.bookSeat();
        c_034.bookSeat();

        System.out.println(
                c_034.getSeatsAvailable()
        );


        c_034.cancelBooking();
        c_034.cancelBooking();
        c_034.cancelBooking();

        System.out.println(
                c_034.getSeatsAvailable()
        );
    }
}
