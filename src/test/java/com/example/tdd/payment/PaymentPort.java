package com.example.tdd.payment;

import com.example.tdd.order.Order;

interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(Payment payment);

    void save(Payment payment);
}
