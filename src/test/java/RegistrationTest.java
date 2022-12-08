import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
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
    @DisplayName("Регистрация пользователя") // имя теста
    @Description("Basic test for user registration") // описание теста
    public void Registration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistration();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.addNewUser("Testuser4","test888@yandex.com","losos123");
        loginPage.loadLoginPage();
        actualResult = loginPage.isLoginPageOpened();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Регистрация пользователя c некорректным паролем") // имя теста
    @Description("Basic test for user registration with wrong password") // описание теста
    public void RegistrationWithWrongPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistration();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.addNewUser("Testuser2","test555@yandex.com","los");
        actualResult = registerPage.IsRegistrationSuccessful();
        assertFalse(actualResult);
    }

}
