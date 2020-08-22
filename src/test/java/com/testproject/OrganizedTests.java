package com.testproject;

import io.testproject.sdk.drivers.web.SafariDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class OrganizedTests {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new SafariDriver(new SafariOptions(), "com.testproject", "AcceptanceTests");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void shouldOpenPage() {
        driver.get("https://example.cypress.io/commands/actions");
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }
    @Test
    public void shouldTypeText() {
        driver.get("https://example.cypress.io/commands/actions");
        driver.findElement(By.cssSelector(".action-email")).sendKeys("test@test.com");
        Assert.assertEquals("test@test.com",
                driver.findElement(By.cssSelector(".action-email")).getAttribute("value"));
    }
}
