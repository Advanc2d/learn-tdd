package com.example.tdd.payment.application.port;

import com.example.tdd.order.domain.Order;
import com.example.tdd.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
