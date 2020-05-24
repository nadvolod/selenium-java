import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CodeOrganization {
    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void countElements() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        int countOfItems = driver.
                findElements(By.className("inventory_item")).
                size();
        if (countOfItems == 7) {
            assertTrue(true);
        } else {
            fail();
        }
        driver.quit();
    }

    @Test
    public void ifStatements() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        String inventoryElementLocator = "inventory_item";
        int countOfItems = driver.
                findElements(By.className(inventoryElementLocator)).
                size();
        if (countOfItems == 6) {
            System.out.println("inventoryElementLocator = " +
                    inventoryElementLocator);
            String newLocator = inventoryElementLocator;
            System.out.println("inside of if block");
        } else if (countOfItems == 5) {
            System.out.println("Inside of else if");
        } else {
            System.out.println("inside of else block");
        }
        driver.quit();
    }
    @Test
    public void exerciseIf() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        String inventoryElementLocator = "inventory_item";
        int countOfItems = 50;
        if(countOfItems == 10)
        {
            System.out.println("countOfItems = " + countOfItems);
        }
        else if (countOfItems == 9){
            System.out.println("countOfItems = " + countOfItems);   
        }
        else {
            System.out.println("countOfItems = " + countOfItems);
        }
        // if countOfItems is 10, print "countOfItems = 10"
        // else if countOfItems is 9, print "countOfItems = 9"
        // else print "countOfItems = {the other count of items}"
        

        driver.quit();
    }

}
