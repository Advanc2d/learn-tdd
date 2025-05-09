package com.example.tdd.order.application.service;

import com.example.tdd.order.application.port.OrderPort;
import com.example.tdd.order.domain.Order;
import com.example.tdd.product.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderService {
    private final OrderPort orderPort;

    OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
        final Product product = orderPort.getProductId(request.productId());

        final Order order = new Order(product, request.quantity());

        orderPort.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
