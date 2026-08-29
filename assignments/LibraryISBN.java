package week3.assignments;

public class LibraryISBN {

    // Normalize the code
    public static String normalizeCode(String raw) {

        String code = raw.trim();

        String publisherCode = code.substring(0, 3).toUpperCase();

        String remaining = code.substring(3);

        return publisherCode + remaining;
    }


    // Validate and format the code
    public static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract parts
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisher);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }


    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String normalized = normalizeCode(raw);

        String result = validateAndFormat(normalized);

        System.out.println(result);
    }
}
