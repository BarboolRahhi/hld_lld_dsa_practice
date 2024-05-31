package com.interview.design_pattern.observer_pattern;


import java.util.*;

public class NotificationService {

    private final Map<EventType, List<EventListener>> customers;

    public NotificationService() {
        this.customers = new HashMap<>();
        Arrays.stream(EventType.values()).forEach(event -> customers.put(event, new ArrayList<>()));
    }

    public void subscribe(EventType eventType, EventListener listener) {
        var listeners = customers.get(eventType);
        listeners.add(listener);
        customers.put(eventType, listeners);
    }

    public void unsubscribe(EventType eventType, EventListener listener) {
        var listeners = customers.get(eventType);
        listeners.remove(listener);
        customers.put(eventType, listeners);
    }

    public void notifyCustomers(EventType eventType) {
        customers.get(eventType).forEach(EventListener::update);
    }

}
