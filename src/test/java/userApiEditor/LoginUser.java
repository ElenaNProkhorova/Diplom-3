package userApiEditor;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class LoginUser {
    private String email;
    private String password;

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Step("Авторизации пользователя и получение токена")
    public String getLoginUserAccessToken(LoginUser newLoginUser) {
        LoginUserDeserialization loggedUser =  given()
                .header("Content-type", "application/json")
                .body(newLoginUser)
                .post(Resources.LOGIN_USER_API)
                .as(LoginUserDeserialization.class);
        return loggedUser.getAccessToken();
    }
}
