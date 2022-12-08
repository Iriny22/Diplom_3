import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    private WebDriver driver;
    private final static By LOGIN_LINK = By.xpath(".//a[@class='Auth_link__1fOlj']");
    private final static By RECOVER_BUTTON = By.xpath(".//button[text()='Восстановить']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Задержка для загрузки страницы")
    public void loadForgotPasswordPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(RECOVER_BUTTON));
    }

    @Step("Нажали ссылку 'Войти'")
    public void clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
    }

}
