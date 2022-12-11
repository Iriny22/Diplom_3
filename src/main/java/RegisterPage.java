import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private final static By NAME_INPUT = By.xpath(".//fieldset[1]/div/div/input");
    private final static By EMAIL_INPUT = By.xpath(".//fieldset[2]/div/div/input");
    private final static By PASSWORD_INPUT = By.xpath(".//input[@name='Пароль']");
    private final static By REGISTRATION_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private final static By ERROR_STYLE = By.xpath(".//div[@class = 'input pr-6 pl-6 input_type_password input_size_default input_status_error']");
    private final static By LOGIN_LINK = By.className("Auth_link__1fOlj");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Регистрация пользователя")
    public void addNewUser(String name, String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
        driver.findElement(NAME_INPUT).sendKeys(name);
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    @Step("Проверка отображения ошибки")
    public Boolean IsRegistrationSuccessful() {
        if (driver.findElement(ERROR_STYLE).isDisplayed()) {
            return false;
        }
        return true;
    }

    @Step("Нажатие ссылки Войти")
    public void clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
    }
}
