package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSetting {

    public static FirefoxDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kornext_N\\FireFoxWebDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void closeTest() {
        driver.close();
    }
}
