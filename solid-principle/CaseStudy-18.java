/*
Background: A mobile application sends notifications to users through various channels, such as email and SMS.
The platform wants to add additional channels (e.g., push notifications, in-app alerts) in the future.
New notification types should be integrated without changing existing notification classes.

Question: How would you design a notification system that allows the addition of new notification
channels without modifying existing code?*/


interface Notification {
    void send();
}

class EmailNotification implements Notification {
    public void send() {
        // notification sending logic
    }
}

class SmsNotification implements Notification {
    public void send() {
        // notification sending logic
    }
}

class PushNotification implements Notification {
    public void send() {
        // notification sending logic
    }
}

class InAppNotification implements Notification {
    public void send() {
        // notification sending logic
    }
}

class NotificationService {
    private List<Notification> notificationChannels = new ArrayList();

    public void addChannel(Notification notification) {
        channels.add(notification);
    }

    public void notifyAllChannels(String message) {
        for (NotificationChannel notification : notificationChannels) {
            notification.sendNotification(message);
        }
    }
}

class MobileApplication {
    public void main() {
        NotificationService notificationService = new NotificationService(new SmsNotification());
    }
}