package com.example.tdd.payment;

import org.springframework.stereotype.Component;

@Component
interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);
}
