package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class FirstTestCase extends WebDriverSetting {

    HomePage homePage;

    InterviewPage interviewPage;

    public String nameDriver;

    public FirstTestCase(String ss) {
        super(ss);
        interviewPage = new InterviewPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void firstStep() throws InterruptedException {
        //Click "Get started for free" button near "Login" button;
        homePage.getPage();
        homePage.fillElements();
        homePage.buttonGetStartForFree.click();

        //Fill in the email field with random generated value of email with mask
        // “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
        String emailRandom = org.apache.commons.lang3.RandomStringUtils.
                random(5, true, false);
        emailRandom = emailRandom.toLowerCase() + "wpt@wriketask.qaa";
        homePage.inputEmail(emailRandom);

        //Click on "Create my Wrike account" button +
        // + check with assertion that you are moved to the next page;

        homePage.buttonCreateAccClick();
        Assert.assertEquals(interviewPage.getPageURL(), driver.getCurrentUrl());
        interviewPage.fillElements();
        Thread.sleep(4000);
        interviewPage.closeGoogleFrame();


        //Fill in the Q&A section at the left part of page (like random generated answers) +
        // + check with assertion that your answers are submitted;
        interviewPage.randomAnswerDiv();
        interviewPage.buttonSubmitResultClick();
        Assert.assertFalse("Dont press SubmitResults button",
                interviewPage.buttonSubmitResult.isDisplayed());

        //Click on "Resend email" + check it with assertion;
        interviewPage.buttonResendEmail.click();
        Assert.assertTrue("Dont press ResentEmail button",
                interviewPage.buttonResendEmail.isDisplayed());

        //Check that section "Follow us" at the site footer contains the "Twitter"
        // button that leads to the correct url and has the correct icon.
        Assert.assertEquals("FacebookURL isnt correct",
                "https://www.facebook.com/Wrike", interviewPage.getFacebookURL());
        Assert.assertEquals("Facebook Image isnt correct",
                "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter", interviewPage.getFacebookImgURL());
    }

    @Parameterized.Parameters
    public static Collection<Object> Browser() {
        Object[] object = new Object[] {"firefox", "chrome"};
        return Arrays.asList(object);
    }
}
