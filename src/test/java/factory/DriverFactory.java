package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import userApiEditor.Resources;

public class DriverFactory extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        initDriver();
        RestAssured.baseURI = Resources.BASE_URL;
    }

    @Override
    protected void after() {
        driver.quit();
    }

    private WebDriver driver;

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        } else {
            initChrome();
        }

    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void initYandex() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        //options.setBinary(Settings.YANDEX_BROWSER_PATH);
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
