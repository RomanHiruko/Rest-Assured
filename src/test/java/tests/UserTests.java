package tests;

import clients.UserClient;
import io.qameta.allure.Step;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import models.User;
import org.junit.jupiter.api.Test;
import utils.DataGenerator;

import static assertions.UserAssertions.validateUserCreated;
import static assertions.UserAssertions.validateUserExists;

@Epic("User API")
@Feature("User Management")
public class UserTests {
    private final UserClient userClient = new UserClient();

    @Test
    @Story("Create a new user")
    @Step("Creating a new user")
    public void createUserTest() {
        User user = new User(DataGenerator.generateRandomName(), DataGenerator.generateRandomJob());
        Response response = userClient.createUser(user);
        logResponse(response);
        validateUserCreated(response, user.getName(), user.getJob());
    }

    @Test
    @Story("Retrieve an existing user")
    @Step("Fetching user details")
    public void getUserTest() {
        Response response = userClient.getUser(2);
        logResponse(response);
        validateUserExists(response);
    }

    @Step("Logging response")
    private void logResponse(Response response) {
        response.getBody().print();
    }
}
