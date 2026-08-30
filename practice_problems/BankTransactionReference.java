package week3.practice_problems;

public class BankTransactionReference {

    static String normalizeReference(String raw) {

        // Remove leading and trailing spaces
        raw = raw.trim();

        // Convert first 3 characters to uppercase
        String bankCode = raw.substring(0, 3).toUpperCase();

        // Keep remaining characters unchanged
        String remaining = raw.substring(3);

        return bankCode + remaining;
    }


    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract parts
        String bankCode = reference.substring(0, 3);

        String day = reference.substring(3, 5);

        String month = reference.substring(5, 7);

        String year = reference.substring(7, 9);

        String sequence = reference.substring(9);

        // Build formatted result
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");

        result.append(day);
        result.append("/");
        result.append(month);
        result.append("/");
        result.append(year);

        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }


    public static void main(String[] args) {

        String raw = " hdf03022600042 ";

        String normalized = normalizeReference(raw);

        System.out.println(validateAndFormat(normalized));

        System.out.println(
                validateAndFormat("12F03022600042")
        );
    }
}
