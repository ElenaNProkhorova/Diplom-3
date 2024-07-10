package tests;

import factory.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pageObject.Constants;
import pageObject.Login;
import pageObject.Logout;
import userApiEditor.CreateUser;
import userApiEditor.DeleteUser;

import java.util.Random;

@DisplayName("Выход из аккаунта")
public class LogoutTest {
    public int random5Numbers() {
        return new Random().nextInt(89999)+10000;
    }
    String name = Constants.DEFAULT_NAME + random5Numbers();
    String email = random5Numbers() + Constants.DEFAULT_EMAIL;
    String password = Constants.DEFAULT_PASSWORD;

    @Before
    public void setUptest() {
        new CreateUser().createUser(email, password, name);
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Выход по кнопке «Выйти» в личном кабинете")
    public void successfulLogout() {

        //вход в аккаунт через UI
        new Login(driverFactory.getDriver())
                .userLogin(email, password)
                .checkUserLogin(name);

        //выход из аккаунта через UI
        new Logout(driverFactory.getDriver())
                .clickLogoutButton()
                .checkSuccessfulRedirect();
    }

    @After
    public void delete() {
        new DeleteUser().deleteCreatedUser(email, password);
    }
}
