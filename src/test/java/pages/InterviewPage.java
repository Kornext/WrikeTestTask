package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@PageEntry(title = "Interview", url = "/interview")
public class InterviewPage extends BasePage {

    String pageURL = "https://www.wrike.com/resend/";
    String facebookURL = "";
    String facebookImgURL = "";

    @ElementTitle("ButtonResendEmail")
    @FindBy(xpath = "//div[@class='wg-grid']//button[text()='Resend email']")
    public WebElement buttonResendEmail;

    @ElementTitle("ButtonSubmitResult")
    @FindBy(xpath = "//button[text()='Submit results']")
    public WebElement buttonSubmitResult;

    @ElementTitle("ButtonComment")
    @FindBy(xpath = "//input[@placeholder='Your comment']")
    WebElement radioCommentInputButton;

    @ElementTitle("GoogleFrame")
    @FindBy(xpath = "//iframe[@tabindex='0']")
    WebElement googleFrame;

    @ElementTitle("ButtonNoOnGoogleFrame")
    @FindBy(xpath = "//span[text()='NO']")
    WebElement buttonNoGoogleFrame;

    @FindBy(xpath = "//button[text()='Very interested']/../..//input") //Первая "линия" кнопок
    List<WebElement> radioDiscirbeInterest = new ArrayList<>();

    @FindBy(xpath = "//button[text()='16–25']/../..//input") //Вторая "линия" кнопок
    List<WebElement> radioTotalTeamMembers = new ArrayList<>();

    @FindBy(xpath = "//button[text()='Yes']/../..//input[@name]")
    List<WebElement> radioYouTeemFollow = new ArrayList<>();

    public InterviewPage() {

    }

    @ActionTitle("Закрыть Google окно")
    public void closeGoogleFrame() {
        switchToGoogleFrame();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonNoGoogleFrame));
        buttonNoGoogleFrame.click();
        switchToBaseFrame();
    }

    @ActionTitle("Ответить случайным образом")
    public void randomAnswerDiv() throws InterruptedException {
        //Проверка кликабельности хотя бы одной кнопки
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(radioDiscirbeInterest.get(0)));

        int size = radioDiscirbeInterest.size();
        Random rnd = new Random(System.currentTimeMillis());
        int randomNumber = rnd.nextInt(size - 0);
        radioDiscirbeInterest.get(randomNumber).click();
        Thread.sleep(500);  //Для наглядности происходящего на экране

        size = radioTotalTeamMembers.size();
        rnd = new Random(System.currentTimeMillis());
        randomNumber = rnd.nextInt(size - 0);
        radioTotalTeamMembers.get(randomNumber).click();
        Thread.sleep(500); //Для наглядности происходящего на экране

        size = radioYouTeemFollow.size();
        rnd = new Random(System.currentTimeMillis());
        randomNumber = rnd.nextInt(size - 0);
        radioYouTeemFollow.get(randomNumber).click();
        Thread.sleep(500); //Для наглядности происходящего на экране

        if (radioYouTeemFollow.get(randomNumber).getText().contains("Other")) { //if(randomNumber == 2) {
            String randomText = "test";
            //org.apache.commons.lang3.RandomStringUtils.random(7, true, false);
            randomText = randomText.toLowerCase();
            radioCommentInputButton.sendKeys(randomText);
            //radioCommentInputButton.click();
            Thread.sleep(500); //для наглядности происходящего на экране
        }
    }

    @ActionTitle("Нажать на кнопку Submit Result")
    public void buttonSubmitResultClick() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonSubmitResult));
        buttonSubmitResult.click();
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
        PageFactory.getDriver().switchTo().frame(googleFrame);
    }

    public void switchToBaseFrame() {
        PageFactory.getDriver().switchTo().defaultContent();
    }
}