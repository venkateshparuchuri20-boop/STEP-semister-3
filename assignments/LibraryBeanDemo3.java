package week3.assignments;

class LibraryMemberBean3 {

    private String membershipId_034;
    private String name_034;
    private boolean premiumMember_034;
    private String securityAnswer_034;

    // Public no-argument constructor
    public LibraryMemberBean3() {

        membershipId_034 = null;
        name_034 = null;
        premiumMember_034 = false;
        securityAnswer_034 = null;
    }


    // Membership ID - Write Once

    public String getMembershipId() {

        return membershipId_034;
    }

    public void setMembershipId(String id) {

        // Set only on first call
        if (membershipId_034 == null) {
            membershipId_034 = id;
        }
    }


    // Name - Normal JavaBean property

    public String getName() {

        return name_034;
    }

    public void setName(String name) {

        name_034 = name;
    }


    // Premium Member - Boolean JavaBean property

    public boolean isPremiumMember() {

        return premiumMember_034;
    }

    public void setPremiumMember(boolean premium) {

        premiumMember_034 = premium;
    }


    // Security Answer - Write Only

    public void setSecurityAnswer(String answer) {

        securityAnswer_034 = transformAnswer_034(answer);
    }


    // One-way transformation
    private String transformAnswer_034(String answer_034) {

        int hash_034 = 0;

        for (int i_034 = 0; i_034 < answer_034.length(); i_034++) {

            hash_034 = hash_034 * 31 + answer_034.charAt(i_034);
        }

        return Integer.toHexString(hash_034);
    }
}


public class LibraryBeanDemo3 {

    public static void main(String[] args_034) {

        LibraryMemberBean3 m_034 =
                new LibraryMemberBean3();


        // Set membership ID
        m_034.setMembershipId("LIB-8841");

        // Set name
        m_034.setName("Priya Nair");

        // Set premium status
        m_034.setPremiumMember(true);


        // Display values
        System.out.println(
                "Membership ID: " +
                        m_034.getMembershipId()
        );

        System.out.println(
                "Name: " +
                        m_034.getName()
        );

        System.out.println(
                "Premium Member: " +
                        m_034.isPremiumMember()
        );


        // Try to change membership ID
        m_034.setMembershipId("FAKE-0000");

        System.out.println(
                "After second ID attempt: " +
                        m_034.getMembershipId()
        );


        // Set security answer
        m_034.setSecurityAnswer("BlueMountain");

        System.out.println(
                "Security answer stored successfully."
        );

        // There is NO getter for securityAnswer
    }
}
