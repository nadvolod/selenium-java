package com.ultimateqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.className("btn_action");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getUsernameField() {
        return driver.findElement(usernameLocator);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordLocator);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }

    public void login() {
        getUsernameField().sendKeys("standard_user");
        getPasswordField().sendKeys("secret_sauce");
        getLoginButton().click();
    }
}
