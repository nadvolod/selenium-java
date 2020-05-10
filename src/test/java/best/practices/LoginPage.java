package best.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //Private driver for a page object so that it's never accessible to our tests
    private WebDriver driver;
    //Private element locator that is never open to our tests
    private WebElement getUserNameField()
    {
        return driver.findElement(By.id("user-name"));
    }
    //Public login method, what the user does!
    public void login(String userName, String password) {
        getUserNameField().sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn_action")).submit();
    }
}
