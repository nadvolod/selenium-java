package atda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AcceptanceTestDrivenAutomationTest extends BaseTest {

    @Test
    public void shouldLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        //I used to do this, now I learned it's not necessary
        //assertTrue("Login page should load successfully", loginPage.isLoaded());
        loginPage.login("standard_user", "secret_sauce");
        assertTrue("Products page should open when we login", new ProductsPage(driver).isLoaded());
    }
    @Test
    public void shouldAddOneItemToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open();
        productsPage.addItemToCart();
        assertEquals("1", productsPage.getCountOfItemsInCart());
    }
    @Test
    public void shouldAddTwoItemsToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open();
        productsPage.addItemToCart();
        productsPage.addItemToCart();
        assertEquals("2", productsPage.getCountOfItemsInCart());

      private WebDriver getDriver() {
        //Telling the system where to find chromedriver on mac
        //System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");

        //The path of chromedriver for windows
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        return new ChromeDriver();
    }
}
