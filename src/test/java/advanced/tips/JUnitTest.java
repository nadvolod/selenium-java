package advanced.tips;

import atda.LoginPage;
import atda.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitTest {
    WebDriver driver;
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
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
        System.out.println(Thread.currentThread().getName());
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
