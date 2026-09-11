class BookingReceipt034 {

    private final String bookingId_034;
    private final String[] seatNumbers_034;

    public BookingReceipt034(String bookingId_034,
                             String[] seatNumbers_034) {

        this.bookingId_034 = bookingId_034;

        // Defensive copy
        this.seatNumbers_034 =
                new String[seatNumbers_034.length];

        for (int i_034 = 0;
             i_034 < seatNumbers_034.length;
             i_034++) {

            this.seatNumbers_034[i_034] =
                    seatNumbers_034[i_034];
        }
    }

    public String[] getSeatNumbers() {

        // Defensive copy
        String[] copy_034 =
                new String[seatNumbers_034.length];

        for (int i_034 = 0;
             i_034 < seatNumbers_034.length;
             i_034++) {

            copy_034[i_034] =
                    seatNumbers_034[i_034];
        }

        return copy_034;
    }

    public BookingReceipt034 withUpdatedSeat(
            int index_034,
            String newSeat_034) {

        String[] newSeats_034 =
                getSeatNumbers();

        newSeats_034[index_034] =
                newSeat_034;

        return new BookingReceipt034(
                bookingId_034,
                newSeats_034
        );
    }
}


class GroupBookingReceipt034
        extends BookingReceipt034 {

    private final int groupSize_034;

    public GroupBookingReceipt034(
            String bookingId_034,
            String[] seatNumbers_034,
            int groupSize_034) {

        super(bookingId_034, seatNumbers_034);

        this.groupSize_034 =
                groupSize_034;
    }

    public int getGroupSize_034() {
        return groupSize_034;
    }
}


class BookingSettlement034 {

    static String processNightlySettlement(
            BookingReceipt034[] receipts_034) {

        int processed_034 = 0;
        int nullSkipped_034 = 0;
        int group_034 = 0;
        int individual_034 = 0;

        for (int i_034 = 0;
             i_034 < receipts_034.length;
             i_034++) {

            if (receipts_034[i_034] == null) {

                nullSkipped_034++;
                continue;
            }

            processed_034++;

            if (receipts_034[i_034]
                    instanceof GroupBookingReceipt034) {

                group_034++;
            }
            else {

                individual_034++;
            }
        }

        return processed_034 +
                " processed | " +
                nullSkipped_034 +
                " null skipped | " +
                group_034 +
                " group | " +
                individual_034 +
                " individual";
    }


    public static void main(String[] args_034) {

        BookingReceipt034 b_034 =
                new BookingReceipt034(
                        "CH-1001",
                        new String[]{"A1", "A2"}
                );

        String[] seats_034 =
                b_034.getSeatNumbers();

        seats_034[0] = "X";

        System.out.println(
                b_034.getSeatNumbers()[0]
        );


        BookingReceipt034 updated_034 =
                b_034.withUpdatedSeat(
                        1,
                        "A3"
                );

        System.out.println(
                b_034.getSeatNumbers()[0] +
                        ", " +
                        b_034.getSeatNumbers()[1]
        );

        System.out.println(
                updated_034.getSeatNumbers()[0] +
                        ", " +
                        updated_034.getSeatNumbers()[1]
        );


        BookingReceipt034[] receipts_034 = {

                new GroupBookingReceipt034(
                        "CH-2002",
                        new String[]{"B1", "B2"},
                        2
                ),

                null,

                new BookingReceipt034(
                        "CH-3003",
                        new String[]{"C1"}
                )
        };


        System.out.println(
                BookingSettlement034
                        .processNightlySettlement(
                                receipts_034
                        )
        );
    }
}