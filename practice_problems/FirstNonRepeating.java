package week3.practice_problems;

public class FirstNonRepeating {

    static char findFirstNonRepeatingChar(String text) {

        // Check every character
        for (int i = 0; i < text.length(); i++) {

            int count = 0;

            // Count how many times it appears
            for (int j = 0; j < text.length(); j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    count++;
                }
            }

            // First character with frequency 1
            if (count == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }


    public static void main(String[] args) {

        String text = "swiss";

        char result =
                findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                    "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                    "First Non-Repeating Character: '" +
                            result + "'"
            );
        }
    }
}
