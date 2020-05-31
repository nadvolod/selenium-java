package com.ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessful() {
        return driver.findElement(By.className("pony_express")).isDisplayed();
    }
}
