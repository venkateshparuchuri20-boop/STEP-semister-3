package week3.practice_problems;


import java.util.*;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() {
        return price * quantity;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

// Every payment method must implement this interface
interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment: Rs." + amount);

        // Simulate successful payment
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment: Rs." + amount);

        // Simulate failed payment
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing bank transfer: Rs." + amount);

        return true;
    }
}

class Order {
    Customer customer;
    List<Product> products = new ArrayList<>();
    String status = "PENDING";

    Order(Customer customer) {
        this.customer = customer;
    }

    void addProduct(Product product) {
        if (!status.equals("PENDING")) {
            System.out.println("Cannot modify a paid order.");
            return;
        }

        products.add(product);
    }

    double calculateTotal() {
        double total = 0;

        for (Product p : products) {
            total += p.getTotal();
        }

        return total;
    }

    void pay(PaymentMethod method) {
        if (!status.equals("PENDING")) {
            System.out.println("Order has already been processed.");
            return;
        }

        if (products.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        double amount = calculateTotal();

        boolean success = method.processPayment(amount);

        if (success) {
            status = "PAID";
            System.out.println("Payment successful for "
                    + customer.name + ".");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class Main4 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Customer X");

        Order order1 = new Order(c1);
        order1.addProduct(new Product("Product A", 100, 2));
        order1.addProduct(new Product("Product B", 200, 1));

        System.out.println("Order created for " + c1.name);
        System.out.println("Total amount: Rs." + order1.calculateTotal());

        // Credit card payment succeeds
        PaymentMethod p1 = new CreditCardPayment();
        order1.pay(p1);

        System.out.println();

        // Empty order cannot be paid
        Customer c2 = new Customer("Customer Y");
        Order order2 = new Order(c2);
        order2.pay(new CreditCardPayment());

        System.out.println();

        // PayPal payment fails in this simulation
        Customer c3 = new Customer("Customer Z");
        Order order3 = new Order(c3);
        order3.addProduct(new Product("Product C", 500, 1));
        order3.pay(new PayPalPayment());
    }
}

