package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login {
    private WebDriver driver;
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private final By PERSONAL_ACCOUNT_LOCATOR = By.xpath("//p[text()='Личный Кабинет']");
    private final String NAME_LOCATOR_FORM = "//input[@value='%s']";


    //локатор надписи "Вход"
    public static By ENTER_LABEL = By.xpath(".//div[@class='Auth_login__3hAey']/h2[text()='Вход']");
    //локатор поля "Email"
    private By EMAIL_INPUT_LOCATOR = By.xpath("//label[text() = 'Email']/parent::div/input");
    //локатор поля "Пароль"
    private By PASSWORD_INPUT_LOCATOR = By.xpath("//label[text() = 'Пароль']/parent::div/input");
    private By ENTER_BUTTON_LOCATOR = By.xpath(".//button[text()='Войти']");

    @Step("Переход на страницу Логина")
    //метод для перехода на страницу "Логина"
    public Login openLoginPage() {
        driver.get(LOGIN_URL);
        return this;
    }
    @Step("Ввод email")
    //метод для ввода Email
    public Login enterEmail(String email) {
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);
        return this;
    }
    @Step("Ввод пароля")
    //метод для ввода Пароля
    public Login enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        return this;
    }
    @Step("Клик по кнопке [Войти]")
    //метод для клика по кнопке [Войти]
    public Login clickEnterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(ENTER_BUTTON_LOCATOR));
        driver.findElement(ENTER_BUTTON_LOCATOR).click();
        return this;
    }


    @Step("Проверка перехода на страницу ЛК")
    //метод проверки перехода на страницу "Личного кабинета" (без входа в систему)
    public Login checkOpeningLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.visibilityOfElementLocated(Login.ENTER_LABEL));
        return this;
    }

    @Step("Проверка перехода на страницу ЛК")
    //метод проверки редиректа на страницу "Личного кабинета" (после входа в систему)
    public Login checkUserLogin(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(PERSONAL_ACCOUNT_LOCATOR));
        driver.findElement(PERSONAL_ACCOUNT_LOCATOR).click();

        By NAME_LOCATOR = By.xpath(String.format(NAME_LOCATOR_FORM, name));
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.visibilityOfElementLocated(NAME_LOCATOR));
        return this;
    }
    @Step("Вход пользователя в ЛК")
    //метод логина пользователя
    public Login userLogin(String email, String password) {
        openLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickEnterButton();
        return this;
    }
}
