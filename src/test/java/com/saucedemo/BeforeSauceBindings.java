package com.saucedemo;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BeforeSauceBindings {

    private WebDriver driver;

    @After
    public void tearDown() throws Exception {
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void findButton() throws MalformedURLException {
        String sauceUserName = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
        String sauceURL = "https://ondemand.saucelabs.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "latest");
        capabilities.setCapability("build", "Selenium4");
        capabilities.setCapability("name", "findButton");

        driver = new RemoteWebDriver(new URL(sauceURL), capabilities);

        driver.get("https://www.saucedemo.com/");
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
    }
}
