package atda;

import org.junit.Test;
import pages.ProductsPage;
import pages.ShoppingCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartFeatureTest extends BaseTest {
    @Test
    public void shouldHaveItemAppearOnCartPage() {
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.open();

        cartPage.injectItemIntoCart();
        assertEquals("Added one item to the cart and expected to have 1 item on cart page",
                1, new ShoppingCartPage(driver).getItemCount());
    }

    @Test
    public void shouldBeAbleToAddItemToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.open();
        productsPage.Inventory.addRandomItemToCart();
        assertTrue("We added a single item to the cart and expected the cart to have 1 item",
                productsPage.ShoppingCart.hasItems(1));
    }
}
