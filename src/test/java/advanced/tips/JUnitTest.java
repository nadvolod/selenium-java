package advanced.tips;

import atda.LoginPage;
import atda.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitTest {
    WebDriver driver;
    static List<Long> threads = new ArrayList<Long>();
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterAll
    public static void afterClass() throws Exception {
        System.out.println("ALL THREADS ||||||||||||||||||||||||||||||||");
        for(Long thread : threads) {
            System.out.println(thread);
        }
        System.out.println("||||||||||||||||||||||||||||||||");
    }

    @BeforeEach
    public void setup()
    {
        driver = getDriver();
    }
    @AfterEach
    public void cleanup()
    {
        driver.quit();
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
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

    private WebDriver getDriver() {
        return new ChromeDriver();
    }
}
