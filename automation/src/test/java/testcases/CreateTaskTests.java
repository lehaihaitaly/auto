package testcases;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.FacebookScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import java.net.MalformedURLException;
import baseTest.*;
import static baseScreen.ScreenBase.switchView;

public class CreateTaskTests extends BaseTest {
    LoginScreen login;
    FacebookScreen facebook;
    HomeScreen home;
    String task;
    String mail;
    String pwd;

    @BeforeClass
    public void init() throws MalformedURLException {
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
        switchView();
        facebook.login(mail,pwd);
        Thread.sleep(5000);
        facebook.continueLogin();
        switchView();
        home.addTask(task);
        Assert.assertTrue(driver.getPageSource().contains(task));

    }
}
