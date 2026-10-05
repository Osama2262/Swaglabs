package baseTest;

import driverFactory.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigHandler;
import utils.ExcelFileManager;
import utils.JSONFileManager;
import utils.ScreenShot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BaseTest {
    public ConfigHandler configHandler;
    public WebDriver driver;
    public JSONFileManager jsonFileManager;
    public ExcelFileManager excelFileManager;
    @BeforeMethod
    public void setup() {
        excelFileManager = new ExcelFileManager("src/main/resources/products.xlsx","product");
        jsonFileManager = new JSONFileManager("src/main/resources/product.json");
        configHandler = new ConfigHandler("src/main/resources/config.properties");

        driver = DriverFactory.getWebDriver(configHandler.getValue("browserName"));
        driver.manage().window().maximize();
        driver.get(configHandler.getValue("url"));
    }

    @AfterMethod
    public void failedTestCase(ITestResult result) throws FileNotFoundException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File image = ScreenShot.takeScreenShot(driver);
            FileInputStream file = new FileInputStream(image);
            Allure.addAttachment("Screenshot", "image/png", file, "png");

        }
     }
    @AfterMethod
    public void teardown(){
        DriverFactory.quitDriver(configHandler.getValue("browserName"));
        driver =  null;
    }
}
