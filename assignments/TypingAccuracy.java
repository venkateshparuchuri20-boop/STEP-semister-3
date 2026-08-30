package week3.assignments;

public class TypingAccuracy {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        // Compare characters
        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Calculate accuracy
        double accuracy = ((double) matched / original.length()) * 100;

        System.out.println("Matched: " + matched + "/" + original.length());
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position: "
                    + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch)
                    + "' vs '" + typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {

        String original = "coding";
        String typed = "coding";

        checkTypingAccuracy(original, typed);
    }
}
