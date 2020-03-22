package atda;

import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.assertTrue;

public class ProductsFeatureTest extends BaseTest {
    @Test
    public void shouldAddItemToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isLoaded());

        productsPage.addRandomItemToCart();
        assertTrue(productsPage.ShoppingCart.hasItems(1));
    }
}
