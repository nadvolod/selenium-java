package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage{
    public ShoppingCartComponent ShoppingCart;

    public ProductsPage(WebDriver driver) {
        super(driver);
        ShoppingCart = new ShoppingCartComponent(driver);
    }

    public boolean isLoaded() {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("inventory_filter_container"))).isDisplayed();
    }

    public void addRandomItemToCart() {
        driver.findElement(By.cssSelector("button.btn_primary.btn_inventory")).click();
    }
}
