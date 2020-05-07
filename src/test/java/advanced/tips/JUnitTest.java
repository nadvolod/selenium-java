package advanced.tips;

import atda.LoginPage;
import atda.ProductsPage;
import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class JUnitTest {
    WebDriver driver;
    @Before
    public void setup()
    {
        driver = getDriver();
    }
    @After
    public void cleanup()
    {
        driver.quit();
    }

    @Test
    public void shouldLogin()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
    }
    @Test
    public void shouldLogin2()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
    }
    @Test
    public void shouldLogin3()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
    }
    @Test
    public void shouldLogin4()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
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
