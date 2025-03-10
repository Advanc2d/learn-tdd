package com.example.tdd.product;

import com.example.tdd.ApiTest;
import com.example.tdd.product.application.service.AddProductRequest;
import com.example.tdd.product.application.service.UpdateProductRequest;
import com.example.tdd.product.domain.DiscountPolicy;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps extends ApiTest {
    public static ExtractableResponse<Response> 상품등록요청(final AddProductRequest request) {
        return RestAssured.given().log().all()         // 요청 로그를 남김
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    public static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        return new AddProductRequest(name, price, discountPolicy);
    }

    public static ExtractableResponse<Response> 상품조회요청(Long productId) {
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .when()
                .get("/products/{productId}", productId)
                .then().log().all()
                .extract();
        return response;
    }

    public static UpdateProductRequest 상품수정요청_생성() {
        return new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
    }

    static ExtractableResponse<Response> 상품수정요청(long productId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(상품수정요청_생성())
                .when()
                .patch("/products/{productId}", productId)
                .then()
                .log().all().extract();
    }
}
