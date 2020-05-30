import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFeatureTest {
    private ChromeDriver driver;

    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldLogin() {
        driver.navigate().to("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @Test
    public void productsPageTest() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart();
    }
}
