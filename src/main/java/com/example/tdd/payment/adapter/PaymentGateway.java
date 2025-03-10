package com.example.tdd.payment.adapter;

import org.springframework.stereotype.Component;

@Component
interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);
}
