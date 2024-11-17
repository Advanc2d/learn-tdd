package com.example.tdd.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        final ProductPort port = new ProductPort() {
            @Override
            public void save(Product product) {

            }

            @Override
            public Product getProduct(Long productId) {
                return null;
            }
        };

        productService = new ProductService(null);
    }

    @Test
    void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);

        productService.updateProduct(productId, request);
    }

}
