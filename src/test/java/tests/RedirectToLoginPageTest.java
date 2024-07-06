package tests;

import factory.DriverFactory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pageObject.RedirectToLoginPage;

@DisplayName("Редирект на страницу ЛК")
@RunWith(Parameterized.class)
public class RedirectToLoginPageTest {
    private final String START_PAGE_URL;
    private final By LOGIN_BUTTON_LOCATOR;

    public RedirectToLoginPageTest(String START_PAGE_URL, By LOGIN_BUTTON_LOCATOR) {
        this.START_PAGE_URL = START_PAGE_URL;
        this.LOGIN_BUTTON_LOCATOR = LOGIN_BUTTON_LOCATOR;
    }

    @Parameterized.Parameters
    public static Object [][] testDataOfLoginPageRedirect() {
        return new Object[][] {
                {RedirectToLoginPage.MAIN_PAGE_URL, RedirectToLoginPage.MAIN_PAGE_PERSONAL_ACCOUNT_LOCATOR},
                {RedirectToLoginPage.MAIN_PAGE_URL, RedirectToLoginPage.MAIN_PAGE_LOGIN_IN_ACCOUNT_LOCATOR},
                {RedirectToLoginPage.FORGOT_PASSWORD_PAGE_URL, RedirectToLoginPage.FORGOT_PASSWORD_PAGE_LOGIN_BUTTON_LOCATOR},
                {RedirectToLoginPage.REGISTRATION_PAGE_URL, RedirectToLoginPage.REGISTRATION_PAGE_LOGIN_BUTTON_LOCATOR}
        };
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Вход")
    @Description("Вход в аккаунт")
    //проверка редиректа на страницу "Личного кабинета" для неавторизованного пользователя
    public void loginPageRedirect () {
        new RedirectToLoginPage(driverFactory.getDriver())
                .openPage(START_PAGE_URL)
                .clickLoginButton(LOGIN_BUTTON_LOCATOR)
                .checkSuccessfulRedirect();
    }
}
