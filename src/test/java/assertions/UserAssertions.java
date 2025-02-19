package assertions;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
// Проверки
public class UserAssertions {

    public static void validateUserCreated(Response response, String expectedName, String expectedJob) {
        response.then()
                .statusCode(201)
                .body("name", equalTo(expectedName))
                .body("job", equalTo(expectedJob));
    }

    public static void validateUserExists(Response response) {
        response.then()
                .statusCode(200)
                .body("data.id", notNullValue());
    }
}
