package com.example.tdd.order;

import com.example.tdd.product.Product;

public interface OrderPort {
    Product getProductId(final Long productId);

    void save(final Order order);
}
