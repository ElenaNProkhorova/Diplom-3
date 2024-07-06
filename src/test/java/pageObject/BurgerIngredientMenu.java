package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BurgerIngredientMenu {
    private WebDriver driver;
    public BurgerIngredientMenu(WebDriver driver) {
        this.driver = driver;
    }

    private final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    public static final By BUNS_TAB_LOCATOR = By.xpath("//span[text()='Булки']/parent::div");
    public static final By SAUCE_TAB_LOCATOR = By.xpath("//span[text()='Соусы']/parent::div");
    public static final By TOPPING_TAB_LOCATOR = By.xpath("//span[text()='Начинки']/parent::div");

    public static final By BUNS_TITLE_LOCATOR = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']");
    public static final By SAUCE_TITLE_LOCATOR = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']");
    public static final By TOPPING_TITLE_LOCATOR = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']");


    @Step("Переход на \"Главную страницу\"")
    //метод для перехода на "Главную страницу"
    public BurgerIngredientMenu openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    @Step("Клик по вкладке таб-бара \"Собери бургер\"")
    //метод для клика по вкладке таб-бара
    public BurgerIngredientMenu clickTabButton(By tab) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(tab));
        driver.findElement(tab).click();
        return this;
    }
    @Step("Отображение соответствующего раздела ингредиентов конструктора \"Собери бургер\"")
    //метод проверки перехода на соответствующу группу ингредиентов "Собери бургер"
    public BurgerIngredientMenu checkTabRedirect(By title) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.visibilityOfElementLocated(title));
        return this;
    }
}
