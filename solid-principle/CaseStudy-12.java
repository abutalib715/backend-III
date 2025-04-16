/*
Background: An online store supports various payment types through a PaymentMethod class.
Some payment types, like BankTransfer or DigitalWallet, may need additional information to complete the payment.
The store expects to handle any payment method uniformly without unexpected errors.

Question: How would you design the PaymentMethod and its subclasses
so that the store can process any payment type seamlessly?*/

interface PaymentInterface {
    pay(Order order);
}

class PaymentMethod {
    PaymentInterface processPayment(String paymentType) {
        if (paymentType.equals("BankTransfer")) {
            return new BankTransfer();
        } else if (paymentType.equals("DigitalWallet")) {
            return new DigitalWallet();
        }
    }
}

class BankTransfer implements PaymentInterface {
    public void pay(Order order) {
        // process payement
    }
}

class DigitalWallet implements PaymentInterface {
    public void pay(Order order) {
        // process payement
    }
}

class Order {
    // ENTITIES
}

class Main(){
    Order order = new Order();
    PaymentMethod paymentMethod = new PaymentMethod();
    PaymentInterface payment = paymentMethod.processPayment("DigitalWallet");
    payment.pay(order);
}