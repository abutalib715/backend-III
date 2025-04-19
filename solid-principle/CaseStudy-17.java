/*
Background: A notification system sends different types of notifications, such as SMS, email, and push notifications.
Each type has specific requirements (e.g., SMS requires a phone number, while email requires an email address).
The notification interface should avoid requiring any one notification type to provide
unnecessary information or implement irrelevant methods.

Question: How would you design the interfaces for notifications?
*/

interface SendNotification {
    void send(Notification notification);
}

class EmailNotification implements SendNotification {
    private String email;

    EmailNotification(String email) {
        this.email = email;
    }

    public void send(Notification notification) {
        // email sending logic
    }
}

class SmsNotification implements SendNotification {
    private String mobileNo;

    SmsNotification(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void send(Notification notification) {
        // sms sending logic
    }
}

class PushNotification implements SendNotification {
    private User user;

    PushNotification(User user) {
        this.user = user;
    }

    public void send(Notification notification) {
        // Push notification logic
    }
}

