import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    public static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;
    private final static By LOGIN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");

    private final static By ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");

    private final static By HEADLINE = By.xpath(".//h1[text()='Соберите бургер']");

    private final static By BUN_TAB = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[1]");
    private final static By SAUCE_TAB = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[2]");
    private final static By FILLING_TAB = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[3]");

    private final static By SELECTED_TAB = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажали кнопку 'Войти в аккаунт'")
    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }


    @Step("Кнопка оформить заказ доступна")
    public Boolean waitOrderButtonClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON));
        if (driver.findElement(ORDER_BUTTON).isDisplayed())  {
            return true;
        }
        return false;
    }

    @Step("Задержка для загрузки страницы")
    public void loadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(HEADLINE));
    }

    @Step("Заголовок Соберите бургер отображается")
    public Boolean showHeadline() {
        if (driver.findElement(HEADLINE).isDisplayed())  {
            return true;
        }
        return false;
    }

    @Step("Нажали на вкладку Булки")
    public void clickBunTab() {
        driver.findElement(BUN_TAB).click();
    }

    @Step("Нажали на вкладку Соусы")
    public void clickSauceTab() {
        driver.findElement(SAUCE_TAB).click();
    }

    @Step("Нажали на вкладку Начинки")
    public void clickFillingTab() {
        driver.findElement(FILLING_TAB).click();
    }

    @Step("Проверка какой таб выбран")
    public String selectedTab() {
        return driver.findElement(SELECTED_TAB).getText();
    }
}

