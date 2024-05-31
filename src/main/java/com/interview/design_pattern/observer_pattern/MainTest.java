package com.interview.design_pattern.observer_pattern;

import java.util.HashMap;

public class MainTest {

    public static void main(String[] args) {

        var store = new Store();
        var notificationService = store.getNotificationService();
        notificationService.subscribe(EventType.NEW_ITEM, new EmailMessageListener("rahhi@gmail.com"));
        notificationService.subscribe(EventType.NEW_ITEM, new MobileMessageListener("rahhi barbool"));

        notificationService.subscribe(EventType.SALE, new MobileMessageListener("Ajay Kumar"));
        notificationService.unsubscribe(EventType.NEW_ITEM, new EmailMessageListener("rahhi@gmail.com"));

        store.newItemArrived(EventType.NEW_ITEM);
    }
}
