package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginFeatureTests {

    private ChromeDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver(new ChromeOptions());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void shouldOpenPage() {
        driver.get("https://example.cypress.io/commands/actions");
        driver.findElement(By.cssSelector(".action-email")).sendKeys("test@test.com");
        Assert.assertTrue(true);
    }

}
