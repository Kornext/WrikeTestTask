package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.annotations.RedirectsTo;

@PageEntry(title = "Home", url = "/home")
public class HomePage {

    private String pageURL = "https://www.wrike.com/";
    @ElementTitle("ButtonStartUP")
    @FindBy(xpath = "//div[@class='r']//button")
    public WebElement buttonGetStartForFree;
    @ElementTitle("InputEmailOnModalForm")
    @FindBy(xpath = "//label[@class='modal-form-trial__label']/input")
    public WebElement emailTextField;
    @ElementTitle("ButtonCreateAccountOnModalForm")
    @FindBy(xpath = "//label[@class='modal-form-trial__label']/button")
    //@RedirectsTo(page = InterviewPage.class)
    public WebElement buttonCreateMyWrikeAcc;

    public HomePage() {

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