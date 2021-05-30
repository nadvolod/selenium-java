package testNGDataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLoginTests {
    WebDriver driver;

    private WebDriver getDriver() {
        return new ChromeDriver();
    }

    // Pay extra attention to the annotations, which are a bit different than the JUnit ones
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // The test is the same as before
    // We pass 2 string parameters for username and password
    // which are returned by the data provider method
    @Test (dataProvider = "DataProvider")
    public void loginTest(String userName, String password) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    // This is the data provider method, which returns user objects
    // with 2 string values: username and password
    @org.testng.annotations.DataProvider(name = "DataProvider")
    public Object[][] provideUserData() {
        return new Object[][] {
                new Object[] {"standard_user", "secret_sauce"},
                new Object[] {"performance_glitch_user", "secret_sauce"},
                new Object[] {"problem_user", "secret_sauce"}
        };
    }
}

