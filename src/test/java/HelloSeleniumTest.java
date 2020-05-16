import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {
    @Test
    public void firstTest()
    {
        //Telling the system where to find chromedriver on Mac.
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //Here's how to do it on Windows
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.quit();
    }
}
