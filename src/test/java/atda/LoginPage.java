package atda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://www.saucedemo.com");
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))).isDisplayed();
    }

    public void login(String userName, String password) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn_action")).submit();
    }
}
