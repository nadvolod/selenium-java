package com.ultimateqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver webDriver;
    private WebDriver driver;
    private By backpackLocator = By.id("backapack");
    private By addToCartButtonLocator = By.className("btn_primary");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getBackpack() {
        return driver.findElement(backpackLocator);
    }

    private WebElement getAddToCartButton() {
        return driver.findElement(addToCartButtonLocator);
    }

    public void addToCart(){
        getAddToCartButton().click();
    }
}
