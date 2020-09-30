package com.atda;

import com.saucelabs.saucebindings.SauceSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsFeatureTests {
    private WebDriver driver;
    private ProductsPage productsPage;
    private SauceSession session;

    @Before
    public void setUp() {
        session = new SauceSession();
        driver = session.start();
        productsPage = new ProductsPage(driver);
    }

    @After
    public void tearDown() {
        session.stop(true);
    }

    @Test
    public void shouldOpen() {
        productsPage.open();
        assertTrue(productsPage.isLoaded());
    }

    @Test
    public void shouldAddItemToCart() {
        productsPage.open();
        productsPage.addItemToCart();
        assertEquals(1, new ShoppingCart(driver).getItemCount());
    }
}
