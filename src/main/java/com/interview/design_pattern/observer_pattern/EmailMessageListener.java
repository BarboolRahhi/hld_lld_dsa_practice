package com.interview.design_pattern.observer_pattern;

import java.util.Objects;

public class EmailMessageListener implements EventListener {
    private final String email;

    public EmailMessageListener(String email) {
        this.email = email;
    }

    @Override
    public void update() {
        System.out.printf("Sent email to %s%n", email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailMessageListener that = (EmailMessageListener) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
