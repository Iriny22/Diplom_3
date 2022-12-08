import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private final static By REGISTRATION_LINK = By.xpath(".//a[text()='Зарегистрироваться']");
    private final static By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final static By EMAIL_INPUT = By.xpath(".//input[@type ='text']");
    private final static By PASSWORD_INPUT = By.xpath(".//input[@type ='password']");
    private final static By FORGOT_PASSWORD_LINK = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Логин пользователя")
    public void loginUser(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Нажали ссылку 'Регистрация'")
    public void clickRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(REGISTRATION_LINK));
        driver.findElement(REGISTRATION_LINK).click();
    }

    @Step("Проверка успешности регистрации")
    public Boolean isLoginPageOpened() {
        if (driver.findElement(LOGIN_BUTTON).isDisplayed()) {
            return true;
        }
        return false;
    }

    @Step("Задержка для загрузки страницы")
    public void loadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Нажали ссылку 'Забыли пароль'")
    public void clickForgotPasswordLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(FORGOT_PASSWORD_LINK));
        driver.findElement(FORGOT_PASSWORD_LINK).click();
    }

}
