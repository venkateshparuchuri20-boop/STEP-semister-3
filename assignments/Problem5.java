package week3.assignments;

public class Problem5 {

    static abstract class Drone {
        protected String id;

        public Drone(String id) {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "ID cannot be blank"
                );
            }

            this.id = id;
        }

        public abstract String fly();
    }

    interface Trackable {
        String getLocation();
    }

    static class DeliveryDrone extends Drone implements Trackable {
        public DeliveryDrone(String id) {
            super(id);
        }

        @Override
        public String fly() {
            return id + " flying to delivery destination";
        }

        @Override
        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    static class ScoutDrone extends Drone {
        public ScoutDrone(String id) {
            super(id);
        }

        @Override
        public String fly() {
            return id + " scouting the area";
        }
    }

    static class GroundRobot implements Trackable {
        private String id;

        public GroundRobot(String id) {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "ID cannot be blank"
                );
            }

            this.id = id;
        }

        @Override
        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable t = (Trackable) o;
            return t.getLocation();
        }

        return "Tracking not available";
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");
        ScoutDrone s = new ScoutDrone("SC-1");
        GroundRobot g = new GroundRobot("GR-1");

        System.out.println(getLocationIfTrackable(d));
        System.out.println(getLocationIfTrackable(s));
        System.out.println(getLocationIfTrackable(g));
    }
}
