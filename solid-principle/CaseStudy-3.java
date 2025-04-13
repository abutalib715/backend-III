/*
Background: An event management system allows users to view available events, make reservations,
pay for tickets, and receive notifications. Each event has specific seat allocations, which need real-time updates.
Cancellations should be handled with refund options, and users must be notified of successful reservations or cancellations.

Question: What are the classes you might need in this software solution?*/

class Event {

}

class EventController {
    List<Event> availableEvents() {

    }

    makeReservation() {

    }

    makePayment(Event event) {

    }

    cancelReservation() {

    }
}

class EventService {
    List<Event> availableEvents() {

    }

    makeReservation() {
        checkSeatAvailavility()
        // DO RESERVATION
        makePayment()
        // Publish the event
        eventPublisher.EventReservationEvent(new EventReservationEvent(this));
    }

    makePayment(Event event) {

    }

    checkSeatAvailavility() {

    }

    cancelReservation() {
        // DO CANCELLATION
        refundMoney()
        // Publish the event
        eventPublisher.EventCancellationEvent(new EventCancellationEvent(this));
    }

    refundMoney() {

    }
}

class EventReservationEvent extends ApplicationEvent {

}

class EventReservationEventListener {

    @EventListner
    handleReservation() {
        // NOTIFY USER
    }
}

class EventCancellationEvent extends ApplicationEvent {

}

class EventCancellationEventListener {

    @EventListner
    handleCancellation() {
        // NOTIFY USER
    }
}