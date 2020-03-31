package best.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    //Private driver for a page object so that it's never accessible to our tests
    private WebDriver driver;
    //Private element locator that is never open to our tests
    private WebElement getCheckoutButton()
    {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }
    //Public login method, what the user does!
    public void startCheckout() {
        getCheckoutButton().click();
    }
}
