package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

//TODO ADD WAITINGS

@PageEntry(title = "Home", url = "/home")
public class HomePage extends BasePage {

    private String pageURL = "https://www.wrike.com/";

    @ElementTitle("кнопка")
    @FindBy(xpath = "//div[@class='r']//button")
    private WebElement buttonGetStartForFree;

    @ElementTitle("InputEmailOnModalForm")
    @FindBy(xpath = "//label[@class='modal-form-trial__label']/input")
    private WebElement emailTextField;

    @ElementTitle("ButtonCreateAccountOnModalForm")
    @FindBy(xpath = "//label[@class='modal-form-trial__label']/button")
    //@RedirectsTo(page = InterviewPage.class)
    private WebElement buttonCreateMyWrikeAcc;

    @ElementTitle("ModalFormInputEmail")
    @FindBy(xpath = "//div[@id='modal-pro']//form")
    private WebElement inputEmailForm;

    public HomePage() {
        //PageFactory.initElements(PageFactory.getDriver(), this); //Для WebElement
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(
                PageFactory.getDriver())), this);
    }

    @ActionTitle("нажимает на кнопку Get started for free")
    public void buttonClickGetStartedForFree() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonGetStartForFree));
        buttonGetStartForFree.click();
    }

    @ActionTitle("нажимает на кнопку Create Wrike Account")
    public void buttonClickCreateAccClick() {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonCreateMyWrikeAcc));
        buttonCreateMyWrikeAcc.click();
    }

    @ActionTitle("вводит емейл")
    public void inputEmail() {
        String emailRandom = "test";
        emailRandom = emailRandom.toLowerCase() + "wpt@wriketask.qaa";
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(emailTextField));
        emailTextField.sendKeys(emailRandom);
    }

    @ActionTitle("открывается страница")
    public void redirectToPage() {
        org.junit.Assert.assertTrue(getCurrentURL().contains("www.wrike.com/resend"));
    }

    @ActionTitle("поле для ввода емейла")
    public boolean checkInputField() {
        return inputEmailForm.isDisplayed();
    }
}