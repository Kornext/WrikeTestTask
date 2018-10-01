package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage extends BasePage {

    private String pageURL = "https://www.wrike.com/";
    public WebElement buttonGetStartForFree;
    public WebElement emailTextField;
    public WebElement buttonCreateMyWrikeAcc;

    public HomePage(FirefoxDriver driver) {
        super(driver);
    }

    public void fillElements() {
        if(driver.getCurrentUrl().equals(pageURL)) {
            buttonGetStartForFree = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button"));
            emailTextField = driver.findElement(By.xpath("/html/body/div[4]/div/form/label[1]/input"));
            buttonCreateMyWrikeAcc = driver.findElement(By.xpath("/html/body/div[4]/div/form/label[2]/button"));
        }
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
