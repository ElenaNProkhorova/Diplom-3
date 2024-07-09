package tests;

import factory.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import pageObject.Constants;
import pageObject.Login;
import pageObject.UserRegistration;
import userApiEditor.DeleteUser;

import java.util.Random;

@DisplayName("Регистрация")
public class UserRegistrationTest {
    public int random5Numbers() {
        return new Random().nextInt(89999)+10000;
    }

    String name = Constants.DEFAULT_NAME + random5Numbers();
    String email = random5Numbers() + Constants.DEFAULT_EMAIL;
    String password = Constants.DEFAULT_PASSWORD;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Регистрация")
    @Description("Успешная регистрация")
    public void successfulRegistration () {
        new UserRegistration(driverFactory.getDriver())
                .userRegistration(name, email, password);
        new Login(driverFactory.getDriver())
                .userLogin(email, password)
                .checkUserLogin(name);
    }

    @After
    public void delete() {
        new DeleteUser().deleteCreatedUser(email, password);
    }
}
