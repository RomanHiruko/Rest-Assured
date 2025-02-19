package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
//  ласс, если много заголовков в запросе, приходитс€ дублировать их
// ƒублирование кода
// ≈сли заголовки измен€тс€, придетс€ мен€ть везде
public class SampleTestUtilWithoutSpec {

    public static Response sendPostRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer token123")
                .header("Accept", "application/json")
                .header("Custom-Header", "CustomValue")
                .body(body)
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response sendGetRequest(String endpoint, int id) {
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer token123")
                .header("Accept", "application/json")
                .header("Custom-Header", "CustomValue")
                .pathParam("id", id)
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

}
