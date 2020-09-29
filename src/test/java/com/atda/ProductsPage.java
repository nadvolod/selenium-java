package com.atda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }

    public boolean isLoaded() {
        return driver.findElement(By.id("inventory_filter_container")).
                isDisplayed();
    }
}
