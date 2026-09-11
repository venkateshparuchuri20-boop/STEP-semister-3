package week3.practice_problems;

class MovieBookingProfile034 {

    private String name_034;
    private boolean confirmed_034;
    private String otp_034;


    // No-argument constructor
    public MovieBookingProfile034() {
    }


    // Convenience constructor
    public MovieBookingProfile034(String name_034) {

        this();

        this.name_034 = name_034;
    }


    public String getName() {
        return name_034;
    }


    public void setName(String name_034) {
        this.name_034 = name_034;
    }


    public boolean isConfirmed() {
        return confirmed_034;
    }


    public void setConfirmed(boolean confirmed_034) {
        this.confirmed_034 = confirmed_034;
    }


    // Write-only OTP
    public void setOtp(String otp_034) {

        this.otp_034 = otp_034;
    }


    public static void main(String[] args_034) {

        MovieBookingProfile034 p_034 =
                new MovieBookingProfile034("Rahul Dev");

        System.out.println(
                p_034.getName()
        );

        p_034.setConfirmed(true);

        System.out.println(
                p_034.isConfirmed()
        );

        p_034.setOtp("4471");

        System.out.println(
                "OTP stored successfully"
        );
    }
}
