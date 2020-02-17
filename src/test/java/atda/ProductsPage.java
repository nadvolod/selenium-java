package atda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("inventory_filter_container"))).isDisplayed();
    }
}
