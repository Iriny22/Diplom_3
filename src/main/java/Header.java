import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

    private WebDriver driver;
    private final static By LOGO_LINK = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");
    private final static By ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final static By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажали на логотип")
    public void clickLogo() {
        driver.findElement(LOGO_LINK).click();
    }

    @Step("Нажали кнопку 'Личный кабинет'")
    public void clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    @Step("Нажали на пункт 'Конструктор'")
    public void clickConstructor() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(CONSTRUCTOR_BUTTON));
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
}
