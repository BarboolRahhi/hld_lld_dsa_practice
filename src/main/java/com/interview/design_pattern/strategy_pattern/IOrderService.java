package com.interview.design_pattern.strategy_pattern;

import java.util.List;

public interface IOrderService {
    String buyItems(List<Item> items, PaymentStrategy paymentStrategy);
}
