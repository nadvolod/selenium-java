package com.ultimateqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPageObject {
    private WebDriver webDriver;
    private By checkoutButtonLocator = By.className("checkout_button");

    public CartPageObject(WebDriver driver){
        webDriver = driver;
    }

    public void open(){
        webDriver.navigate().to("https://www.saucedemo.com/cart.html");
    }

    public void checkout(){
        getCheckoutButton().click();
    }

    private WebElement getCheckoutButton() {
        return webDriver.findElement(checkoutButtonLocator);
    }
}
