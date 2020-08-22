package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver(new ChromeOptions());
        driver.get("https://example.cypress.io/commands/actions");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldOpen() {
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }

    @Test
    public void shouldType() {
        var inputField = driver.findElement(By.cssSelector(".action-email"));
        inputField.sendKeys("test@test.com");
        Assert.assertEquals("test@test.com",
                inputField.getAttribute("value"));
    }
}
