package com.atda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }

    public boolean isLoaded() {
        return driver.findElement(By.id("inventory_filter_container")).
                isDisplayed();
    }

    public void addItemToCart() {
        driver.findElement(By.className("btn_inventory")).click();
    }
}
