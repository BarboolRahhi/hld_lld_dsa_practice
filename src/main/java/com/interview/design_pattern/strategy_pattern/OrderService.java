package com.interview.design_pattern.strategy_pattern;

import java.util.List;

public class OrderService implements IOrderService {

    @Override
    public String buyItems(List<Item> items, PaymentStrategy paymentStrategy) {
        var totalPrice = items.stream().mapToInt(Item::price).sum();
        paymentStrategy.pay(totalPrice);
        return STR."""
                   Payment Type: \{paymentStrategy.paymentType()}
                   Total Cost: Rs.\{totalPrice}
                """;
    }

}
