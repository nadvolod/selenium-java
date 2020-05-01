package atda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public By getUserNameLocator()
    {
        return By.id("user-name");
    }
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public boolean isLoaded() {
        return isElementDisplayed(getUserNameLocator());
    }

    public void login(String username, String password) {
        driver.findElement(getUserNameLocator()).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn_action")).click();
    }
}
