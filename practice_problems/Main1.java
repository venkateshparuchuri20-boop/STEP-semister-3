package week3.practice_problems;


enum Status {
    PENDING, APPROVED, REJECTED
}

abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    // Each employee type can define its own leave policy
    abstract boolean isLeaveAllowed(int days);
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }

    @Override
    boolean isLeaveAllowed(int days) {
        return days > 0 && days <= 20;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }

    @Override
    boolean isLeaveAllowed(int days) {
        return days > 0 && days <= 10;
    }
}

class LeaveRequest {
    Employee employee;
    int days;
    Status status = Status.PENDING;

    LeaveRequest(Employee employee, int days) {
        this.employee = employee;
        this.days = days;
    }

    void submit() {
        if (employee.isLeaveAllowed(days)) {
            System.out.println("Leave request submitted for "
                    + employee.name + " (" + days + " days).");
            System.out.println("Status: " + status);
        } else {
            System.out.println("Leave request exceeds the allowed limit.");
        }
    }

    void review(boolean approved) {
        if (status != Status.PENDING) {
            System.out.println("Cannot change request status from "
                    + status + ".");
            return;
        }

        status = approved ? Status.APPROVED : Status.REJECTED;

        System.out.println(employee.name + "'s leave request "
                + status.toString().toLowerCase() + ".");
        System.out.println("Status: " + status);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("John");
        Employee e2 = new PartTimeEmployee("Jane");

        LeaveRequest r1 = new LeaveRequest(e1, 5);
        r1.submit();
        r1.review(true);

        // Approved requests cannot be changed back to pending
        r1.review(false);

        System.out.println();

        LeaveRequest r2 = new LeaveRequest(e2, 8);
        r2.submit();
        r2.review(false);
    }
}
