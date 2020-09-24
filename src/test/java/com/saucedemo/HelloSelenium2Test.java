package com.saucedemo;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
* First shown by Simon Stewart 7/18/20
* https://www.youtube.com/watch?time_continue=14&v=c163xQXiiEM&feature=emb_logo
* */

public class HelloSelenium2Test {
    @Test
    public void deprecatedTest()
    {
        WebDriver driver = new SafariDriver();
        //Deprecated in 4.x
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://www.saucedemo.com/");

        //Removed in 4.x
        WebElement button = ((FindsByName)driver).findElementByName("LOGIN");
        button.click();

        driver.quit();
    }
}
