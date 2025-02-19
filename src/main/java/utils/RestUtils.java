package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static config.ApiConfig.getBaseUrl;
import static io.restassured.RestAssured.given;

// Класс для работы с запросами
public class RestUtils {
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(getBaseUrl())
            .addHeader("Content-Type", "application/json")
            .build();

    public static Response sendPostRequest(String endpoint, Object body) {
        return given()
                .spec(requestSpec)
                .body(body)
                .log().all()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response sendGetRequest(String endpoint, int id) {
        return given()
                .spec(requestSpec)
                .pathParam("id", id)
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
