/*
Background:
A payment gateway processes various types of transactions—such as credit, debit, and digital wallets for e-commerce sites.
It must validate transaction details, communicate with banks, log transactions, and send confirmation or error responses.
The platform also requires fraud detection and report generation for each transaction type.

Question: What are the classes you might need in this software solution?
*/

interface TransactionProcessor {
    void validate(Transaction transaction);

    void process(Transaction transaction);
}

interface FraudDetector {
    boolean detectFraud(Transaction transaction);
}

interface Logger {
    boolean logTransaction(Transaction transaction);
}

interface ReportGenerator {
    Report generateReport();
}

class DebitTransactionProcessor implements TransactionProcessor {
    public void validate(Trasaction trasaction) {
        // trx validation logic
    }

    public void process(Trasaction trasaction) {
        // process trx
    }
}

class WalletTransactionProcessor implements TransactionProcessor {
    public void validate(Trasaction trasaction) {
        // trx validation logic
    }

    public void process(Trasaction trasaction) {
        // process trx
    }
}

class PaymentService {
    private TransactionProcessor transactionProcessor;
    private FraudDetector fraudDetector;
    private Logger logger;
    private ReportGenerator reportGenerator;

    public PaymentService(
            TransactionProcessor processor,
            FraudDetector fraudDetector,
            Logger logger,
            ReportGenerator reportGenerator
    ) {
        this.processor = processor;
        this.fraudDetector = fraudDetector;
        this.logger = logger;
        this.reportGenerator = reportGenerator;
    }

    public void handlePayment(Transaction transaction) {
        // payment handle logic
    }
}