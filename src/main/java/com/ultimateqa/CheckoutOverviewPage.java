package com.ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finish() {
        driver.findElement(By.className("cart_button")).click();
    }
}
