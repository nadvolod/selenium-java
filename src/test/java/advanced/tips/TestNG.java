package advanced.tips;

import atda.LoginPage;
import atda.ProductsPage;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertTrue;

public class TestNG {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    /**
     * @return the {@link WebDriver} for the current thread
     */
    protected WebDriver getWebDriverInstance() {
        return driver.get();
    }
    @BeforeMethod
    public void setup()
    {
        driver.set(getDriver());
    }
    @AfterMethod
    public void cleanup()
    {
        getWebDriverInstance().quit();
    }

    @Test
    public void shouldLogin()
    {
        LoginPage loginPage = new LoginPage(getWebDriverInstance());
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(getWebDriverInstance()).isLoaded());
    }
    @Test
    public void shouldLogin2()
    {
        LoginPage loginPage = new LoginPage(getWebDriverInstance());
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(getWebDriverInstance()).isLoaded());
    }
    @Test
    public void shouldLogin3()
    {
        LoginPage loginPage = new LoginPage(getWebDriverInstance());
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(getWebDriverInstance()).isLoaded());
    }
    @Test
    public void shouldLogin4()
    {
        LoginPage loginPage = new LoginPage(getWebDriverInstance());
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(getWebDriverInstance()).isLoaded());
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
