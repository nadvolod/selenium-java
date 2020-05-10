package best.practices;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class Duplication {
    WebDriver driver;
    @Before
    public void setup()
    {
        driver = getDriver();
    }
    @After
    public void cleanup()
    {
        driver.quit();
    }
    @Test
    public void test1() {
        driver.get("http://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("btn_action")).submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("inventory_filter_container"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void test2() {
        driver.get("http://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("btn_action")).submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isDisplayed = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("inventory_filter_container"))).isDisplayed();
        assertTrue(isDisplayed);
    }
    @Test
    public void test3() {
        open();
        typeText(By.id("user-name"), "standard_user");
        typeText(By.id("password"), "secret_sauce");
        clickButton(By.className("btn_action"));
        boolean isDisplayed = waitUntilDisplayed(By.id("inventory_filter_container"));

        assertTrue(isDisplayed);
    }
    @Test
    public void test4() {
        open();
        typeText(By.id("user-name"), "problem_user");
        typeText(By.id("password"), "secret_sauce");
        clickButton(By.className("btn_action"));
        boolean isDisplayed = waitUntilDisplayed(By.id("inventory_filter_container"));

        assertTrue(isDisplayed);
    }
    private boolean waitUntilDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }

    private void clickButton(By locator) {
        driver.findElement(locator).submit();
    }

    private void typeText(By locator, String string) {
        driver.findElement(locator).sendKeys(string);
    }

    private void open() {
        driver.get("http://www.saucedemo.com");
    }

    private WebDriver getDriver() {
        //Telling the system where to find chromedriver. On Windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        return new ChromeDriver();
    }
}
