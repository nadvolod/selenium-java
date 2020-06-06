package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartComponent extends BasePage {
    public ShoppingCartComponent(WebDriver driver) {
        super(driver);
    }

    public boolean hasItems(int numberOfItems) {
        String numOfItemsInCart = driver.findElement(By.xpath("//*[@class='fa-layers-counter shopping_cart_badge']")).getText();
        return  Integer.parseInt(numOfItemsInCart) == numberOfItems;
    }
}
