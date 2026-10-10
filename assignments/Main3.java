package week3.assignments;


enum MembershipStatus {
    ACTIVE, FROZEN, EXPIRED
}

interface MembershipPlan {
    double calculateFee();
    String getName();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }

    public String getName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 3000 * 0.90;
    }

    public String getName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() {
        return 12000 * 0.75;
    }

    public String getName() {
        return "Annual";
    }
}

class GymMember {
    String name;

    GymMember(String name) {
        this.name = name;
    }
}

class GymMembership {
    GymMember member;
    MembershipPlan plan;
    private MembershipStatus status = MembershipStatus.ACTIVE;

    GymMembership(GymMember member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;

        System.out.println(plan.getName() + " membership created for "
                + member.name + ". Fee: Rs."
                + String.format("%.2f", plan.calculateFee())
                + ". Status: " + status + ".");
    }

    void checkIn() {
        if (status == MembershipStatus.ACTIVE) {
            System.out.println(member.name + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.name
                    + "'s membership is " + status + ".");
        }
    }

    void freeze() {
        if (status != MembershipStatus.ACTIVE) {
            System.out.println("Cannot freeze membership in status "
                    + status + ".");
            return;
        }

        status = MembershipStatus.FROZEN;
        System.out.println(member.name + "'s membership frozen. Status: "
                + status + ".");
    }

    void unfreeze() {
        if (status != MembershipStatus.FROZEN) {
            System.out.println("Cannot unfreeze membership in status "
                    + status + ".");
            return;
        }

        status = MembershipStatus.ACTIVE;
        System.out.println(member.name + "'s membership unfrozen. Status: "
                + status + ".");
    }

    void expire() {
        status = MembershipStatus.EXPIRED;
        System.out.println(member.name + "'s membership expired. Status: "
                + status + ".");
    }
}

public class Main3 {
    public static void main(String[] args) {
        GymMembership m1 = new GymMembership(
                new GymMember("Asha"), new QuarterlyPlan());

        GymMembership m2 = new GymMembership(
                new GymMember("Ravi"), new MonthlyPlan());

        m2.checkIn();

        m1.freeze();
        m1.checkIn();
        m1.unfreeze();
        m1.checkIn();

        m2.expire();
        m2.freeze();
    }
}
