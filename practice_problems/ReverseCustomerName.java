package week3.practice_problems;

public class ReverseCustomerName {

    static String reverseCustomerName(
            String customerName) {

        String reversed = "";

        for (int i = customerName.length() - 1;
             i >= 0;
             i--) {

            reversed += customerName.charAt(i);
        }

        return reversed;
    }


    public static void main(String[] args) {

        String customerName = "Sunil";

        String reversedName =
                reverseCustomerName(customerName);

        System.out.println(
                "Original Name: " + customerName
        );

        System.out.println(
                "Reversed Name: " + reversedName
        );
    }
}
