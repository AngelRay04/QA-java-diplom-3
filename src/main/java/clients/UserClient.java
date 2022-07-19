package clients;

import models.User;

public class UserClient extends RestAssuredClient {
    private final String AUTH = "/auth";
    private final String CREATE_USER = AUTH + "/register";
    private final String USER = AUTH + "/user";

    public String createUser(User user) {
        return reqSpec.body(user).when().post(CREATE_USER).then().log().all().extract().path("accessToken");
    }

    public void deleteUser(String accessToken) {
        reqSpecWithoutHeaders.header("Authorization", accessToken).when().delete(USER);
    }
}
