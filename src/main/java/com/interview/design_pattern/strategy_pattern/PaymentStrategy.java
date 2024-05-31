package com.interview.design_pattern.strategy_pattern;

public interface PaymentStrategy {
    void pay(double cost);
    String paymentType();
}
