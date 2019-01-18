package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;

import java.util.concurrent.TimeUnit;

public class BasePage extends Page {

    public BasePage() {
//        if(PageFactory.isDriverInitialized()) {
//            WebDriver driver = PageFactory.getDriver();
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Find By Locator wait
//            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); //Load Page wait
//            driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS); //JS Scrip Wait
//        }
    }

    public String getCurrentURL() {
        return PageFactory.getDriver().getCurrentUrl();
    }

    @ActionTitle("открывает URL")
    public void openPage(String URL) {
        PageFactory.getDriver().get(URL);
    }

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(PageFactory.getWebDriver(), PageFactory.getTimeOutInSeconds());
    }
}
