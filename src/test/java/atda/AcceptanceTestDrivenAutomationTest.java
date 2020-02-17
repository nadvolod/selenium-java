package atda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AcceptanceTestDrivenAutomationTest {
    WebDriver driver;
    @BeforeEach
    public void setup()
    {
        driver = getDriver();
    }
    @AfterEach
    public void cleanup()
    {
        driver.quit();
    }
    @Test
    public void shouldOpen()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    @Test
    public void shouldLogin()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
    }

    private WebDriver getDriver() {
        //Telling the system where to find chromedriver. On Windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        return new ChromeDriver();
    }
}
