package week3.assignments;


interface WashType {
    int getDuration();
    int getCharge();
    String getName();
}

class QuickWash implements WashType {
    public int getDuration() { return 30; }
    public int getCharge() { return 20; }
    public String getName() { return "Quick"; }
}

class NormalWash implements WashType {
    public int getDuration() { return 45; }
    public int getCharge() { return 30; }
    public String getName() { return "Normal"; }
}

class HeavyWash implements WashType {
    public int getDuration() { return 60; }
    public int getCharge() { return 45; }
    public String getName() { return "Heavy"; }
}

class LaundryStudent {
    String name;

    LaundryStudent(String name) {
        this.name = name;
    }
}

class WashingMachine {
    private String id;
    private boolean busy = false;

    WashingMachine(String id) {
        this.id = id;
    }

    boolean isFree() {
        return !busy;
    }

    String getId() {
        return id;
    }

    void occupy() {
        busy = true;
    }

    void release() {
        busy = false;
    }
}

class WashCycle {
    LaundryStudent student;
    WashingMachine machine;
    WashType type;
    boolean completed = false;

    WashCycle(LaundryStudent student, WashingMachine machine,
              WashType type) {
        this.student = student;
        this.machine = machine;
        this.type = type;
    }

    void start() {
        if (!machine.isFree()) {
            System.out.println("Machine " + machine.getId()
                    + " is currently busy.");
            return;
        }

        machine.occupy();

        System.out.println(type.getName() + " wash started on "
                + machine.getId() + " for " + student.name
                + " (" + type.getDuration() + " min).");

        System.out.println("Charge: Rs." + type.getCharge() + ".00");
    }

    void complete() {
        if (completed || machine.isFree()) {
            System.out.println("No active wash to complete.");
            return;
        }

        machine.release();
        completed = true;

        System.out.println(machine.getId()
                + " cycle completed. " + machine.getId()
                + " is now free.");
    }
}

public class Main {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        LaundryStudent s1 = new LaundryStudent("Asha");
        LaundryStudent s2 = new LaundryStudent("Ravi");
        LaundryStudent s3 = new LaundryStudent("Neha");

        WashCycle w1 = new WashCycle(s1, m1, new QuickWash());
        WashCycle w2 = new WashCycle(s2, m1, new HeavyWash());
        WashCycle w3 = new WashCycle(s2, m2, new HeavyWash());

        w1.start();
        w2.start();
        w3.start();

        w1.complete();

        WashCycle w4 = new WashCycle(s3, m1, new NormalWash());
        w4.start();
    }
}

