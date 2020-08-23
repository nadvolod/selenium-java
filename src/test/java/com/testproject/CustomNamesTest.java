package com.testproject;

import io.testproject.sdk.drivers.web.SafariDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomNamesTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new SafariDriver(new SafariOptions(), "JUnit 5", "Junit 5 Job");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldOpen() {
        driver.get("https://example.cypress.io/commands/actions");
        assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }

    @Test
    public void shouldType() {
        driver.get("https://example.cypress.io/commands/actions");
        var inputField = driver.findElement(By.cssSelector(".action-email"));
        inputField.sendKeys("test@test.com");
        assertEquals("test@test.com",
                inputField.getAttribute("value"));
    }
}
