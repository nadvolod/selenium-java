package com.saucedemo;

import com.saucelabs.saucebindings.Browser;
import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Docs https://opensource.saucelabs.com/sauce_bindings/docs/overview.html
// Java 9+

public class WithSauceBindings {

    private WebDriver driver;
    private SauceSession session;

    @After
    public void tearDown() {
        session.stop(true);
    }

    @Test
    public void findButton() {
        var options = new SauceOptions();
        options.setBrowserName(Browser.EDGE);
        driver = new SauceSession(options).start();

        driver.get("https://www.saucedemo.com/");
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
    }
}
