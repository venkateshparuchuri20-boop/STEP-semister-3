class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        // Create Ravi's IdCard object
        IdCard ravi = new IdCard("Ravi", 0);

        // Second variable points to the SAME object
        IdCard duplicate = ravi;

        // Change booksIssued through duplicate
        duplicate.booksIssued = 3;

        // Print value through first variable
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);

        // Check whether both variables point to the same object
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Create a completely separate object
        IdCard separate = new IdCard("Ravi", 3);

        // Check whether separate and ravi are the same object
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}