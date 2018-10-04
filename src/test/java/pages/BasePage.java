package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait driverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driverWait= new WebDriverWait(driver, 5000);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); // Find By Locator wait
        driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS); //Load Page wait
        driver.manage().timeouts().setScriptTimeout(8, TimeUnit.SECONDS); //JS Scrip Wait
    }

    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
