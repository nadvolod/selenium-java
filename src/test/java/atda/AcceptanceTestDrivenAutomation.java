package atda;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AcceptanceTestDrivenAutomation {
    @Test
    public void shouldOpen()
    {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    private WebDriver getDriver() {
        //Telling the system where to find chromedriver. On Windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        return new ChromeDriver();
    }
}
