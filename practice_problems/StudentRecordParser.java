package week3.practice_problems;

public class StudentRecordParser {

    static void parseStudentRecord(String csvLine) {

        String[] details = csvLine.split(",");

        if (details.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
                "Name: " + details[0] +
                        " | Roll No: " + details[1] +
                        " | Dept: " + details[2]
        );
    }

    public static void main(String[] args) {

        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        parseStudentRecord("Ananya Verma,CSE");
    }
}
