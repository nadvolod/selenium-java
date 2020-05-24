import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CodeOrganization {
    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void countElements() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        int countOfItems = driver.
                findElements(By.className("inventory_item")).
                size();
        if (countOfItems == 7) {
            assertTrue(true);
        } else {
            fail();
        }
        driver.quit();
    }
}
