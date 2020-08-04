package com.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isElementDisplayed(By.id("inventory_container"));
    }

    public void open() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }

    public void addItemToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn_primary"))).click();
    }
    public String getCountOfItemsInCart() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }
}
