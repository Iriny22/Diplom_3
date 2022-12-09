import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private Boolean actualResult;
    private String email = "test888@yandex.com";
    private String password = "losos123";

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
        loginPage.loginUser(email,password);
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
        loginPage.loginUser(email,password);
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
        loginPage.loginUser(email,password);
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
        loginPage.loginUser(email,password);
        actualResult = mainPage.waitOrderButtonClickable();
        assertTrue(actualResult);
    }

}
