package week3.practice_problems;

class TicketAccessChecker034 {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("private")) {

            if (accessorContext.equals("SAME_CLASS"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (fieldModifier.equals("default")) {

            if (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }


    static String summarizeBatch(String[][] attempts) {

        int allowed_034 = 0;
        int denied_034 = 0;

        for (int i_034 = 0; i_034 < attempts.length; i_034++) {

            String result_034 =
                    classifyAccess(attempts[i_034][0],
                            attempts[i_034][1]);

            if (result_034.equals("ALLOWED"))
                allowed_034++;
            else
                denied_034++;
        }

        return "Allowed: " + allowed_034 +
                " | Denied: " + denied_034;
    }


    public static void main(String[] args_034) {

        System.out.println(
                classifyAccess("private", "SAME_CLASS")
        );

        System.out.println(
                classifyAccess("protected", "DIFFERENT_PACKAGE")
        );

        String[][] attempts_034 = {
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
                summarizeBatch(attempts_034)
        );
    }
}
