package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomNamesTest {

    private WebDriver driver;

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldOpen() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver = new ChromeDriver(new ChromeOptions());
        driver.get("https://example.cypress.io/commands/actions");
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }

    @Test
    public void shouldType() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver = new ChromeDriver(new ChromeOptions());
        driver.get("https://example.cypress.io/commands/actions");
        var inputField = driver.findElement(By.cssSelector(".action-email"));
        inputField.sendKeys("test@test.com");
        Assert.assertEquals("test@test.com",
                inputField.getAttribute("value"));
    }
}
