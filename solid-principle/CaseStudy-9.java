/*
Background: An e-commerce platform applies different discounts based on promotions or
customer segments (e.g., seasonal discounts, loyalty discounts, bulk purchase discounts).
The marketing team frequently introduces new types of discounts. The system should allow adding
new discount types without modifying the code for existing discounts.

Question: How would you design the discount calculation system so that new discount types can be introduced without
changing the existing discount logic?*/


interface Discountable {
    double calculateDiscount();
}

class SeasonalDiscount implements Discountable {
    @java.lang.Override
    public double calculateDiscount() {
        // SET DISCOUNT LOGIC
        return 0;
    }
}

class LoyalityDiscount implements Discountable {
    @java.lang.Override
    public double calculateDiscount() {
        // SET DISCOUNT LOGIC
        return 0;
    }
}

class BulkPurchaseDiscount implements Discountable {
    @java.lang.Override
    public double calculateDiscount() {
        // SET DISCOUNT LOGIC
        return 0;
    }
}

class OrderService {
    processOrder() {
        // PROCESS ORDER
        // APPLY DISCOUNT
        applyDiscount(order)
    }

    double applyDiscount(Order order) {
        // APPLY DISCOUNT LOGIC AND RETURN AMOUNT
    }
}