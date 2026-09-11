package week3.assignments;

class LibraryMember {

    private int membershipPin = 1234;
    int branchCode = 101;              // default
    protected double finesOwed = 500;  // protected
    public String displayName = "Venkatesh"; // public

    public int getMembershipPin() {
        return membershipPin;
    }
}


class AccessChecker {

    // Checks whether access is allowed
    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        if (fieldModifier.equals("private")) {

            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }
            else {
                return "DENIED";
            }
        }

        else if (fieldModifier.equals("default")) {

            if (accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            else {
                return "DENIED";
            }
        }

        else if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) {

                return "ALLOWED";
            }
            else {
                return "DENIED";
            }
        }

        else if (fieldModifier.equals("public")) {

            return "ALLOWED";
        }

        return "DENIED";
    }


    // Summarize results by modifier
    static String summarizeByModifier(String[][] attempts) {

        String[] modifiers = {
                "private",
                "default",
                "protected",
                "public"
        };

        int[] allowed = new int[4];
        int[] denied = new int[4];

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            String result =
                    classifyAccess(modifier, context);

            for (int j = 0; j < modifiers.length; j++) {

                if (modifier.equals(modifiers[j])) {

                    if (result.equals("ALLOWED")) {
                        allowed[j]++;
                    }
                    else {
                        denied[j]++;
                    }

                    break;
                }
            }
        }

        String result = "";

        for (int i = 0; i < modifiers.length; i++) {

            if (i > 0) {
                result += " | ";
            }

            result += modifiers[i] + ": "
                    + allowed[i] + " allowed / "
                    + denied[i] + " denied";
        }

        return result;
    }
}


public class Main {

    public static void main(String[] args) {

        // Test 1
        System.out.println(
                AccessChecker.classifyAccess(
                        "private",
                        "SAME_CLASS"
                )
        );

        // Test 2
        System.out.println(
                AccessChecker.classifyAccess(
                        "protected",
                        "DIFFERENT_PACKAGE"
                )
        );


        // Test summary
        String[][] attempts = {

                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},

                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},

                {"protected", "SAME_CLASS"},
                {"protected", "SAME_PACKAGE"},

                {"public", "DIFFERENT_PACKAGE"}
        };


        System.out.println(
                AccessChecker.summarizeByModifier(attempts)
        );
    }
}
