package com.testproject;

import io.testproject.sdk.drivers.web.SafariDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariOptions;

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


}
