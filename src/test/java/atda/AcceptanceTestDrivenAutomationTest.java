package atda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AcceptanceTestDrivenAutomationTest {
    public WebDriver driver;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Chrome", "MacOS 10.12", "latest" },
                { "Safari", "MacOS 10.15", "latest" }
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public String browser;

    @Parameterized.Parameter(1)
    public String platform;

    @Parameterized.Parameter(2)
    public String browserVersion;

    @Before
    public void setup() throws MalformedURLException {
        createDriver();
    }
    @After
    public void teardown()
    {
        if(driver != null)
        {
            driver.quit();
        }
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

    private void createDriver() throws MalformedURLException {
        String sauceUsername = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", sauceUsername);
        sauceOpts.setCapability("accessKey", sauceAccessKey);
        sauceOpts.setCapability("build", "best-practices");
        sauceOpts.setCapability("tags", "['best-practices', 'best-practices']");

        MutableCapabilities browserOptions = new MutableCapabilities();
        browserOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
        browserOptions.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
        browserOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
        browserOptions.setCapability("sauce:options", sauceOpts);

        String sauceUrl = "https://ondemand.saucelabs.com/wd/hub";
        URL url = new URL(sauceUrl);
        driver = new RemoteWebDriver(url, browserOptions);
    }
}
