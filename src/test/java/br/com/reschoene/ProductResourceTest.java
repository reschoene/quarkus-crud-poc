package br.com.reschoene;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ProductResourceTest {

    @Test
    public void getProductsEndpoint() {
        given()
          .when().get("/products")
          .then()
             .statusCode(200);
    }

}