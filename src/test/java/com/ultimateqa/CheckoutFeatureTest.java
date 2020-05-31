package com.ultimateqa;

import com.ultimateqa.pages.CartPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class CheckoutFeatureTest {

    private ChromeDriver driver;

    //This method will run once before all of the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void addToCart() {
        CartPageObject cartPage = new CartPageObject(driver);
        cartPage.open();
        cartPage.checkout();
    }

    @Test
    public void shouldBeAbleToCheckout() {
        PersonalInformationPage personalInfo = new PersonalInformationPage(driver);
        personalInfo.open();
        personalInfo.submitPersonalInformation();
        new CheckoutOverviewPage(driver).finish();
        assertTrue(new OrderConfirmationPage(driver).isSuccessful());
    }
}
