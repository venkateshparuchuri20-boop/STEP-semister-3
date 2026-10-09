package week3.assignments;

public class Problem3 {

    static abstract class GardenTool {
        public String use() {
            return "Using the tool in the garden";
        }
    }

    static class CuttingTool extends GardenTool {
        public CuttingTool() {
            super();
        }

        @Override
        public String use() {
            String message = super.use();
            return message + ", blade sharpened first";
        }
    }

    static class Pruner extends CuttingTool {
        public Pruner() {
            super();
        }

        @Override
        public String use() {
            String message = super.use();
            return message + ", then trimming branches precisely";
        }
    }

    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();

        System.out.println(c.use());
        System.out.println(p.use());
    }
}
