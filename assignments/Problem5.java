package week3.assignments;




public class Problem5 {

    static class GymMember {
        private static int nextNumber = 2001;
        private static int membersEnrolled = 0;

        public final String membershipNumber;
        protected int monthlyFee;
        private int feesPaid;
        private String paymentMode;

        public GymMember(int monthlyFee) {
            if (monthlyFee <= 0) {
                throw new IllegalArgumentException(
                        "Monthly fee must be positive"
                );
            }

            membershipNumber = "GYM-" + nextNumber++;
            this.monthlyFee = monthlyFee;
            this.feesPaid = 0;
            this.paymentMode = "";

            membersEnrolled++;
        }

        public void payFee(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Amount must be positive"
                );
            }

            feesPaid += amount;
        }

        public void payFee(int amount, String mode) {
            payFee(amount);
            paymentMode = mode;
        }

        public int getFeesPaid() {
            return feesPaid;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public static int getMembersEnrolled() {
            return membersEnrolled;
        }

        public static boolean isValidReferralCode(String code) {
            if (code == null || code.length() != 4) {
                return false;
            }

            return code.charAt(0) == 'G'
                    && Character.isDigit(code.charAt(1))
                    && Character.isDigit(code.charAt(2))
                    && code.charAt(3) >= 'A'
                    && code.charAt(3) <= 'Z';
        }
    }

    static class GroupClassMember extends GymMember {
        private String className;

        public GroupClassMember(int monthlyFee, String className) {
            super(monthlyFee);
            this.className = className;
        }

        public String getClassName() {
            return className;
        }
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        if (members == null) {
            return "0 processed | 0 null skipped"
                    + " | 0 group | 0 individual";
        }

        for (GymMember member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);

        System.out.println(m1.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(m1.getFeesPaid());

        GymMember[] members = {
                new GroupClassMember(1500, "Zumba"),
                null,
                new GymMember(1000)
        };

        System.out.println(processWeeklyCheckIn(members));
    }
}

