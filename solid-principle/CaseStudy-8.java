/*
Background: A payment processing system handles different types of transactions.
Credit card payments require additional verification, such as CVV and expiry date checks, while bank transfers
need account number validation. Digital wallets only need an email or phone number for verification.
The payment interface should not impose methods that are irrelevant to each payment type.

Question: How would you design interfaces?*/

interface PaymentVerification {
    boolean verifyAccountInfo();
}

class PaymentProcessingService {

}

class CreditCardPayment implements PaymentVerification {
    private String cvv;
    private String expiryDate;

    boolean verifyAccountInfo() {

    }

    private boolean validateCvv() {
    }

    private boolean validateExpirationDate() {
    }
}

class DigitalWalletPayment implements PaymentVerification {
    private String mobileNo;

    boolean verifyAccountInfo() {

    }
}

class BankTransfer implements PaymentVerification {
    private String accountNo;

    boolean verifyAccountInfo() {

    }

    private boolean validateAccountNo() {
    }
}