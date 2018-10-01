//package pages;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//
//
//public class TestWrike extends WebDriverSetting {
//
//    @Test
//    public void firstTestCause() throws InterruptedException {
//        //Step one
//        driver.get("https://www.wrike.com/");
//
//        //Step two
//        WebElement webElement = driver.findElementByXPath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button");
//        webElement.click();
//        Thread.sleep(1000);
//
//        //Step three
//        webElement = driver.findElementByXPath("/html/body/div[4]/div/form/label[1]/input");
//        String emailRandom = org.apache.commons.lang3.RandomStringUtils.random(5, true, false);
//        emailRandom = emailRandom.toLowerCase() + "wpt@wriketask.qaa";
//        webElement.sendKeys(emailRandom);
//
//        //Step four
//        webElement = driver.findElementByXPath("/html/body/div[4]/div/form/label[2]/button");
//        webElement.click();
//        String startPageUrl = driver.getCurrentUrl();
//        Thread.sleep(3000);
//        Assert.assertNotEquals(startPageUrl, driver.getCurrentUrl());
//        Thread.sleep(4000);
//
//        //Step five (close Google frame)
//        driver.switchTo().frame(driver.findElementByXPath("/html/body/div[6]/div/iframe"));
//        webElement = driver.findElementByXPath("/html/body/c-wiz/div/div/div[2]/div[4]/span[1]/div/content/span");
//        webElement.click();
//        Thread.sleep(3000);
//
//        //Step five
//        driver.switchTo().defaultContent();
//        List<WebElement> listWebElements = new ArrayList<>();
//        listWebElements.addAll(driver.findElementsByClassName("radio"));
//        for (int i = 0; i < listWebElements.size(); i++) {
//            List<WebElement> listRadioButton = new ArrayList<>();
//            listRadioButton.addAll(listWebElements.get(i).findElements(By.className("switch__button")));
//            int count = listRadioButton.size();
//            Random rnd = new Random(System.currentTimeMillis());
//            int randomNumber = rnd.nextInt(count - 0);
//            listRadioButton.get(randomNumber).click();
//            if(listRadioButton.get(randomNumber).getText().contains("Other")) {
//                System.out.println("BINGO");
//                Thread.sleep(1000);
//                webElement = listRadioButton.get(i).findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span/input"));
//                String randomText = org.apache.commons.lang3.RandomStringUtils.random(7, true, false);
//                randomText = randomText.toLowerCase();
//                webElement.sendKeys(randomText);
//                webElement.click();
//            }
//        }
//        Thread.sleep(3000);
//        webElement = driver.findElementByXPath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button");
//        webElement.click();
//        Thread.sleep(3000);
//        Assert.assertTrue("Dont press SubmitResults button", !driver.findElementByCssSelector(".submit").isDisplayed());
//
//        //Step six
//        webElement = driver.findElementByXPath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button");
//        webElement.click();
//        Thread.sleep(3000);
//        Assert.assertTrue("Dont press ResentEmail button", driver.findElementByCssSelector(".h4 > span:nth-child(3)").isDisplayed());
//
//        //Step seven
//        String facebookURL = driver.findElementByXPath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[2]/a").getAttribute("href");
//        Assert.assertEquals("FacebookURL isnt correct", "https://www.facebook.com/Wrike", facebookURL);
//        String facebookImgURL = driver.findElementByCssSelector("li.wg-footer__social-item:nth-child(1) > a:nth-child(1) > svg:nth-child(1) > use:nth-child(1)").getAttribute("xlink:href");
//        Assert.assertEquals("Facebook Image isnt correct", "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter", facebookImgURL);
//    }
//}
