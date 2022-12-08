import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class LoginTest {
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
    @DisplayName("Логин с помощью кнопки Войти в аккаунт ") // имя теста
    @Description("Basic test for user login") // описание теста
    public void LoginByButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("test888@yandex.com","losos123");
        actualResult = mainPage.waitOrderButtonClickable();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Логин с помощью кнопки Личный кабинет") // имя теста
    @Description("Basic test for user login") // описание теста
    public void LoginByAccountButton() {
        MainPage mainPage = new MainPage(driver);
        Header header = new Header(driver);
        header.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("test888@yandex.com","losos123");
        actualResult = mainPage.waitOrderButtonClickable();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Логин с помощью ссылки на странице регистрации") // имя теста
    @Description("Basic test for user login") // описание теста
    public void LoginByLinkFromRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        Header header = new Header(driver);
        header.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistration();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLink();
        loginPage.loadLoginPage();
        loginPage.loginUser("test888@yandex.com","losos123");
        actualResult = mainPage.waitOrderButtonClickable();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Логин с помощью ссылки забыли пароль на странице логина") // имя теста
    @Description("Basic test for user login") // описание теста
    public void LoginByLinkFromForgotPasswordPage() {
        MainPage mainPage = new MainPage(driver);
        Header header = new Header(driver);
        header.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.loadForgotPasswordPage();
        forgotPasswordPage.clickLoginLink();
        loginPage.loadLoginPage();
        loginPage.loginUser("test888@yandex.com","losos123");
        actualResult = mainPage.waitOrderButtonClickable();
        assertTrue(actualResult);
    }

}
