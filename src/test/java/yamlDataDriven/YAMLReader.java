package yamlDataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class YAMLReader {
    WebDriver driver;

    private WebDriver getDriver() {
        return new ChromeDriver();
    }

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void readYamlFile() throws IOException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(new File("src/test/java/yamlDataDriven/Users.yaml"));
        Map<String, User> users = yaml.load(inputStream);
        System.out.println(users);
    }
}
