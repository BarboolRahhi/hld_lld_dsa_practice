package com.interview.design_pattern.strategy_pattern;

import java.util.Collections;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        var items = List.of(
                new Item("Iphone", 55000),
                new Item("Glass bottel", 600)
        );

        IOrderService orderService = new OrderService();

        var payment = new CreditCardPayment("Rahhi", "345623452345", 456, "12/29");
        var details = orderService.buyItems(items, payment);
        System.out.println(details);

        var paymentUPI = new UpiPayment("rahhi@okhdfc");
        var details1 = orderService.buyItems(items, paymentUPI);
        System.out.println(details1);

        // Example: Collections.sort();
    }
}
