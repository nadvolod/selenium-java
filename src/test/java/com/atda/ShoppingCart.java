package com.atda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePage {
    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    public int itemCount() {
        return Integer.parseInt(
                driver.findElement(By.className("shopping_cart_badge")).getText());
    }
}
