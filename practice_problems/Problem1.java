
package week3.practice_problems;

class LibraryMember3 {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember3(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                    "Borrow limit must be positive"
            );
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}

class StudentMember3 extends LibraryMember3 {
    private String course;

    public StudentMember3(String memberId, int borrowLimit,
                          String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
}

public class Problem1 {

    public static String enrollBatch(String[] memberIds,
                                     int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new LibraryMember3(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        try {
            new LibraryMember3("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        StudentMember3 s =
                new StudentMember3("STU10", 3, "CSE");

        s.borrowBook();
        s.borrowBook();

        System.out.println(s.getBooksBorrowed());

        System.out.println(enrollBatch(
                new String[]{"STU1", "LB1", "STU2", " ", "STU3"},
                3
        ));
    }
}
