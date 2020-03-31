package best.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;
    private WebElement getShoppingCartElement()
    {
        return driver.findElement(By.id("BLABHLABHLJ"));
    }
    public void openShoppingCart() {
        getShoppingCartElement().click();
    }
}
