package com.interview.design_pattern.observer_pattern;

public class Store {
    private final NotificationService notificationService;

    public Store() {
        this.notificationService = new NotificationService();
    }

    public void newItemArrived(EventType eventType) {
        this.notificationService.notifyCustomers(eventType);
    }

    public NotificationService getNotificationService() {
        return this.notificationService;
    }

}
