package week3.practice_problems;


public class Problem1 {

    static abstract class Toy {
        private static int counter = 1001;

        protected String name;
        private final String toyId;

        public Toy(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be blank");
            }

            this.name = name;
            this.toyId = "TOY-" + counter++;
        }

        public abstract String makeSound();

        public String getToyId() {
            return toyId;
        }
    }

    static class ToyCar extends Toy {
        public ToyCar(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Vroom vroom!";
        }
    }

    static class ToyRobot extends Toy {
        public ToyRobot(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Beep boop!";
        }
    }

    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}
