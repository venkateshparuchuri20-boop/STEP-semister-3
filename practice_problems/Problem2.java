
package week3.practice_problems;

class LibraryMember2 {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember2(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }
}

class StudentMember2 extends LibraryMember2 {
    protected String course;

    public StudentMember2(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course
                + " | Books Borrowed: " + booksBorrowed;
    }
}

class HonorsStudentMember2 extends StudentMember2 {
    private int bonusLimit;

    public HonorsStudentMember2(String memberId, int borrowLimit,
                                String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + course
                + " | Bonus Limit: " + bonusLimit
                + " | Books Borrowed: " + booksBorrowed;
    }
}

class FacultyMember2 extends LibraryMember2 {
    private String department;

    public FacultyMember2(String memberId, int borrowLimit,
                          String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department
                + " | Books Borrowed: " + booksBorrowed;
    }
}

public class Problem2{

    public static String classifyGeneration(LibraryMember2 member) {
        if (member instanceof HonorsStudentMember2) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember2) {
            return "Hierarchical sibling (independent branch)";
        } else {
            return "Regular membership branch";
        }
    }

    public static int getTotalBooksBorrowed(LibraryMember2[] members) {
        int total = 0;

        for (LibraryMember2 member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args) {
        LibraryMember2 general = new LibraryMember2("STU1", 3);
        StudentMember2 student =
                new StudentMember2("STU2", 3, "CSE");
        HonorsStudentMember2 honors =
                new HonorsStudentMember2("STU3", 3, "ECE", 2);
        FacultyMember2 faculty =
                new FacultyMember2("STU4", 5, "Physics");

        student.booksBorrowed = 2;
        honors.booksBorrowed = 1;
        faculty.booksBorrowed = 3;

        System.out.println(general.displayInfo());
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());

        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        System.out.println(getTotalBooksBorrowed(
                new LibraryMember2[]{student, honors, faculty}
        ));
    }
}