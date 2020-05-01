package atda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AcceptanceTestDrivenAutomationTest extends BaseTest {

    @Test
    public void shouldOpen() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        assertTrue("Login page should load successfully", loginPage.isLoaded());
    }

    @Test
    public void shouldLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue("Login page should load successfully", loginPage.isLoaded());

        loginPage.login("standard_user", "secret_sauce");
        assertTrue("Products page should open when we login", new ProductsPage(driver).isLoaded());
    }
}
