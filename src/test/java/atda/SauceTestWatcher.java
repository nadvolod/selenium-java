package atda;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SauceTestWatcher extends TestWatcher {
    private WebDriver driver;

    public void setDriver(WebDriver driver)
    {
        this.driver = driver;
    }

    protected void succeeded(Description description) {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=passed");
        if(driver != null)
        {
            driver.quit();
        }
    }

    protected void failed(Description description) {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=failed");
        if(driver != null)
        {
            driver.quit();
        }
    }
}
