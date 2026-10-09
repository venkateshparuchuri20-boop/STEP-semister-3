
package week3.practice_problems;

class LibraryMember4 {
    protected int booksBorrowed;

    public LibraryMember4() {
        booksBorrowed = 0;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}

class StudentMember4 extends LibraryMember4 {
    private String course;

    public StudentMember4(String course) {
        super();
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student | Course: " + course
                + " | Books: " + booksBorrowed;
    }

    public String getCourse() {
        return course;
    }
}

public class Problem4 {

    public static String batchPrint(LibraryMember4[] members) {
        StringBuilder result = new StringBuilder();

        for (LibraryMember4 member : members) {
            result.append(member.displayInfo());

            if (member instanceof StudentMember4) {
                StudentMember4 student = (StudentMember4) member;
                result.append(" [Course via downcast: ")
                        .append(student.getCourse())
                        .append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LibraryMember4 general = new LibraryMember4();
        StudentMember4 student = new StudentMember4("ECE");

        System.out.println(batchPrint(
                new LibraryMember4[]{general, student}
        ));

        LibraryMember4 plain = new LibraryMember4();

        try {
            StudentMember4 bad = (StudentMember4) plain;
            System.out.println(bad.getCourse());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}
