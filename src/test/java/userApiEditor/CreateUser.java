package userApiEditor;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class CreateUser {
    private String email;
    private String password;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CreateUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public CreateUser() {
    }

    @Step("Создания пользователя")
    public CreateUser createUser(String email, String password, String name) {

        CreateUser newCreatedUser = new CreateUser(email, password, name);
        given()
                .header("Content-type", "application/json")
                .body(newCreatedUser)
                .post(Resources.CREATE_USER_API)
                .then()
                .statusCode(200);
        return this;
    }
}
