package com.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SprintOnePage {
    private WebDriver driver;

    public SprintOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOutFormAndSubmit(String name) throws InterruptedException {
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys(name);
        driver.findElement(By.id("submitForm")).click();
        Thread.sleep(5000);
    }

    public void open() {
        driver.navigate().to("https://ultimateqa.com/sample-application-lifecycle-sprint-1/");
    }
}
