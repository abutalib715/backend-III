/*
Background: A web application requires logging for various events, initially using a specific logging library.
        However, there might be a need to replace or extend the logging system in the future
        (e.g., to support a cloud-based logging service or custom logging formats).

Question: How would you design the logging system to allow easy replacement or addition of different logging
implementations without modifying the main */

interface Loggable {
    saveLog();
}


class LogFactory() {
    public Loggable getLogger(logStorageType) {
        Loggable loggable;

        if (logStorageType.equals("LogLibraryA")) {
            loggable = new LogLibraryA();
        } else if (logStorageType.equals("CloudBasedLog")) {
            loggable = new CloudBasedLog();
        } else if (logStorageType.equals("CustomLog")) {
            loggable = new CustomLog();
        }
    }
}

class LogLibraryA implements Loggable {
    saveLog() {
        // Logging mechanism
    }
}

class CloudBasedLog implements Loggable {
    saveLog() {
        // Logging mechanism
    }
}

class CustomLog implements Loggable {
    saveLog() {
        // Logging mechanism
    }
}

class PaymentService {
    public PaymentService(String logType) {
        LogFactory logFactory = new LogFactory();
        this.logger = logFactory.getLogger(logType);
    }

    public void processPayment() {
        // Payment logic here...
        logger.saveLog("Payment processed.");
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService("CloudBasedLog");
        paymentService.processPayment();
    }
}
