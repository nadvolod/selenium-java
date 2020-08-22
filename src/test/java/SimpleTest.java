import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class SimpleTest {
    @Test
    public void shouldOpen() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        var driver = new ChromeDriver(new ChromeOptions());
        driver.navigate().to("https://example.cypress.io/commands/actions");
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }
}
