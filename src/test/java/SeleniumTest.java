import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class SeleniumTest {

    // Navigate to this URL using another browser https://the-internet.herokuapp.com/
    // Navigate to this URL https://example.cypress.io/
    // Navigate to https://react-shopping-cart-67954.firebaseapp.com/
    // Using WebDriverManager

    //This method will run once before all of the tests in our class
//    @BeforeClass
//    public static void setupClass() {
//        WebDriverManager.edgedriver().setup();
//    }
    @Test
    public void safariTest() {
        WebDriver driver = new SafariDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.quit();
    }
    @Test
    public void cypressTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://example.cypress.io/");
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void shoppingCartTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        Thread.sleep(3000);
        driver.quit();
    }
}
