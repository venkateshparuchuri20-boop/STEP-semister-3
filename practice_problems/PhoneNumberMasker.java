package week3.practice_problems;

public class PhoneNumberMasker {

    static String maskPhoneNumber(String phone) {

        // Check length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check every character is a digit
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFour = phone.substring(6);

        StringBuilder masked = new StringBuilder("XXXXXX");

        masked.append("-");
        masked.append(lastFour);

        return masked.toString();
    }

    public static void main(String[] args) {

        System.out.println(maskPhoneNumber("9876543210"));

        System.out.println(maskPhoneNumber("98765"));
    }
}
