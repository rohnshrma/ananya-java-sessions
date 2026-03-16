abstract class Payment {
    String payerName;

    Payment(String payerName) {
        this.payerName = payerName;
    }

    void startPayment() {
        System.out.println("Starting payment for " + payerName);
    }

    abstract void pay(double amount);
}

class UpiPayment extends Payment {
    UpiPayment(String payerName) {
        super(payerName);
    }

    @Override
    void pay(double amount) {
        System.out.println(payerName + " paid Rs." + amount + " using UPI.");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        UpiPayment payment = new UpiPayment("Ananya");

        payment.startPayment();
        payment.pay(1500);
    }
}

/*
 * WHY THIS IS A GOOD ABSTRACT CLASS EXAMPLE
 * 1) Payment is a general idea. We usually do not create a plain Payment object.
 * 2) Every payment should have some common data, like payerName.
 * 3) Every payment may share some common behavior, like startPayment().
 * 4) But the actual pay() step can be different for UPI, card, net banking, etc.
 * 5) So we make pay() an abstract method and force child classes to define it.
 *
 * IMPORTANT RULES
 * 1) An abstract class can have normal methods.
 * 2) An abstract class can have abstract methods.
 * 3) We cannot create an object of an abstract class directly.
 * 4) A child class must provide the body of the abstract method.
 */
