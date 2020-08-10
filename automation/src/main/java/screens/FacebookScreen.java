package screens;

import baseScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FacebookScreen extends ScreenBase {
    private WebElement email;
    private WebElement password;
    private WebElement continueBtn;
    private WebElement loginBtn;
    public FacebookScreen(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        System.out.println(driver.getSessionId());

    }



    public void login(String email, String password) throws Exception {
        driver.findElementById("m_login_email").sendKeys(email);
        Thread.sleep(5000);
        driver.findElementById("m_login_password").sendKeys(password);
        Thread.sleep(5000);
        driver.findElementByName("login").click();
    }

    public void continueLogin(){
        driver.findElementByName("__CONFIRM__").click();
    }


}