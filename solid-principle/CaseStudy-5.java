/*
Background: An online store needs a backend to handle order placement, track payment, and manage shipment information.
Each order involves checking inventory, processing payments, and updating shipment status.
The system should also notify customers of order status changes and generate invoices for each order.

Question: What are the classes you might need in this software solution?*/

class OrderController {

    placeOrder() {
    }

}

class OrderService {
    InventoryCheckingService inventoryCheckingService;
    PaymentService paymentService;
    ShipmentService shipmentService;

    placeOrder() {
        inventoryCheckingService.checkInventory();
        // PLACE ORDER
        paymentService.makePayment(order);
        shipmentService.shipOrder(order);
    }
}

class PaymentService {
    makePayment(Order order) {
    }
}

class ShipmentService {
    shipOrder(Order order) {
    }
}

class InventoryCheckingService {
    checkInventory(Product product) {
    }
}

class InvoiceSendingService {
    sendInvoice(Order order) {
    }
}

class Order {
    // ENTITY HERE
}

class OrderConfirmationEvent extends ApplicationEvent {

}

class OrderStatusChangeEvent extends ApplicationEvent {

}

class OrderConfirmationEventListner {
    InvoiceSendingService invoiceSendingService;

    @EventListner
    handleEvent(OrderConfirmationEvent event) {
        invoiceSendingService.sendInvoice();
        // SEND EMAIL NOTIFICATION
    }
}

class OrderStatusChangeEventListner {

    @EventListner
    handleEvent(OrderStatusChangeEvent event) {
        // NOTIFY ORDER STATUS TO USER
    }
}

