package advanced.tips;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTest {
    private WebDriver driver;

    @Test
    public void unecessaryPageLoadCheck() {
        driver = getDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        //Our check to see that the page is loaded
        Assert.assertTrue(driver.findElement(By.id("BAZINGA")).isDisplayed());
    }

    @Test
    public void smarterTest() {
        driver = getDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        /**
         * Instead of checking for a page load, we can just continue with
         * our normal actions, the error will be exactly the same
         * */
        driver.findElement(By.id("BAZINGA")).sendKeys("standard_user");
        //Continue the rest of the UI actions to login...
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
