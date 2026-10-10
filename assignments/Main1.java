package week3.assignments;


abstract class PortalAssignment {
    String title;
    int maxMarks;
    int dueDay;

    PortalAssignment(String title, int maxMarks, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }

    abstract double getPenaltyPerDay();
}

class CodingAssignment extends PortalAssignment {
    CodingAssignment(String title, int marks, int dueDay) {
        super(title, marks, dueDay);
    }

    @Override
    double getPenaltyPerDay() {
        return 0.10;
    }
}

class WrittenAssignment extends PortalAssignment {
    WrittenAssignment(String title, int marks, int dueDay) {
        super(title, marks, dueDay);
    }

    @Override
    double getPenaltyPerDay() {
        return 0.20;
    }
}

class PortalStudent {
    String name;

    PortalStudent(String name) {
        this.name = name;
    }
}

class Submission {
    PortalStudent student;
    PortalAssignment assignment;
    int submittedDay;
    private String status = "Not Submitted";
    private double finalMarks;

    Submission(PortalStudent student, PortalAssignment assignment,
               int submittedDay) {
        this.student = student;
        this.assignment = assignment;
        this.submittedDay = submittedDay;
    }

    void submit() {
        if (!status.equals("Not Submitted")) {
            System.out.println("Cannot resubmit: '" + assignment.title
                    + "' has already been submitted or graded.");
            return;
        }

        status = "Submitted";

        int lateDays = Math.max(0, submittedDay - assignment.dueDay);

        System.out.println(student.name + "'s submission for '"
                + assignment.title + "' received ("
                + (lateDays == 0 ? "on time" : lateDays + " days late")
                + "). Status: " + status + ".");
    }

    void grade(double awardedMarks) {
        if (!status.equals("Submitted")) {
            System.out.println("Only submitted work can be graded.");
            return;
        }

        if (awardedMarks < 0 || awardedMarks > assignment.maxMarks) {
            System.out.println("Invalid marks.");
            return;
        }

        int lateDays = Math.max(0, submittedDay - assignment.dueDay);

        double penalty = lateDays * assignment.getPenaltyPerDay();
        finalMarks = awardedMarks * (1 - penalty);

        status = "Graded";

        System.out.println(student.name + " graded: "
                + finalMarks + "/" + assignment.maxMarks
                + " after " + (penalty * 100)
                + "% late penalty. Status: " + status + ".");
    }
}

public class Main1 {
    public static void main(String[] args) {
        PortalStudent asha = new PortalStudent("Asha");
        PortalStudent ravi = new PortalStudent("Ravi");

        PortalAssignment coding =
                new CodingAssignment("Linked List Lab", 50, 10);

        PortalAssignment written =
                new WrittenAssignment("Design Essay", 50, 12);

        Submission s1 = new Submission(asha, coding, 10);
        Submission s2 = new Submission(ravi, written, 14);

        s1.submit();
        s2.submit();

        s1.grade(45);
        s2.grade(40);

        s1.submit();
    }
}

