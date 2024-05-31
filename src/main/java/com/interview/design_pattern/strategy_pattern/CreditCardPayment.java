package com.interview.design_pattern.strategy_pattern;

public class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private int cvvNumber;
    private String dateOfExpir;

    public CreditCardPayment(String name, String cardNumber, int cvvNumber, String dateOfExpir) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvvNumber = cvvNumber;
        this.dateOfExpir = dateOfExpir;
    }

    @Override
    public void pay(double cost) {

        System.out.println(STR."""
                \{name} paid Rs.\{cost} by credit card: \{cardNumber}
                """);
    }

    @Override
    public String paymentType() {
        return "Credit Card";
    }
}
