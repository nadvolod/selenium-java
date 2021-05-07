package csvDataDriven;

import au.com.bytecode.opencsv.CSVReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {
    WebDriver driver;

    // We use throws IOException because this is the exception we might expect if the file is not found.
    // Alternatively, we can wrap all our code in a try-catch block, and cath the IOException.
    public static String[][] readCsvFile() throws IOException {
        // Here we actually read the CSV file.
        // We need to provide the file location, the separator used, the quotes character and the starting line.
        // The file is read as 0-based, and since we have a header line, we wil start at the second line, which means we pass 1 as parameter
        CSVReader csvReader = new CSVReader(new FileReader("src/test/java/csvDataDriven/Users.csv"), ',', '"', 1);
        String[] line;
        // Here we create a string list, which one element for each line of the CSV
        List<String[]> userList = new ArrayList<>();
        while ((line = csvReader.readNext()) != null) {
            userList.add(line);
        }
        // After we get the number of rows and columns, we create a new array which has 2 string values,
        // which will be the string data (username and password) from our file:
        int rows = userList.size();
        int cols = userList.get(0).length;
        String[][] dataFromCSV = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] eachRow = userList.get(i);
            for (int j = 0; j < cols; j++) {
                dataFromCSV[i][j] = eachRow[j];
            }
        }
        return dataFromCSV;
    }

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

    @MethodSource("readCsvFile")
    @ParameterizedTest
    public void loginTest(String userName, String password) {
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }
}