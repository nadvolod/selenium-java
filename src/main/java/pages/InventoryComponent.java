package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryComponent extends BasePage {
    public InventoryComponent(WebDriver driver) {
        super(driver);
    }
    public void addRandomItemToCart() {
        driver.findElement(By.cssSelector("button.btn_primary.btn_inventory")).click();
    }
}
