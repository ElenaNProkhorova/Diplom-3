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

    public static final By BUNS_ACTIVE_TAB = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    public static final By SAUSE_ACTIVE_TAB = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]");
    public static final By TOPPING_ACTIVE_TAB = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");


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

    @Step("Проверка текущей вкладки конструктора \"Собери бургер\"")
    public BurgerIngredientMenu checkTabRedirect (String ingredientType) {
        By activeTab;
        if (ingredientType == "Булки") {
            activeTab = BUNS_ACTIVE_TAB;
        } else if (ingredientType == "Соусы") {
            activeTab = SAUSE_ACTIVE_TAB;
        } else if (ingredientType == "Начинки") {
            activeTab = TOPPING_ACTIVE_TAB;
        } else {
            throw new RuntimeException("Такого ингридиента не существует - " + ingredientType);
        }
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.visibilityOfElementLocated(activeTab));
        assert driver.findElement(activeTab).isDisplayed();
        return this;
    }

}