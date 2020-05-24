import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Methods {
    private WebDriver driver;

    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void countElements() {
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
    public void methodsAreGood() {
//        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("https://www.saucedemo.com/inventory.html");
//        String inventoryElementLocator = "inventory_item";
//        //Code duplication
//        int countOfItems = driver.
//                findElements(By.className(inventoryElementLocator)).
//                size();
//        WebElement element = findElement(driver, "locator 1");
//        WebElement element2 = findElement(driver, "locator 2");
//
//        //Code readability
//        var displayedElements = getAllDisplayedElements(driver);

        int countOfItems = 5;
        String inventoryElementLocator = "sample locator";
        if (countOfItems == 6) {
            print("inventoryElementLocator = " + inventoryElementLocator);
            System.out.println("inventoryElementLocator = " +
                    inventoryElementLocator);

            print("inside of if block");
            System.out.println("inside of if block");
        } else if (countOfItems == 5) {
            print("Inside of else if");
            System.out.println("Inside of else if");
        } else {
            print("inside of else block");
            System.out.println("inside of else block");
        }
        //driver.quit();
    }

    public Stream<WebElement> getAllDisplayedElements(WebDriver driver) {
        return driver.findElements(By.xpath("//*[@class='inventory_item']")).stream().
                filter(w -> w.isDisplayed());
    }

    public WebElement findElement(WebDriver driver, String locator) {
        return driver.findElement(By.className(locator));
    }

    public void print(String whatToPrint) {
        System.out.println(whatToPrint);
    }

    @Test
    public void funWithSelenium() {
        driver = new ChromeDriver();
        // navigate to this page "https://www.saucedemo.com/inventory.html"
        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        List<WebElement> elements = driver.findElements(By.className("inventory_item"));

        WebElement element = driver.findElement(By.className("inventory_item"));

        assertEquals(6, elements.size());
        assertTrue(element.isDisplayed());
    }

    @Test
    public void methodChallenge() {
        // Create a void method called displayHighScorePosition
        // it should take a players name as a parameter, and a 2nd parameter as a position in the high score table
        // You should display the players name along with a message like " managed to get into position " and the
        // position they got and a further message " on the high score table".
        //
        // Create a 2nd method called calculateHighScorePosition
        // it should be sent one argument only, the player score
        // it should return an int
        // the return data should be
        // 1 if the score is >=1000
        // 2 if the score is >=500 and < 1000
        // 3 if the score is >=100 and < 500
        // 4 in all other cases
        // call both methods and display the results of the following
        // a score of 1500, 900, 400 and 50
        //

        int position = calculateHighScorePosition(1500);
        displayHighScorePosition("Nikolay", position);

        position = calculateHighScorePosition(900);
        displayHighScorePosition("Bobo", position);

        position = calculateHighScorePosition(400);
        displayHighScorePosition("Cheryl", position);

        position = calculateHighScorePosition(50);
        displayHighScorePosition("Diane", position);
    }

    public void displayHighScorePosition(String playerName, int highScorePosition){
        System.out.println(playerName + " managed to get into position "
                    + highScorePosition + " on the high score table");
    }

    public int calculateHighScorePosition(int score){
        if(score >= 1000){
            return 1;
        }
        else if(score >=500 && score < 1000){
            return 2;
        }
        else if(score >=100 && score < 500){
            return 3;
        }
        else {
            return 4;
        }
    }
}
