/*
Background: An e-commerce platform calculates taxes based on the customer’s location.
Initially, it supports tax calculations for a few regions (e.g., state, federal, international) with specific rules.
As the platform expands, it needs to add more location-specific tax rules without altering the existing
logic for current locations.

Question: How would you implement the tax calculation system to allow new location-based tax rules to be added
without modifying the original tax classes?
*/


interface TaxCalculator {
    public double calculateTax(Order order);
}

class StateTaxCalculator implements TaxCalculator {
    public double calculateTax(Order order) {
        // tax logic
    }
}

class FederalTaxCalculator implements TaxCalculator {
    public double calculateTax(Order order) {
        // tax logic
    }
}

class InternationalTaxCalculator implements TaxCalculator {
    public double calculateTax(Order order) {
        // tax logic
    }
}

class TaxCalculatorFactory {
    public static TaxCalculator getTaxCalculator(String location) {
        switch (location) {
            case "state":
                return new StateTaxCalculator();
            case "federal":
                return new FederalTaxCalculator();
            case "international":
                return new InternationalTaxCalculator();
            default:
                throw new IllegalArgumentException("Unknown location: " + location);
        }
    }
}

class OrderService {
    public void processOrder(Customer customer) {
        Order order = new Order();
        TaxCalculator taxCalculator = new TaxCalculatorFactory.getTaxCalculator(customer.location);
        double taxAmount = taxCalculator.calculateTax(order);
    }
}