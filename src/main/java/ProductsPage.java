import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver webDriver;
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBackpack() {
        return driver.findElement(By.id("backapack"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.className("btn_primary"));
    }

    public void addToCart(){
        getAddToCartButton().click();
    }
}
