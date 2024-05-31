package com.interview.design_pattern.observer_pattern;

import java.util.Objects;

public class MobileMessageListener implements EventListener {
    private final String userName;

    public MobileMessageListener(String email) {
        this.userName = email;
    }

    @Override
    public void update() {
        System.out.printf("Sent message to %s on mobile.", userName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobileMessageListener that = (MobileMessageListener) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
