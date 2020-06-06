package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int getItemCount() {
        List<WebElement> cartItems;
        try
        {
            cartItems =
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("cart_item")));
        }
        catch (TimeoutException e)
        {
            return 0;
        }
        return cartItems.size();
    }

    public void open() {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
    }

    public void injectItemIntoCart() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.sessionStorage.setItem('session-username', 'standard-user')");
        jsExecutor.executeScript("window.sessionStorage.setItem('cart-contents', '[1]')");
        driver.navigate().refresh();
    }
}
