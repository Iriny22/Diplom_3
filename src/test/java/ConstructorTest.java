import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {

    private WebDriver driver;
    private Boolean actualResult;

    //настройка драйвера
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/irida/Webdriver/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(MainPage.MAIN_PAGE);
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

    @Test
    @DisplayName("Переход на таб Булки") // имя теста
    @Description("Basic test for constructor") // описание теста
    public void moveToBunTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        assertEquals("Булки",mainPage.selectedTab());
    }

    @Test
    @DisplayName("Переход на таб Соусы") // имя теста
    @Description("Basic test for constructor") // описание теста
    public void moveToSauceTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        assertEquals("Соусы",mainPage.selectedTab());
    }

    @Test
    @DisplayName("Переход на таб Начинки") // имя теста
    @Description("Basic test for constructor") // описание теста
    public void moveToFillingTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingTab();
        assertEquals("Начинки",mainPage.selectedTab());
    }

}
