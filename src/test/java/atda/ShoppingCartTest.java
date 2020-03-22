package atda;

import org.junit.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartTest extends BaseTest {
    @Test
    public void shouldHaveItemInCartPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());

        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isLoaded());

        productsPage.Inventory.addRandomItemToCart();
        assertTrue("We added a single item to the cart and expected the cart to have 1 item",
                productsPage.ShoppingCart.hasItems(1));

        productsPage.ShoppingCart.open();
        assertEquals("Added one item to the cart and expected to have 1 item on cart page",
                1, new ShoppingCartPage(driver).getItemCount());
    }
}
