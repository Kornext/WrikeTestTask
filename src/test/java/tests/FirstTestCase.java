package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class FirstTestCase extends WebDriverSetting {

    HomePage homePage;
    InterviewPage interviewPage;

    public FirstTestCase() {
        interviewPage = new InterviewPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void firstStep() throws InterruptedException {
        //Click "Get started for free" button near "Login" button;
        homePage.getPage();
        Thread.sleep(1000);
        homePage.fillElements();
        homePage.buttonGetStartForFree.click();
        Thread.sleep(1000);

        //Fill in the email field with random generated value of email with mask
        // “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
        String emailRandom = org.apache.commons.lang3.RandomStringUtils.
                random(5, true, false);
        emailRandom = emailRandom.toLowerCase() + "wpt@wriketask.qaa";
        homePage.inputEmail(emailRandom);

        //Click on "Create my Wrike account" button +
        // + check with assertion that you are moved to the next page;
        homePage.buttonCreateMyWrikeAcc.click();
        Assert.assertNotEquals(interviewPage.getPageURL(), driver.getCurrentUrl());
        Thread.sleep(3000);
        interviewPage.fillElements();
        Thread.sleep(1000);
        interviewPage.closeGoogleFrame();

        //Fill in the Q&A section at the left part of page (like random generated answers) +
        // + check with assertion that your answers are submitted;
        Thread.sleep(1000);
        interviewPage.randomAnswerDiv();
        interviewPage.buttonSubmitResult.click();
        Thread.sleep(3000);
        Assert.assertFalse("Dont press SubmitResults button",
                interviewPage.buttonSubmitResult.isDisplayed());

        //Click on "Resend email" + check it with assertion;
        interviewPage.buttonResendEmail.click();
        Thread.sleep(300);
        Assert.assertTrue("Dont press ResentEmail button",
                interviewPage.buttonResendEmail.isDisplayed());

        //Check that section "Follow us" at the site footer contains the "Twitter"
        // button that leads to the correct url and has the correct icon.
        Assert.assertEquals("FacebookURL isnt correct",
                "https://www.facebook.com/Wrike", interviewPage.getFacebookURL());
        Assert.assertEquals("Facebook Image isnt correct",
                "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter", interviewPage.getFacebookImgURL());
    }
}
