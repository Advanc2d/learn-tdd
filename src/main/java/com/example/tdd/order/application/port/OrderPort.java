package com.example.tdd.order.application.port;

import com.example.tdd.order.domain.Order;
import com.example.tdd.product.domain.Product;

public interface OrderPort {
    Product getProductId(final Long productId);

    void save(final Order order);
}
