package testNGDataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDataDrivenExercise {

    WebDriver driver;
    private WebDriver getDriver() {
        return new ChromeDriver();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // The test method is the same as in the previous examples,
    // except with TestNG we pass the data provider method like this:
    @Test (dataProvider = "provideProductData")
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

    // This time the objects returned have 2 values:
    // One for the product name, and one for the price
    @org.testng.annotations.DataProvider(name = "provideProductData")
    public static Object[][] provideProductData() {
        return new Object[][]{
                new Object[]{"Sauce Labs Backpack", "$29.99"},
                new Object[]{"Sauce Labs Bike Light", "$9.99"},
                new Object[]{"Sauce Labs Bolt T-Shirt", "$15.99"},
                new Object[]{"Sauce Labs Fleece Jacket", "$49.99"},
                new Object[]{"Sauce Labs Onesie", "$7.99"},
                new Object[]{"Test.allTheThings() T-Shirt (Red)", "$15.99"}
        };
    }
}
