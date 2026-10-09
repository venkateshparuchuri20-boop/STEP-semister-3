package week3.assignments;




public class Problem4 {

    static class GymMember {
        protected String memberId;
        protected int monthlyFee;
        protected int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public void attendSession() {
            sessionsAttended++;
        }

        public int getSessionsAttended() {
            return sessionsAttended;
        }

        public String displayInfo() {
            return "Standard | Sessions: " + sessionsAttended;
        }
    }

    static class PremiumMember extends GymMember {
        protected String trainerName;

        public PremiumMember(String memberId, int monthlyFee,
                             String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        public String displayInfo() {
            return "Premium | Trainer: " + trainerName
                    + " | Sessions: " + sessionsAttended;
        }
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder announcement = new StringBuilder();

        for (GymMember member : members) {
            announcement.append(member.displayInfo());

            if (member instanceof PremiumMember) {
                PremiumMember premium = (PremiumMember) member;

                announcement.append(
                        " [Trainer via downcast: "
                ).append(premium.trainerName).append("]");
            }

            announcement.append(" | ");
        }

        return announcement.toString();
    }

    public static void main(String[] args) {
        GymMember standard = new GymMember("MEM6", 1000);

        PremiumMember premium =
                new PremiumMember("MEM7", 2000, "Coach Riya");

        System.out.println(
                batchPrint(new GymMember[]{standard, premium})
        );

        GymMember plain = new GymMember("MEM8", 1000);

        try {
            PremiumMember bad = (PremiumMember) plain;
            System.out.println(bad.displayInfo());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}

