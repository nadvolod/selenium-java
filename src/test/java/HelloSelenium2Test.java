import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class HelloSelenium2Test {
    @Test
    public void simpleTest()
    {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.saucedemo.com/");
        driver.quit();
    }
}
