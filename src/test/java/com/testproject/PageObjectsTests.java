package com.testproject;

import io.testproject.sdk.drivers.web.SafariDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class PageObjectsTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new SafariDriver(new SafariOptions(), "JUnit 5", "Page Objects");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void shouldFillForm() throws InterruptedException {
        var sprintOnePage = new SprintOnePage(driver);
        sprintOnePage.open();
        sprintOnePage.fillOutFormAndSubmit("Nikolay");
        Assertions.assertTrue(new HomePage(driver).isVisible(), "Should see home page");
    }
}
