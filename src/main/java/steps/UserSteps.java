package steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.User;

import static io.restassured.RestAssured.given;
import static steps.Endpoints.*;

public class UserSteps {
    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .body(user)
                .when()
                .post(REGISTER_USER)
                .then();
    }

    @Step("Авторизация юзера")
    public ValidatableResponse login(User user) {
        return given()
                .body(user)
                .when()
                .post(LOGIN_USER)
                .then();
    }

    @Step("Удаление юзера")
    public ValidatableResponse deleteUser(User user) {
        return given()
                .pathParam("accessToken", user.getAccessToken())
                .when()
                .delete(DELETE_USER)
                .then();
    }


    @Step("Получение токена")
    private static String getToken(User user) {
        ValidatableResponse loginResponse = given()
                .body(user)
                .when()
                .post(LOGIN_USER)
                .then()
                .assertThat()
                .statusCode(200);
        String token = loginResponse.extract().path("accessToken");
        if (token == null) {
            throw new IllegalArgumentException("Token is null");
        }
        return token;
    }
}
