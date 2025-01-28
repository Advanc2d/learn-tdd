package com.example.tdd.payment;

public class ConsolePaymentGatewayImpl implements PaymentGateway {

    @Override
    public void excute(int totalPrice, String cardNumber) {
        System.out.println("결제 완료");
    }
}
