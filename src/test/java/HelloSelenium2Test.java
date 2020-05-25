import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloSelenium2Test {
    private WebDriver driver;

    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public static void afterClass() {
        //We can perform any operation after every single test has been executed
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void smarterTest()
    {
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void smarterTest2()
    {
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void smarterTest3()
    {
        driver.get("https://www.saucedemo.com/");
    }
}
