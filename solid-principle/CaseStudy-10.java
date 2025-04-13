/*
Background: An e-commerce platform manages products with various types, such as physical goods, digital downloads,
and services. Physical goods need methods for shipping, inventory tracking, and delivery, while digital products
only require download and licensing methods. Service-based products may need scheduling functionality.
The product interface should avoid imposing irrelevant methods on different product types.
Question: How would you design interfaces for these different product types?

*/

interface PhysicalProduct {
    handleShipment();

    trackInventory();

    handleDelivery();

}

interface DigitalProduct {
    downloadProduct();

    checkProductLicense();
}

interface ServiceProduct {
    scheduleService();
}


// IMPL EXAMPLE FROM CHAT GPT
class PhysicalItem implements Product, PhysicalProduct {
    public void handleShipment() {
        // shipping logic
    }

    public void trackInventory() {
        // inventory logic
    }

    public void handleDelivery() {
        // delivery logic
    }

    public String getName() {
        return "Laptop";
    }

    public double getPrice() {
        return 1000.0;
    }
}

class DigitalItem implements Product, DigitalProduct {
    public void downloadProduct() {
        // download logic
    }

    public void checkProductLicense() {
        // license check logic
    }

    public String getName() {
        return "E-Book";
    }

    public double getPrice() {
        return 20.0;
    }
}

class ServiceItem implements Product, ServiceProduct {
    public void scheduleService() {
        // scheduling logic
    }

    public String getName() {
        return "Online Tutoring";
    }

    public double getPrice() {
        return 50.0;
    }
}