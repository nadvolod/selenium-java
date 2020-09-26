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
    public void shouldOpen() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        Thread.sleep(3000);
        assertEquals("Filling Out Forms - Ultimate QA", driver.getTitle());
    }

    @Test
    public void shouldType() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("Nikolay");
        Thread.sleep(1000);
        driver.findElement(By.name("et_builder_submit_button")).click();
        Thread.sleep(1000);
        var actualListItems = driver.findElements(By.xpath("//*[@class='et-pb-contact-message']/ul/li")).size();
        assertEquals(1, actualListItems);
    }
}
