package week3.assignments;




public class Problem1 {

    static class GymMember {
        protected String memberId;
        protected int monthlyFee;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid member ID");
            }

            if (monthlyFee <= 0) {
                throw new IllegalArgumentException(
                        "Monthly fee must be positive"
                );
            }

            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }
    }

    static class PremiumMember extends GymMember {
        private String trainerName;
        private int sessionsAttended;

        public PremiumMember(String memberId, int monthlyFee,
                             String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
            sessionsAttended = 0;
        }

        public void attendSession() {
            sessionsAttended++;
        }

        public int getSessionsAttended() {
            return sessionsAttended;
        }
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        try {
            new GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        PremiumMember p =
                new PremiumMember("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(p.getSessionsAttended());

        System.out.println(signUpBatch(
                new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"},
                1000
        ));
    }
}

