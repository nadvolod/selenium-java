package atda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AcceptanceTestDrivenAutomationTest {
    private WebDriver driver;

    @Before
    public void setup()
    {
        driver = getDriver();
    }
    @After
    public void teardown()
    {
        driver.quit();
    }
    @Test
    public void shouldOpen() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        assertTrue("Login page should load successfully", loginPage.isLoaded());
    }

    @Test
    public void shouldLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue("Login page should load successfully", loginPage.isLoaded());

        loginPage.login("standard_user", "secret_sauce");
        assertTrue("Products page should open when we login", new ProductsPage(driver).isLoaded());
    }

    private WebDriver getDriver() {
        //Telling the system where to find chromedriver. On Windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        return new ChromeDriver();
    }
}
