package com.testproject;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class LoginFeatureTests {

    private ChromeDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver(new ChromeOptions());
        driver.report().step("Create new driver");
    }

    @After
    public void tearDown() throws Exception {
        driver.report().step("Quit driver");
        driver.quit();
    }
    @Test
    public void shouldOpenPage() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver.get("https://example.cypress.io/commands/actions");
        driver.report().step("Open url " + "https://example.cypress.io/commands/actions");
        driver.findElement(By.cssSelector(".action-email")).sendKeys("test@test.com");
        driver.report().step("Find element " + ".action-email");
        Assert.assertTrue(true);
    }


}
