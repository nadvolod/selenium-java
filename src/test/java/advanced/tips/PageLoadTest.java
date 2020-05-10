package advanced.tips;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTest {
    private WebDriver driver;

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
        if(SystemUtils.IS_OS_WINDOWS)
        {
            //The path of chromedriver for windows
            System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        }
        //Telling the system where to find chromedriver on mac
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");


        return new ChromeDriver();
    }
}
