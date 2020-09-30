package com.atda;

import com.saucelabs.saucebindings.SauceSession;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProductsFeatureTests {
    private WebDriver driver;

    @Test
    public void shouldOpen() {
        driver = new SauceSession().start();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open();
        assertTrue(productsPage.isLoaded());
    }
}
