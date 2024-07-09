package tests;

import factory.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pageObject.BurgerIngredientMenu;

@DisplayName("Раздел «Конструктор»")
public class BurgerIngredientMenuTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка переходов по разделам «Соберите бургер»: Раздел Соусы" )
    public void tabSwitchSauce() {

        BurgerIngredientMenu burgerIngredientMenu = new BurgerIngredientMenu(driverFactory.getDriver());
        burgerIngredientMenu.openMainPage();
        burgerIngredientMenu.clickTabButton(BurgerIngredientMenu.SAUCE_TAB_LOCATOR);
        burgerIngredientMenu.checkTabRedirect(BurgerIngredientMenu.SAUCE_TITLE_LOCATOR);

    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка переходов по разделам «Соберите бургер»: Раздел Булки" )
    public void tabSwitchBuns() {

        BurgerIngredientMenu burgerIngredientMenu = new BurgerIngredientMenu(driverFactory.getDriver());
        burgerIngredientMenu.openMainPage();
        burgerIngredientMenu.clickTabButton(BurgerIngredientMenu.SAUCE_TAB_LOCATOR);
        burgerIngredientMenu.clickTabButton(BurgerIngredientMenu.BUNS_TAB_LOCATOR);
        burgerIngredientMenu.checkTabRedirect(BurgerIngredientMenu.BUNS_TITLE_LOCATOR);
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка переходов по разделам «Соберите бургер»: Раздел Начинки" )
    public void tabSwitchTopping() {

        BurgerIngredientMenu burgerIngredientMenu = new BurgerIngredientMenu(driverFactory.getDriver());
        burgerIngredientMenu.openMainPage();
        burgerIngredientMenu.clickTabButton(BurgerIngredientMenu.TOPPING_TAB_LOCATOR);
        burgerIngredientMenu.checkTabRedirect(BurgerIngredientMenu.TOPPING_TITLE_LOCATOR);

    }
}
