package com.example.tdd.payment;

interface PaymentGateway {
    void excute(int totalPrice, String cardNumber);
}
