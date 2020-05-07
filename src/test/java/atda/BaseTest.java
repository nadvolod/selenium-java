package atda;

import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

public class BaseTest {
    public WebDriver driver;
    @Parameterized.Parameters
    public static Collection<Object[]> crossBrowserData() {
        return Arrays.asList(new Object[][] {
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
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
    private void createDriver() throws MalformedURLException {
        String sauceUsername = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", sauceUsername);
        sauceOpts.setCapability("accessKey", sauceAccessKey);
        sauceOpts.setCapability("build", "ATDA");

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
