package userApiEditor;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Step("Удаление пользователя")
    public void deleteCreatedUser(String email, String password) {

        LoginUser newLoginUser = new LoginUser(email, password);
        String accessToken = newLoginUser.getLoginUserAccessToken(newLoginUser);
        given()
                .header("Authorization", accessToken)
                .delete(Resources.USER_INFO_API)
                .then()
                .assertThat()
                .statusCode(202);
    }
}
