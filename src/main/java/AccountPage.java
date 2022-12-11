import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;
    private final static By EXIT_BUTTON = By.xpath(".//li/button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Задержка для загрузки страницы")
    public void loadAccountPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(EXIT_BUTTON));
    }

    @Step("Нажали кнопку 'Выход'")
    public void clickExitButton() {
        driver.findElement(EXIT_BUTTON).click();
    }
}
