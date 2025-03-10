package com.example.tdd.product.application.port;

import com.example.tdd.product.domain.Product;

interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}
