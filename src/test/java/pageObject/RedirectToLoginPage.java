package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RedirectToLoginPage {
    //URL для перехода на "Главную страницу"
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    //URL для перехода на  страницу "Регистрации"
    public static final String REGISTRATION_PAGE_URL = MAIN_PAGE_URL + "register";
    //URL для перехода на страницу "Восстановления пароля"
    public static final String FORGOT_PASSWORD_PAGE_URL = MAIN_PAGE_URL + "forgot-password";


    //локатор кнопки [Личный Кабинет] на главной странице
    public static final By MAIN_PAGE_PERSONAL_ACCOUNT_LOCATOR = By.xpath("//p[text()='Личный Кабинет']");
    //локатор кнопки [Войти в аккаунт] на главной странице
    public static final By MAIN_PAGE_LOGIN_IN_ACCOUNT_LOCATOR = By.xpath("//button[text()='Войти в аккаунт']");
    //локатор кнопки [Войти] на странице регистрации
    public static final By REGISTRATION_PAGE_LOGIN_BUTTON_LOCATOR = By.xpath("//a[text()='Войти']");
    //локатор кнопки [Войти] на странице восстановления пароля
    public static final By FORGOT_PASSWORD_PAGE_LOGIN_BUTTON_LOCATOR = By.xpath("//a[text()='Войти']");


    private WebDriver driver;
    public RedirectToLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход на страницу по URL")
    //метод для перехода на страницу по URL
    public RedirectToLoginPage openPage (String URL) {
        driver.get(URL);
        return this;
    }
    @Step("Клик по кнопке [Зарегистрироваться]")
    //метод для клика на кнопку [Зарегистрироваться]
    public RedirectToLoginPage clickLoginButton (By LOGIN_BUTTON_LOCATOR) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON_LOCATOR));
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }
    @Step("Переход на страницу \"Личного кабинета\"")
    //метод проверки перехода на страницу "Личного кабинета"
    public RedirectToLoginPage checkSuccessfulRedirect() {
        new Login(driver).checkOpeningLoginPage();
        return this;
    }
}
