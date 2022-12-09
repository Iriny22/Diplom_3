import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

        protected WebDriver driver;
        private WebDriver chromeDriver;
        private WebDriver yandexDriver;
        protected enum NameBrowser {
            YANDEX,
            CHROME
        };

        NameBrowser nameBrowser = NameBrowser.CHROME;
    //    NameBrowser nameBrowser = NameBrowser.YANDEX;

        @Before
        public void setUp(){
            this.driver = getDriver(nameBrowser);
            if ("CHROME".equals(nameBrowser)) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new ChromeDriver(options);

            } else {
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver_for_yandex");
                ChromeOptions options=new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                driver= new ChromeDriver(options);
            }
            driver.get(MainPage.MAIN_PAGE);
        }

        private WebDriver getDriver(NameBrowser nameBrowser) {
            if ("CHROME".equals(nameBrowser)) {
                return chromeDriver;
            }
            else return yandexDriver;
        }

}
