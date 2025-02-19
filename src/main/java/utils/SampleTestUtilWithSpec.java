package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

// �����, ���� ����� ���������� � �������, ���������� ������������ � �� ��������� ���������
// (���� � ������� ������ ������ ���������, �� ����� �������� ��� RequestSpecification)
public class SampleTestUtilWithSpec {
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseURI) // ������������� ������� URL
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
                .spec(getRequestSpec()) // ���������� ������������
                .body(body)
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response sendGetRequest(String endpoint, int id) {
        return given()
                .spec(getRequestSpec()) // ���������� ������������
                .pathParam("id", id)
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}
