/*
Background: A warehouse needs an automated inventory system to manage items stored across various locations.
The system must track item quantities, update stock levels when items are added or removed, and
notify warehouse staff when inventory is low or restocked.
The system will also generate reports on stock movements and item status.

Question: What are the classes you might need in this software solution?
*/

class Product {
    private String id;
    private String name;
    private double price;
}

class Location {
    private String id;
    private String name;
}

class InventoryService {
    private Location location;
    private Notification notification;

    public InventoryService(Location location, Notification notification) {
        this.location = location;
        this.notification = notification;
    }

    public void addItem(Product product) {
        // add stock logic
        // if re stock send re stock notification
    }

    public void removeItem(Product product) {
        // remove stock logic
        // if low stock send low stock notification
    }

    public double checkQuantity(Product product) {
        // check stock logic
    }
}

interface Notification {
    public void sendMessage();
}

class EmailNotification implements Notification {
    public void sendMessage() {
        // send msg
    }
}

class SmsNotification implements Notification {
    public void sendMessage() {
        // send msg
    }
}

interface ReportGenerator {
    public void generateReport();
}

class StockMovementReport implements ReportGenerator {
    public void generateReport() {
        // report
    }
}

class InventoryStatusReport implements ReportGenerator {
    public void generateReport() {
        // report
    }
}



