package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomNamesTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver(new ChromeOptions());
    }

    @AfterTest
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
