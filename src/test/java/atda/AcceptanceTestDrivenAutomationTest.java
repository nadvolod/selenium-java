package atda;

import org.junit.Test;

public class AcceptanceTestDrivenAutomationTest {
    @Test
    public void shouldOpen()
    {
    }

    private WebDriver getDriver() {
        //Telling the system where to find chromedriver. On Windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        return new ChromeDriver();
    }
}
