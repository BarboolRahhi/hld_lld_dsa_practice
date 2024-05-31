package com.interview.design_pattern.strategy_pattern;

public class UpiPayment implements PaymentStrategy {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double cost) {
        System.out.println(STR."Paid Rs.\{cost} with UPI Id: \{upiId}");
    }

    @Override
    public String paymentType() {
        return "UPI payment";
    }
}
