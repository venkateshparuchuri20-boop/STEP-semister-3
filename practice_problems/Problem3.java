package week3.practice_problems;



public class Problem3 {

    static abstract class Instrument {
        public String play() {
            return "";
        }
    }

    static class StringInstrument extends Instrument {
        public StringInstrument() {
            super();
        }

        @Override
        public String play() {
            super.play();
            return "Strumming the strings";
        }
    }

    static class Violin extends StringInstrument {
        public Violin() {
            super();
        }

        @Override
        public String play() {
            String sound = super.play();
            return sound + ", with a bow drawn across four strings";
        }
    }

    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        Violin v = new Violin();

        System.out.println(s.play());
        System.out.println(v.play());
    }
}
