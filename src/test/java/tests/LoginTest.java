package tests;

import factory.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.Constants;
import pageObject.Login;
import userApiEditor.CreateUser;
import userApiEditor.DeleteUser;

import java.util.Random;

@DisplayName("Вход")
public class LoginTest {
    public int random5Numbers() {
        return new Random().nextInt(89999)+10000;
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Вход")
    @Description("Вход в аккаунт")
    public void successfulLogin() {

        String name = Constants.DEFAULT_NAME + random5Numbers();
        String email = random5Numbers() + Constants.DEFAULT_EMAIL;
        String password = Constants.DEFAULT_PASSWORD;

        //создание нового пользователя через API
        new CreateUser().createUser(email, password, name);

        //вход в аккаунт через UI
        new Login(driverFactory.getDriver())
                .userLogin(email, password)
                .checkUserLogin(name);

        //удаление нового пользователя через API
        new DeleteUser().deleteCreatedUser(email, password);
    }
}
