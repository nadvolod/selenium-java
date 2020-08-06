package advanced.tips;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTest {
    private WebDriver driver;

    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkPageLoad() {
        driver = getDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private WebDriver getDriver() {
        //Using WebDriverManager package, we are able to not worry about
        return new ChromeDriver();
    }
}
