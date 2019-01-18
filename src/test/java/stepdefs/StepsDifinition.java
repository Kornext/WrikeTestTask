//package stepdefs;
//
//import cucumber.api.java.ru.Когда;
//import cucumber.api.java.ru.Тогда;
//import pages.BasePage;
//import pages.HomePage;
//import pages.InterviewPage;
//
//public class StepsDifinition {
//
//    BasePage basePage = new BasePage();
//    HomePage homePage = new HomePage();
//    InterviewPage interviewPage = new InterviewPage();
//
//
//    @Когда("^пользователь открывает URL \"([^\"]*)\"$")
//    public void пользователь_открывает_URL(String arg1) throws Throwable {
//        //homePage.openPage("wrike.com");
//    }
//
//    @Когда("^нажимает на кнопку Get started for free$")
//    public void нажимает_на_кнопку_Get_started_for_free() throws Throwable {
//        //homePage.buttonClickGetStartedForFree();
//    }
//
//    @Тогда("^появляется поле для ввода емейла$")
//    public void появляется_поле_для_ввода_емейла() throws Throwable {
//        //Assert.assertTrue(homePage.checkInputField());
//    }
//
//    @Когда("^пользователь заполняет поле Enter Your Business email$")
//    public void пользователь_заполняет_поле_Enter_Your_Business_email() throws Throwable {
//        //homePage.inputEmail();
//    }
//
//    @Когда("^нажимает на кнопку Create Wrike Account$")
//    public void нажимает_на_кнопку_Create_Wrike_Account() throws Throwable {
//        //homePage.buttonClickGetStartedForFree();
//    }
//
//    @Тогда("^открывается страница \"([^\"]*)\"$")
//    public void открывается_страница(String arg1) throws Throwable {
//        //
//    }
//
//    @Когда("^пользователь заполняет случайным образом поля$")
//    public void пользователь_заполняет_случайным_образом_поля() throws Throwable {
//        //interviewPage.randomAnswerDiv();
//    }
//
//    @Когда("^нажимает на кнопку Submit Result$")
//    public void нажимает_на_кнопку_Submit_Result() throws Throwable {
//        //interviewPage.buttonSubmitResultClick();
//    }
//
//    @Тогда("^проверяется, что ответы приняты$")
//    public void проверяется_что_ответы_приняты() throws Throwable {
//        //Assert.assertTrue(interviewPage.isSubmitButtonClickable());
//    }
//
//    @Когда("^пользователь нажимает на кнопку \\(Resend email\\)$")
//    public void пользователь_нажимает_на_кнопку_Resend_email() throws Throwable {
//        //interviewPage.buttonSubmitResultClick();
//    }
//
//    @Тогда("^проверяем, что сообщение отправилось$")
//    public void проверяем_что_сообщение_отправилось() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    }
//}
