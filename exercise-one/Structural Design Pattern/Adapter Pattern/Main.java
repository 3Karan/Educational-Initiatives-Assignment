// Target Interface (Unified Payment Gateway)
interface PaymentGateway {
    void pay(double amount);
}

// Adaptee 1: Stripe Payment System (existing, incompatible API)
class Stripe {
    public void makePayment(double amountInDollars) {
        System.out.println("Payment made using Stripe: $" + amountInDollars);
    }
}

// Adaptee 2: PayPal Payment System (existing, incompatible API)
class PayPal {
    public void sendPayment(double amountInDollars) {
        System.out.println("Payment made using PayPal: $" + amountInDollars);
    }
}

// Adapter for Stripe to implement PaymentGateway
class StripeAdapter implements PaymentGateway {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void pay(double amount) {
        stripe.makePayment(amount);
    }
}

// Adapter for PayPal to implement PaymentGateway
class PayPalAdapter implements PaymentGateway {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void pay(double amount) {
        payPal.sendPayment(amount);
    }
}

// Main class to test the Adapter pattern
public class Main {
    public static void main(String[] args) {
        // Using Stripe with an adapter
        Stripe stripe = new Stripe();
        PaymentGateway stripePayment = new StripeAdapter(stripe);
        stripePayment.pay(100.0);

        // Using PayPal with an adapter
        PayPal payPal = new PayPal();
        PaymentGateway payPalPayment = new PayPalAdapter(payPal);
        payPalPayment.pay(200.0);
    }
}
