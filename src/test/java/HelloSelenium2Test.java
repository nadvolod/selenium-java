import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class HelloSelenium2Test {
    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void smarterTest()
    {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.saucedemo.com/");
        driver.quit();
    }
}
