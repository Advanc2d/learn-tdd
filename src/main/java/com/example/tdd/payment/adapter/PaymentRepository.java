package com.example.tdd.payment.adapter;

import com.example.tdd.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {
}
