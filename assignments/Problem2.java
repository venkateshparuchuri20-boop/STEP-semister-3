package week3.assignments;

public class Problem2 {

    static abstract class ArtPiece {
        private static int counter = 1001;
        private final String pieceId;
        protected String title;

        public ArtPiece(String title) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Title cannot be blank"
                );
            }

            this.title = title;
            this.pieceId = "ART-" + counter++;
        }

        public abstract String describe();

        public String getPieceId() {
            return pieceId;
        }
    }

    static class Painting extends ArtPiece {
        public Painting(String title) {
            super(title);
        }

        @Override
        public String describe() {
            return "Painting: " + title + ", framed on canvas";
        }
    }

    static class Sculpture extends ArtPiece {
        public Sculpture(String title) {
            super(title);
        }

        @Override
        public String describe() {
            return "Sculpture: " + title + ", carved from stone";
        }
    }

    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(s.describe());

        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}
