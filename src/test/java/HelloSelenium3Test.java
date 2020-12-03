import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class HelloSelenium3Test {
    @Test
    public void smarterTest()
    {
        //Use WebDriverManager Maven package to download the correct version of
        //a driver to automate Chrome browser
        WebDriverManager.chromedriver().setup();
        //Set variable driver to an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        //Open the URL
        driver.get("https://www.saucedemo.com/");
        //Assert that the title of the page = Swag Labs
        assertEquals("Swag Labs", driver.getTitle());
        //Quit the browser
        driver.quit();
    }
}
