package locating.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LocatingElementsTest {
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void elementsQuiz1()
    {
        //1. Instantiate the driver
        WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element //4. check the state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        //5. take action //6. record the result
        assertTrue(element.isDisplayed());
        //7. quit the driver
        driver.quit();
    }
    @Test
    public void typesOfLocators()
    {
        //1. Instantiate the driver
        WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element
        WebElement element;
        //ID
        element = driver.findElement(By.id("user-name"));
        //Name
        //driver.findElement(By.name("name of locator"));
        //Class name
        driver.findElement(By.className("form_input"));
        //Tag name
        driver.findElement(By.tagName("input"));
        //Css selector
        //#user-name
        driver.findElement(By.cssSelector("#user-name"));
        //Xpath
        // //*[@id="user-name"]
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        driver.quit();

        //1. Instantiate the driver
        driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        //Partial link text
        driver.findElement(By.partialLinkText("link text!"));
        //7. quit the driver
        driver.quit();
    }
}
