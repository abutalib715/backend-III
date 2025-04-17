/*
Background: An online store processes payments using a specific payment gateway (e.g., PayPal).
The store might later integrate additional payment providers or switch to another gateway entirely.
The payment processing logic should not rely directly on any specific payment provider.

Question: How would you design the payment processing module so that it can handle different payment
gateways without altering the main payment logic?*/

interface PaymentInterface {
    pay(Order order);
}

class PaymentGatewayFactory {
    PaymentInterface getPaymentMethod(String paymentType) {
        if (paymentType.equals("Paypal")) {
            return new Paypal();
        } else if (paymentType.equals("BankTransfer")) {
            return new BankTransfer();
        }
    }
}

class BankTransfer implements PaymentInterface {
    public void pay(Order order) {
        // process payement
    }
}

class Paypal implements PaymentInterface {
    public void pay(Order order) {
        // process payement
    }
}

class Order {
    // ENTITIES
}

class Main() {
    Order order = new Order();
    PaymentGatewayFactory PaymentGatewayFactory = new PaymentGatewayFactory();
    PaymentInterface payment = PaymentGatewayFactory.getPaymentMethod("Paypal");
    payment.pay(order);
}