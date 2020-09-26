package com.testproject;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isVisible() {
        return driver.getTitle().contains("Home - Ultimate QA");
    }
}
