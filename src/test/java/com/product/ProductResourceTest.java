/*
package com.product;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.product.entity.Product;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ProductResourceTest {

    @Test
    void testAddProduct() {
        Product product = new Product("Laptop", "Powerful laptop", 1200.00, 10);

        given()
                .contentType(ContentType.JSON)
                .body(product)
                .when()
                .post("/products")
                .then()
                .statusCode(201);
    }

    @Test
    public void testGetAllProducts() {
        given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("$", not(empty()));
    }
}
*/
