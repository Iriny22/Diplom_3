import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AccountTest extends BaseTest{

        private Boolean actualResult;
        private String email = "test888@yandex.com";
        private String password = "losos123";

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
        loginPage.loginUser(email,password);
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
