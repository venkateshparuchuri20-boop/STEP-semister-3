package week3.practice_problems;



public class Problem5 {

    static abstract class DeliveryNote {
        protected String trackingId;

        public DeliveryNote(String trackingId) {
            if (trackingId == null || trackingId.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Tracking ID cannot be blank"
                );
            }

            this.trackingId = trackingId;
        }

        public abstract String confirmDelivery();

        public String confirmDelivery(String signature) {
            return confirmDelivery() + ", signed by " + signature;
        }
    }

    static class ParcelNote extends DeliveryNote {

        public ParcelNote(String trackingId) {
            super(trackingId);
        }

        @Override
        public String confirmDelivery() {
            return "Parcel " + trackingId + " delivered";
        }
    }

    static class LetterNote extends DeliveryNote {

        public LetterNote(String trackingId) {
            super(trackingId);
        }

        @Override
        public String confirmDelivery() {
            return "Letter " + trackingId + " delivered";
        }
    }

    public static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            if (note != null) {
                System.out.println(note.confirmDelivery());
            }
        }
    }

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        LetterNote l = new LetterNote("TRK-2");

        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        DeliveryNote ref = p;

        logAll(new DeliveryNote[]{ref, l});
    }
}
