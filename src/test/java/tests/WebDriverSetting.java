package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetting {

    public static WebDriver driver;

    public String nameDriver;

    public WebDriverSetting(String nameDriver) {
        this.nameDriver = nameDriver;
        switch (nameDriver) {
            case "firefox" : {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kornext_N\\FireFoxWebDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            case "chrome" : {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kornext_N\\ChromeWebDriver\\chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kornext_N\\FireFoxWebDriver\\geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @Before
    public void setUp() {

    }

    @AfterClass
    public static void closeTest() {
        driver.quit();
        driver.close();
    }
}