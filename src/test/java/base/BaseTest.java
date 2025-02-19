package base;

import config.ApiConfig;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import utils.RestUtils;
// Базовый класс тестов
import static io.restassured.RestAssured.baseURI;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        baseURI = ApiConfig.getBaseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
