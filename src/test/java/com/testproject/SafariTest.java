package com.testproject;

import io.testproject.sdk.drivers.web.SafariDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new SafariDriver(new SafariOptions());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldOpen() {
        driver.get("https://example.cypress.io/commands/actions");
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }

    @Test
    public void shouldType() {
        driver.get("https://example.cypress.io/commands/actions");
        var inputField = driver.findElement(By.cssSelector(".action-email"));
        inputField.sendKeys("test@test.com");
        Assert.assertEquals("test@test.com",
                inputField.getAttribute("value"));
    }
}
