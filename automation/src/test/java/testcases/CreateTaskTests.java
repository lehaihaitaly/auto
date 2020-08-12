package testcases;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.FacebookScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import baseTest.*;
import static constant.BaseConstant.NATIVE_VIEW;
import static constant.BaseConstant.WEB_VIEW;

public class CreateTaskTests extends BaseTest {
    LoginScreen login;
    FacebookScreen facebook;
    HomeScreen home;
    String task;
    String mail;
    String pwd;


    @BeforeClass
    public void init()  {
        task = "Project name: "+ RandomStringUtils.randomAlphabetic(8);
        mail = "ha.le@ascendcorp.com";
        pwd = "hatinh86";
        setUp();
        login = new LoginScreen(driver);
        facebook = new FacebookScreen(driver);
        home = new HomeScreen(driver);
    }
    @Test
    public void test() throws Exception{
        login.clickFacebookButton();
        switchTo(WEB_VIEW);
        facebook.verifyThatFacebookScreenIsDisplayed();
        facebook.login(mail,pwd);
        facebook.verifyFaceBookContinueScreenIsDisplayed();
        facebook.continueLogin();
        switchTo(NATIVE_VIEW);
        home.addTask(task);
        Assert.assertTrue(driver.getPageSource().contains(task));
    }
}
