package week3.assignments;

class LibraryMember2 {

    private int membershipPin = 1234;
    int branchCode = 101;
    protected double finesOwed = 500;
    public String displayName = "Venkatesh";
}


class AccessChecker2 {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        if (fieldModifier.equals("private")) {

            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        if (fieldModifier.equals("default")) {

            if (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) {

                return "ALLOWED";
            }

            return "DENIED";
        }

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE") ||
                    accessorContext.equals(
                            "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

                return "ALLOWED";
            }

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

                return "DENIED";
            }

            return "DENIED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }


    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String fieldModifier = attempts[i][0];
            String accessorContext = attempts[i][1];

            String result =
                    classifyAccess(fieldModifier, accessorContext);

            if (result.equals("DENIED")) {

                return fieldModifier +
                        " via " +
                        accessorContext +
                        " (attempt #" +
                        (i + 1) +
                        ")";
            }
        }

        return "None Denied";
    }
}


public class ReferenceDeskDemo {

    public static void main(String[] args) {

        System.out.println(
                AccessChecker2.classifyAccess(
                        "private",
                        "SAME_CLASS"
                )
        );

        System.out.println(
                AccessChecker2.classifyAccess(
                        "protected",
                        "DIFFERENT_PACKAGE"
                )
        );

        System.out.println(
                AccessChecker2.classifyAccess(
                        "protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
                )
        );

        System.out.println(
                AccessChecker2.classifyAccess(
                        "protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
                )
        );


        String[][] attempts = {

                {"public",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

                {"protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

                {"protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };


        System.out.println(
                AccessChecker2.firstDeniedAttempt(attempts)
        );


        String[][] attempts2 = {

                {"public",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},

                {"protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };


        System.out.println(
                AccessChecker2.firstDeniedAttempt(attempts2)
        );
    }
}
