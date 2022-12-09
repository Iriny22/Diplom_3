import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {

    private Boolean actualResult;

    //настройка драйвера

    @After
    public void cleanUp(){
        driver.quit();
    }

    @Test
    @DisplayName("Переход на таб Булки") // имя теста
    @Description("Basic test for constructor") // описание теста
    public void moveToBunTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        assertEquals("Булки",mainPage.selectedTab());
    }

    @Test
    @DisplayName("Переход на таб Соусы") // имя теста
    @Description("Basic test for constructor") // описание теста
    public void moveToSauceTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        assertEquals("Соусы",mainPage.selectedTab());
    }

    @Test
    @DisplayName("Переход на таб Начинки") // имя теста
    @Description("Basic test for constructor") // описание теста
    public void moveToFillingTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingTab();
        assertEquals("Начинки",mainPage.selectedTab());
    }

}
