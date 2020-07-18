package webdriver.methods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.*;

public class WebDriverMethodsExam {
    WebDriver driver;
    WebElement element;
    private JavascriptExecutor javascriptExecutor;

    @Before
    public void setUp() {
        //1. SafariDriver on a Mac doesn't require us to download anything,
        // it just works because it's automatically part of Safari now :)
        driver = new SafariDriver();
        driver.manage().window().maximize();
        javascriptExecutor = ((JavascriptExecutor) driver);
    }

    @After
    public void tearDown() {
        //7. quit the driver
        driver.quit();
    }

    // open url https://example.cypress.io/commands/actions
    // Focus on element By.cssSelector(".action-focus")
    // Assert is focused
    @Test
    public void actions() {

        driver.get("https://example.cypress.io/commands/actions");

        element = driver.findElement(By.cssSelector(".action-focus"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        assertTrue(
                driver.findElement(By.xpath("//*[@for='password1']")).getAttribute("style").contains("color: orange;"));
    }

    /*
    * Go to https://example.cypress.io/commands/cookies
    * Set a cookie using button
    * Get the cookie named "token"
    * Assert that we have a cookie value equal to "123ABC"
    * */
    @Test
    public void cookies() {
        driver.get("https://example.cypress.io/commands/cookies");
        element = driver.findElement(By.cssSelector("#getCookie .set-a-cookie"));
        element.click();

        var cookie = driver.manage().getCookieNamed("token");
        assertEquals("123ABC", cookie.getValue());
    }


    /*
    * Go to https://ultimateqa.com/complicated-page/
    * scroll to bottom of page using JS executeScript command:
    *
    * window.scrollTo(0, document.body.scrollHeight)
    * Thread.sleep(1000);
    * */
    @Test
    public void scrollToBottom() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    /*
     * Go to https://ultimateqa.com/complicated-page/
     * scroll to top of page using JS executeScript command:
     *
     * window.scrollTo(0, -document.body.scrollHeight)
     * Thread.sleep(1000);
     * */
    @Test
    public void scrollToTop() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        //Now scroll to the top
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    @Test
    public void howToHighlightElement() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/complicated-page/");
        element = driver.findElement(By.id("Skills_Improved"));
        // Get the style of the element and store it into a variable
        var originalStyle = element.getAttribute("style");
        // execute a JS command that will create a yellow border around the element
        javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 7px solid yellow; border-style: dashed;");
        Thread.sleep(2000);
        // using JS, set the style of the element back to the original
        javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                originalStyle);
    }
}
