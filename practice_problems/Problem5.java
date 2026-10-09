package week3.practice_problems;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static class LibraryMember {
        private static int nextNumber = 101;
        private static int membersEnrolled = 0;

        private final String memberNumber;
        protected int borrowLimit;
        protected int booksBorrowed;
        private final List<String> genres = new ArrayList<>();

        public LibraryMember(int borrowLimit) {
            if (borrowLimit <= 0) {
                throw new IllegalArgumentException(
                        "Borrow limit must be positive"
                );
            }

            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
            this.memberNumber = "LIB-" + nextNumber++;

            membersEnrolled++;
        }

        public String getMemberNumber() {
            return memberNumber;
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public void borrowBook() {
            if (booksBorrowed < borrowLimit) {
                booksBorrowed++;
            }
        }

        public void borrowBook(String genre) {
            int previousCount = booksBorrowed;

            borrowBook();

            if (booksBorrowed > previousCount && genre != null) {
                genres.add(genre);
            }
        }

        public static boolean isValidRenewalCode(String code) {
            if (code == null || code.length() != 4) {
                return false;
            }

            return code.charAt(0) == 'R'
                    && Character.isDigit(code.charAt(1))
                    && Character.isDigit(code.charAt(2))
                    && Character.isUpperCase(code.charAt(3))
                    && Character.isLetter(code.charAt(3));
        }

        public static int getMembersEnrolled() {
            return membersEnrolled;
        }
    }

    static class FacultyMember extends LibraryMember {
        private final String department;

        public FacultyMember(int borrowLimit, String department) {
            super(borrowLimit);
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }
    }

    public static String processNightlyAudit(
            LibraryMember[] members) {

        int processed = 0;
        int facultyCount = 0;
        int regularCount = 0;
        int totalBooks = 0;

        if (members == null) {
            return "Processed: 0 | Faculty: 0"
                    + " | Regular: 0 | Total Books: 0";
        }

        for (LibraryMember member : members) {
            if (member == null) {
                continue;
            }

            processed++;
            totalBooks += member.getBooksBorrowed();

            if (member instanceof FacultyMember) {
                facultyCount++;
            } else {
                regularCount++;
            }
        }

        return "Processed: " + processed
                + " | Faculty: " + facultyCount
                + " | Regular: " + regularCount
                + " | Total Books: " + totalBooks;
    }

    public static void main(String[] args) {
        LibraryMember member1 = new LibraryMember(3);
        FacultyMember member2 =
                new FacultyMember(5, "Physics");

        System.out.println(member1.getMemberNumber());
        System.out.println(
                LibraryMember.getMembersEnrolled()
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("R12A")
        );
        System.out.println(
                LibraryMember.isValidRenewalCode("R1A")
        );

        member1.borrowBook();
        member1.borrowBook("Fiction");
        member2.borrowBook("Science");

        System.out.println(member1.getBooksBorrowed());
        System.out.println(member2.getBooksBorrowed());

        System.out.println(
                processNightlyAudit(
                        new LibraryMember[]{
                                member1, member2, null
                        }
                )
        );
    }
}

