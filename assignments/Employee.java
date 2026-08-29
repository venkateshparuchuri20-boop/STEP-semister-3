package week3.assignments;

public class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Permanent employee constructor
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Intern constructor
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(
            empId + " | " +
            empName + " | Rs " +
            salary + " | Intern: " +
            isIntern
        );
    }

    public static void main(String[] args) {

        // Permanent employee
        Employee e1 = new Employee("E-101", "Divya", 65000);

        // Intern
        Employee e2 = new Employee("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}