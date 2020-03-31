package best.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {
    //Private driver for a page object so that it's never accessible to our tests
    private WebDriver driver;
    //Private element locator that is never open to our tests
    private WebElement getFirstNameField()
    {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }
    //Public login method, what the user does!
    public void fillOutPersonalInformation() {
        getFirstNameField().sendKeys("firstName");
        getLastNameField().sendKeys("firstName");
        getZipCodeField().sendKeys("firstName");
    }

    private WebElement getZipCodeField() {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }
    private WebElement getLastNameField() {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }
}
