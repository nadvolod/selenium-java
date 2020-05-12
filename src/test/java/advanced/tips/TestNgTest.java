package advanced.tips;

import atda.LoginPage;
import atda.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class TestNgTest {
    //We need to create a ThreadLocal object to be accessed by a specific thread
    private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    static List<Long> threads = new ArrayList<Long>();

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("ALL THREADS ||||||||||||||||||||||||||||||||");
        for(Long thread : threads) {
            System.out.println(thread);
        }
        System.out.println("||||||||||||||||||||||||||||||||");
    }

    @BeforeMethod
    public void setup()
    {
        //we set the Thread Local object to an instance of ChromeDriver
        //now this threadLocalDriver will use this exact thread on this ChromeDriver
        threadLocalDriver.set(new ChromeDriver());
    }
    @AfterMethod
    public void cleanup()
    {
        threadLocalDriver.get().quit();
    }

    @Test
    public void shouldLogin()
    {
        runTest();
    }

    public void runTest() {
        var threadId = Thread.currentThread().getId();
        threads.add(threadId);
        System.out.println("||||||||||||||||||||||||||||||||");
        System.out.println("Thread id:" + Thread.currentThread().getId());
        System.out.println("||||||||||||||||||||||||||||||||");

        //Any access of our driver object must now occur through a .get()
        //to access a specific thread
        LoginPage loginPage = new LoginPage(threadLocalDriver.get());
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(threadLocalDriver.get()).isLoaded());
    }

    @Test
    public void shouldLogin2()
    {
        runTest();
    }
    @Test
    public void shouldLogin3()
    {
        runTest();
    }
    @Test
    public void shouldLogin4()
    {
        runTest();
    }
    @Test
    public void shouldLogin5()
    {
        runTest();
    }
    @Test
    public void shouldLogin6()
    {
        runTest();
    }
    @Test
    public void shouldLogin7()
    {
        runTest();
    }
    @Test
    public void shouldLogin8()
    {
        runTest();
    }
    @Test
    public void shouldLogin9()
    {
        runTest();
    }
    @Test
    public void shouldLogin10()
    {
        runTest();
    }
}
