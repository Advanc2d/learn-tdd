package com.example.tdd.payment.adapter;

import com.example.tdd.order.domain.Order;
import com.example.tdd.order.adapter.OrderRepository;
import com.example.tdd.payment.application.port.PaymentPort;
import com.example.tdd.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    PaymentAdapter(PaymentGateway paymentGateway,
                   OrderRepository orderRepository,
                   PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.excute(totalPrice, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

}