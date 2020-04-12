package locating.elements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LocatingElementsTest {
    WebDriver driver;

    @Before
    public void setUp() {
        //Telling the system where to find chromedriver. On Windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Instantiate the driver
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        //7. quit the driver
        driver.quit();
    }

    @Test
    public void elementsQuiz1()
    {
        //2. navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element //4. check the state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        //5. take action //6. record the result
        assertTrue(element.isDisplayed());

    }
    @Test
    public void typesOfLocators()
    {
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

        //2. navigate to the URL
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        //Partial link text
        driver.findElement(By.partialLinkText("link text!"));
    }

    @Test
    public void locatorExam()
    {
        //2. navigate to the URL
        driver.get("https://www.saucedemo.com/");

        //css ID

        //Input element with class form_input

        //Direct child

        //Using attributes. Input with id='user-name'

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".btn_action")).click();

        driver.findElement(By.xpath("//*[@class='btn_primary btn_inventory']")).click();


        driver.findElement(By.id("user-name"));
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

        //2. navigate to the URL
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        //Partial link text
        driver.findElement(By.partialLinkText("link text!"));
    }
}
