package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@PageEntry(title = "Interview", url = "/interview")
public class InterviewPage extends BasePage {

    String pageURL = "https://www.wrike.com/resend/";
    String facebookURL = "";
    String facebookImgURL = "";
    public WebElement buttonResendEmail;
    public WebElement buttonSubmitResult;
    List<WebElement> radioDiscirbeInterest = new ArrayList<>();
    List<WebElement> radioTotalTeamMembers = new ArrayList<>();
    List<WebElement> radioYouTeemFollow = new ArrayList<>();
    List<WebElement> radioDiv = new ArrayList<>();
    WebElement buttonNoGoogleFrame;

    public InterviewPage(WebDriver driver) {
        super(driver);
    }

    public void fillElements() {
        if (driver.getCurrentUrl().equals(pageURL)) {
            facebookURL = driver.findElement
                    (By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[2]/a")).getAttribute("href");
            facebookImgURL = driver.findElement(By.cssSelector("li.wg-footer__social-item:nth-child(1) > " +
                    "a:nth-child(1) > svg:nth-child(1) > use:nth-child(1)")).getAttribute("xlink:href");
            buttonResendEmail = driver.findElement
                    (By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button"));
            buttonSubmitResult = driver.findElement
                    (By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button"));
            //radioDiv.addAll(driver.findElements(By.className("radio")));
            radioDiv.addAll(driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("radio"))));
            for (int i = 0; i < radioDiv.size(); i++) {
                switch (i) {
                    case 0:
                        radioDiscirbeInterest = radioDiv.get(i).findElements(By.className("switch__button"));
                        break;
                    case 1:
                        radioTotalTeamMembers = radioDiv.get(i).findElements(By.className("switch__button"));
                        break;
                    case 2:
                        radioYouTeemFollow = radioDiv.get(i).findElements(By.className("switch__button"));
                        break;
                }
            }
        }
    }

    public String getPageURL() {
        return pageURL;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public String getFacebookImgURL() {
        return facebookImgURL;
    }

    public void switchToGoogleFrame() {
        driver.switchTo().frame(driver.findElement
                (By.xpath("/html/body/div[6]/div/iframe")));
        buttonNoGoogleFrame = driver.findElement
                (By.xpath("/html/body/c-wiz/div/div/div[2]/div[4]/span[1]/div/content/span"));
    }

    public void switchToBaseFrame() {
        driver.switchTo().defaultContent();
    }

    public void closeGoogleFrame() {
        switchToGoogleFrame();
        driverWait.until(ExpectedConditions.elementToBeClickable(buttonNoGoogleFrame));
        buttonNoGoogleFrame.click();
        switchToBaseFrame();
    }

    public void getPage() {
        driver.get(pageURL);
    }

    public void randomAnswerDiv() throws InterruptedException {

//        driverWait.until(ExpectedConditions.elementToBeClickable(radioDiscirbeInterest.get(0)));
//        driverWait.until(ExpectedConditions.not(
//                ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[6]/div/iframe"))));
//        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[1]/button")));



        int size = radioDiscirbeInterest.size();
        Random rnd = new Random(System.currentTimeMillis());
        int randomNumber = rnd.nextInt(size - 0);
        radioDiscirbeInterest.get(randomNumber).click();
        Thread.sleep(500);  //Для наглядности происходящего на экране

        size = radioTotalTeamMembers.size();
        rnd = new Random(System.currentTimeMillis());
        randomNumber = rnd.nextInt(size - 0);
        radioTotalTeamMembers.get(randomNumber).click();
        Thread.sleep(500);


        size = radioYouTeemFollow.size();
        rnd = new Random(System.currentTimeMillis());
        randomNumber = rnd.nextInt(size - 0);
        radioYouTeemFollow.get(randomNumber).click();
        Thread.sleep(500);

        if (radioYouTeemFollow.get(randomNumber).getText().contains("Other")) {
            WebElement radioText = radioYouTeemFollow.get(randomNumber).findElement(
                    By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span/input"));
            String randomText = "test";
                    //org.apache.commons.lang3.RandomStringUtils.random(7, true, false);
            randomText = randomText.toLowerCase();
            radioText.sendKeys(randomText);
            radioText.click();
            Thread.sleep(500);
        }
    }

    public void buttonSubmitResultClick() {
        buttonSubmitResult.click();
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")));
//        driverWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button"))));
    }
}