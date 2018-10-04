package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private String pageURL = "https://www.wrike.com/";
    public WebElement buttonGetStartForFree;
    public WebElement emailTextField;
    public WebElement buttonCreateMyWrikeAcc;

    public HomePage(FirefoxDriver driver) {
        super(driver);
    }

    public void fillElements() {
        driverWait.ignoring(NoSuchElementException.class);
        if(driver.getCurrentUrl().equals(pageURL)) {
            buttonGetStartForFree = driverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")));
            emailTextField = driverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("/html/body/div[4]/div/form/label[1]/input")));
            buttonCreateMyWrikeAcc = driverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("/html/body/div[4]/div/form/label[2]/button")));
        }
    }

    public void buttonCreateAccClick() {
        buttonCreateMyWrikeAcc.click();
        driverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(
                "https://www.wrike.com/")));
    }

    public void inputEmail(String text) {
        emailTextField.sendKeys(text);
    }

    public String getPageURL() {
        return pageURL;
    }

    public void getPage() {
        driver.get(pageURL);
    }
}
