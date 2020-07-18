package webdriver.methods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WebDriverMethods {

    /*
    * !!!CRITICAL!!!
    * Always check if the current version of chromedriver matches the supported Chrome version.
    * It's highly likely that the chromedriver version in this project is out of date (Chrome updates often)!
    * Hence, you need to:
    * 1. Download the latest Chrome driver: https://chromedriver.chromium.org/
    * 2. Make sure that your Chrome version is supported by your ChromeDriver download
    *
    * Side Note:
    * This is why it's not a good idea to upload executables to source control in programming.
    * It's extremely hard to keep up with the versions.
    * In .NET, getting lost in executable versions is referred to as DLL Hell
    * (However, I had to break this rule for this course so that you see the whole process)
    *
    *
    * Or, you can just use WebDriverManager maven package :)
    * */
    WebDriver driver;
    WebElement element;

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
    public void windowsFrames() {
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://the-internet.herokuapp.com/windows/new');");

        String originalWindow = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        handles.remove(originalWindow);

        String nextWindow = String.valueOf(handles.iterator().next());

        driver.switchTo().window(nextWindow);
        assertEquals("New Window", driver.getTitle());

        driver.close();
        driver.switchTo().window(originalWindow);
        assertEquals("The Internet", driver.getTitle());
    }

    @Test
    public void frames() {
        //Navigate to a URL
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        //we can switch frames by index. 0 is first, 1 is second ...
        driver.switchTo().frame(1);
        //assert that we switched to the bottom frame.
        //If we didn't, NoSuchElementException would be thrown
        assertEquals("BOTTOM", driver.findElement(By.tagName("body")).getText());

        //switchTo().parentFrame() moves focus to the parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        //assert that we switched to the left frame
        assertEquals("LEFT", driver.findElement(By.tagName("body")).getText());

        //switchTo().defaultContent() will move to the top of the HTML
        //Anything inside of the top level HTML is searchable
        driver.switchTo().defaultContent();
        //Get the element's height with Name frame-top. If we weren't focused on this
        //element, findElement would throw a NoSuchElementException
        assertTrue(driver.findElement(By.name("frame-top")).getSize().height > 0);
    }

    @Test
    public void alerts() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Click for JS Alert')]")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Click for JS Confirm')]")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Click for JS Prompt')]")).click();
        Alert inputAlert = driver.switchTo().alert();
        String text = inputAlert.getText();
        inputAlert.sendKeys("Look Mom! I can automate alerts :)");
        inputAlert.accept();
    }
}
