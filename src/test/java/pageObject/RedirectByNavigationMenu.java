package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RedirectByNavigationMenu {
    //локатор кнопки "Конструктор"
    public static final By CONSTRUCTOR_BUTTON_LOCATOR = By.xpath(".//p[text()='Конструктор']");
    //локатор "Логотипа"
    public static final By LOGO_BUTTON_LOCATOR = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    //локатор "Собери бургер"
    public static final By BURGER_INGREDIENTS_MENU_LOCATOR = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']");

    private WebDriver driver;
    public RedirectByNavigationMenu(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Клик по кнопке [Конструктор]")
    //метод для клика по [Конструктору]
    public RedirectByNavigationMenu clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(CONSTRUCTOR_BUTTON_LOCATOR));
        driver.findElement(CONSTRUCTOR_BUTTON_LOCATOR).click();
        return this;
    }
    @Step("Клик по [Логотипу]")
    //метод для клика по [Логотипу]
    public RedirectByNavigationMenu clickLogoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(LOGO_BUTTON_LOCATOR));
        driver.findElement(LOGO_BUTTON_LOCATOR).click();
        return this;
    }
    @Step("Переход на \"Главную страницу\"")
    //метод проверки перехода на "Главную страницу"
    public RedirectByNavigationMenu checkSuccessfulRedirect() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.visibilityOfElementLocated(BURGER_INGREDIENTS_MENU_LOCATOR));
        return this;
    }
}
