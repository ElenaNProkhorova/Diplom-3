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
import pageObject.RedirectByNavigationMenu;
import userApiEditor.CreateUser;
import userApiEditor.DeleteUser;

import java.util.Random;

@DisplayName("Переход из ЛК в Конструктор")
public class RedirectByNavigationMenuTest {
    public int random5Numbers() {
        return new Random().nextInt(89999)+10000;
    }
    String name = Constants.DEFAULT_NAME + random5Numbers();
    String email = random5Numbers() + Constants.DEFAULT_EMAIL;
    String password = Constants.DEFAULT_PASSWORD;

    @Before
    public void setUptest() {
        new CreateUser().createUser(email, password, name);

        Login login = new Login(driverFactory.getDriver());
        login.userLogin(email, password);
        login.checkUserLogin(name);
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Переход по клику на «Конструктор»")
    public void redirectByConstructorButton() {

        //проверка перехода на главную страницу по клику на [Конструктор]
        new RedirectByNavigationMenu(driverFactory.getDriver())
                .clickConstructorButton()
                .checkSuccessfulRedirect();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Переход по клику на «Конструктор»")
    public void redirectByLogoButton() {
        //проверка перехода на главную страницу по клику на [Лого]
        new RedirectByNavigationMenu(driverFactory.getDriver())
                .clickLogoButton()
                .checkSuccessfulRedirect();
    }

    @After
    public void delete() {
        new DeleteUser().deleteCreatedUser(email, password);
    }
}
