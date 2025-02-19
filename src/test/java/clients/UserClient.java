package clients;

import io.restassured.response.Response;
import models.User;
import utils.RestUtils;

import static constants.UserEndpoints.CREATE_USER;
import static constants.UserEndpoints.GET_USER;
import static io.restassured.RestAssured.baseURI;

// Класс для работы с api user
public class UserClient {

    public Response createUser(User user) {
        return RestUtils.sendPostRequest(CREATE_USER, user);
    }

    public Response getUser(int userId) {
        return RestUtils.sendGetRequest(GET_USER, userId);
    }
}
