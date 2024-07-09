package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserRegistration {
    private WebDriver driver;
    public UserRegistration(WebDriver driver) {
        this.driver = driver;
    }

    //URL для перехода на страницу регистрации
    private final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";

    //локаторы полей регистрации, кнопки [Зарегистрироваться], кнопки [Войти] текста "Некорректный пароль"
    private By NAME_INPUT_LOCATOR = By.xpath("//label[text() = 'Имя']/parent::div/input");
    private By EMAIL_INPUT_LOCATOR = By.xpath("//label[text() = 'Email']/parent::div/input");
    private By PASSWORD_INPUT_LOCATOR = By.xpath("//label[text() = 'Пароль']/parent::div/input");
    private By REGISTRATION_BUTTON_LOCATOR = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By INVALID_PASSWORD_LABEL_LOCATOR = By.xpath(".//p[text()='Некорректный пароль']");
    private By ENTER_BUTTON_LOCATOR = By.xpath(".//button[text()='Войти']");

    @Step("Переход на страницу Регистрации")
    //метод для перехода на страницу "Регистрации"
    public UserRegistration openRegistrationPage() {
        driver.get(REGISTRATION_URL);
        return this;
    }

    @Step("Ввод Имени")
    //метод для ввода Имени
    public UserRegistration setNameField(String name) {
        driver.findElement(NAME_INPUT_LOCATOR).sendKeys(name);
        return this;
    }
    @Step("Ввод Email")
    //метод для ввода Email
    public UserRegistration setEmailField(String email) {
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);
        return this;
    }
    @Step("Ввод Пароля")
    //метод для ввода Пароля
    public UserRegistration setPasswordField(String password) {
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        return this;
    }
    @Step("Клик по кнопке [Зарегистрироваться]")
    //метод для клика на кнопку [Зарегистрироваться]
    public UserRegistration clickRegisterButton () {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(REGISTRATION_BUTTON_LOCATOR));
        driver.findElement(REGISTRATION_BUTTON_LOCATOR).click();
        return this;
    }

    @Step("Клик по кнопке [Войти]")
    //метод для клика на кнопку [Войти]
    public UserRegistration clickEnterButton () {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(ENTER_BUTTON_LOCATOR));
        driver.findElement(ENTER_BUTTON_LOCATOR).click();
        return this;
    }
    @Step("Проверка безуспешной регистрации")
    //метод проверки безуспешной регистрации
    public UserRegistration checkUnsuccessfulRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.visibilityOfElementLocated(INVALID_PASSWORD_LABEL_LOCATOR));
        return this;
    }
    @Step("Регистрации пользователя")
    //метод регистрации пользователя
    public UserRegistration userRegistration(String name, String email, String password) {
        openRegistrationPage();
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickRegisterButton();
        return this;
    }
}