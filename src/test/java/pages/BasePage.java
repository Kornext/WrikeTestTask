package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

    public FirefoxDriver driver;

    public BasePage(FirefoxDriver driver) {
        this.driver = driver;
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
