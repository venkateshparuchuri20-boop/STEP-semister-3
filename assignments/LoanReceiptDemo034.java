package week3.assignments;

class LoanReceipt {

    private final String memberId_034;
    private final String[] bookIds_034;

    public LoanReceipt(String memberId, String[] bookIds) {

        this.memberId_034 = memberId;

        // Defensive copy
        this.bookIds_034 = new String[bookIds.length];

        for (int i_034 = 0; i_034 < bookIds.length; i_034++) {
            this.bookIds_034[i_034] = bookIds[i_034];
        }
    }


    // Defensive copy again while returning
    String[] getBookIds() {

        String[] copy_034 =
                new String[bookIds_034.length];

        for (int i_034 = 0; i_034 < bookIds_034.length; i_034++) {
            copy_034[i_034] = bookIds_034[i_034];
        }

        return copy_034;
    }


    // Creates a NEW LoanReceipt
    LoanReceipt withCorrectedBookId(int index, String newId) {

        String[] newBooks_034 = getBookIds();

        newBooks_034[index] = newId;

        return new LoanReceipt(
                memberId_034,
                newBooks_034
        );
    }
}


// Reference-only subclass
class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final String roomNumber_034;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);

        this.roomNumber_034 = roomNumber;
    }

    public String getRoomNumber_034() {
        return roomNumber_034;
    }
}


class CirculationLedger {

    static String branchCode_034;

    // Static block
    static {
        branchCode_034 = "BR-034";
    }


    static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed_034 = 0;
        int nullSkipped_034 = 0;
        int referenceOnly_034 = 0;
        int regular_034 = 0;

        for (int i_034 = 0; i_034 < receipts.length; i_034++) {

            // Handle null safely
            if (receipts[i_034] == null) {
                nullSkipped_034++;
                continue;
            }

            processed_034++;

            // Check whether it is ReferenceOnlyLoanReceipt
            if (receipts[i_034]
                    instanceof ReferenceOnlyLoanReceipt) {

                referenceOnly_034++;
            }
            else {
                regular_034++;
            }
        }


        return processed_034 +
                " processed | " +
                nullSkipped_034 +
                " null skipped | " +
                referenceOnly_034 +
                " reference-only | " +
                regular_034 +
                " regular";
    }
}


public class LoanReceiptDemo034 {

    public static void main(String[] args_034) {

        // ----------------------------------
        // TEST 1: Defensive Copy
        // ----------------------------------

        String[] books_034 = {
                "BK-100",
                "BK-101"
        };

        LoanReceipt r_034 =
                new LoanReceipt(
                        "LIB-8841",
                        books_034
                );

        // Get a copy
        String[] ids_034 = r_034.getBookIds();

        // Modify returned array
        ids_034[0] = "HACKED";

        // Original remains unchanged
        System.out.println(
                r_034.getBookIds()[0]
        );


        // ----------------------------------
        // TEST 2: withCorrectedBookId()
        // ----------------------------------

        LoanReceipt corrected_034 =
                r_034.withCorrectedBookId(
                        1,
                        "BK-102"
                );

        System.out.println(
                r_034.getBookIds()[0] +
                        ", " +
                        r_034.getBookIds()[1]
        );

        System.out.println(
                corrected_034.getBookIds()[0] +
                        ", " +
                        corrected_034.getBookIds()[1]
        );


        // ----------------------------------
        // TEST 3: Nightly Processing
        // ----------------------------------

        LoanReceipt[] receipts_034 = {

                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        "Reading Room 3"
                ),

                null,

                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"}
                )
        };


        System.out.println(
                CirculationLedger
                        .processNightlyCirculation(
                                receipts_034
                        )
        );


        // Display static block value
        System.out.println(
                "Branch Code: " +
                        CirculationLedger.branchCode_034
        );
    }
}
