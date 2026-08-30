package week3.practice_problems;

public class PalindromeChecker {

    // 1. Iterative approach
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // 2. Recursive approach
    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }


    // 3. Array reversal approach
    static boolean isPalindromeArrayReversal(String text) {

        char[] characters = text.toCharArray();

        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {

            reversed[i] =
                    characters[characters.length - 1 - i];
        }

        String reversedText = new String(reversed);

        return text.equals(reversedText);
    }


    public static void main(String[] args) {

        String text = "madam";

        boolean iterative =
                isPalindromeIterative(text);

        boolean recursive =
                isPalindromeRecursive(text);

        boolean arrayReversal =
                isPalindromeArrayReversal(text);

        System.out.println(
                "Iterative: " +
                        (iterative ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Recursive: " +
                        (recursive ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Array Reversal: " +
                        (arrayReversal ? "Palindrome" : "Not Palindrome")
        );
    }
}
