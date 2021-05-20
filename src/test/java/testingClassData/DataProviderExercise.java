package testingClassData;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnitParamsRunner.class)
public class DataProviderExercise {
    WebDriver driver;

    private WebDriver getDriver() {
        return new ChromeDriver();
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Parameters(source = ProductDataProvider.class)
    public void priceCheckTest(String itemName, String price) {
        // The xPath for the element is a bit complex. Basically what we are looking for is the div that contains the product price
        // and has the same ancestor as the div that contains the itemName (so we know we are checking the price for our specific product)
        String xPath = String.format
                ("//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']",
                        itemName);
        WebElement priceElement = driver.findElement(By.xpath(xPath));
        System.out.println(priceElement.getText());
        Assert.assertEquals(priceElement.getText(), price);
    }

}
