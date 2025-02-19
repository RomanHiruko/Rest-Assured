package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

// Класс, если много заголовков в запросе, используем Спецификацию и не дублируем заголовки
// (Если у каждого метода разные заголовки, то лучше оставить без RequestSpecification)
public class SampleTestUtilWithSpec {
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseURI) // Устанавливаем базовый URL
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer token123")
            .addHeader("Accept", "application/json")
            .addHeader("Custom-Header", "CustomValue")
            .build();

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }

    public static Response sendPostRequest(String endpoint, Object body) {
        return given()
                .spec(getRequestSpec()) // Используем спецификацию
                .body(body)
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response sendGetRequest(String endpoint, int id) {
        return given()
                .spec(getRequestSpec()) // Используем спецификацию
                .pathParam("id", id)
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}
