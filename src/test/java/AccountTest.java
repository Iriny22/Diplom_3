import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class AccountTest {

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
    @DisplayName("Переход с помощью кнопки Личный кабинет") // имя теста
    @Description("Basic test for user move to account") // описание теста
    public void moveToAccount() {
        Header header = new Header(driver);
        header.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        actualResult = loginPage.isLoginPageOpened();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор") // имя теста
    @Description("Basic test for user move from account to constructor") // описание теста
    public void moveToConstructorFromLoginPage() {
        MainPage mainPage = new MainPage(driver);
        Header header = new Header(driver);
        header.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        header.clickConstructor();
        mainPage.loadMainPage();
        actualResult = mainPage.showHeadline();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Переход из личного кабинета нажатием на логотип бургера") // имя теста
    @Description("Basic test for user move from account to logo") // описание теста
    public void moveToLogoFromLoginPage() {
        MainPage mainPage = new MainPage(driver);
        Header header = new Header(driver);
        header.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        header.clickLogo();
        mainPage.loadMainPage();
        actualResult = mainPage.showHeadline();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Выход из аккаунта") // имя теста
    @Description("Basic test for exit from account") // описание теста
    public void exitFromAccount() {
        MainPage mainPage = new MainPage(driver);
        Header header = new Header(driver);
        header.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        loginPage.loginUser("test888@yandex.com","losos123");
        mainPage.waitOrderButtonClickable();
        header.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.loadAccountPage();
        accountPage.clickExitButton();
        loginPage.loadLoginPage();
        actualResult = loginPage.isLoginPageOpened();
        assertTrue(actualResult);
    }
}
