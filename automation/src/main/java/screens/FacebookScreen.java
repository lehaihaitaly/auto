package screens;

import baseScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FacebookScreen extends ScreenBase {
    private WebElement email;
    private WebElement password;
    private WebElement continueBtn;
    private WebElement loginBtn;
    private String facebookTxt = "Hãy đăng nhập vào tài khoản Facebook của bạn để kết nối với Todoist";
    private String faceContinueTXT = "Bạn có muốn tiếp tục không?";
    public FacebookScreen(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String mail, String pwd) throws Exception {
        email = driver.findElementById("m_login_email");
        email.sendKeys(mail);
        password = driver.findElementById("m_login_password");
        password.sendKeys(pwd);
        loginBtn = driver.findElementByName("login");
        loginBtn.click();
        Thread.sleep(5000);
    }
    public void verifyThatFacebookScreenIsDisplayed(){
        Assert.assertTrue(driver.getPageSource().contains(facebookTxt));
    }

    public void verifyFaceBookContinueScreenIsDisplayed(){
        Assert.assertTrue(driver.getPageSource().contains(faceContinueTXT));
    }

    public void continueLogin(){
        continueBtn = driver.findElementByName("__CONFIRM__");
        continueBtn.click();
    }


}
