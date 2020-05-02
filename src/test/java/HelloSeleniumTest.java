import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HelloSeleniumTest {
    @Test
    public void firstTest()
    {
        /*
        * Don't forget that chromedriver and Chrome browser must always
        * be in sync. It's very likely that one day you will open your
        * code and things just aren't working. That's because
        * Chrome automatically updated and your chromedriver
        * doesn't support the new Chrome browser.
        * */

        //Telling the system where to find chromedriver on mac
        //System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");

        //The path of chromedriver for windows
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");

        //Create a new chrome driver for us to use to automate Chrome browser
        WebDriver driver = new ChromeDriver();
        //Go to a URL
        driver.get("https://www.saucedemo.com/");
        //Kill the browser
        driver.quit();
    }
}
