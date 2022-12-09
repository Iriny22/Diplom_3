import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    private Boolean actualResult;
    private String name = "testUser1";
    private String email = "test1111@yandex.com";
    private String password = "losos123";
    private String passwordWrong = "loso";


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
        registerPage.addNewUser(name,email,password);
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
        registerPage.addNewUser(name,email,passwordWrong);
        actualResult = registerPage.IsRegistrationSuccessful();
        assertFalse(actualResult);
    }

}
