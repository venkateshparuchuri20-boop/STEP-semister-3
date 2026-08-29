package week3.assignments;

public class Student {
    String name;
    int attendance;

    // Static fields (shared by all students)
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;

        // Increase count whenever a Student is created
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        // Create two Student objects
        Student s1 = new Student("Venkatesh", 90);
        Student s2 = new Student("Rahul", 85);

        // Call static method using class name
        Student.printCollegeInfo();
    }
}
