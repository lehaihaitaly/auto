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

    public void login(String mail, String pwd) throws Exception {
        email = driver.findElementById("m_login_email");
        email.sendKeys(mail);
        password = driver.findElementById("m_login_password");
        password.sendKeys(pwd);
        loginBtn = driver.findElementByName("login");
        loginBtn.click();
        Thread.sleep(5000);
    }

    public void continueLogin(){
        continueBtn = driver.findElementByName("__CONFIRM__");
        continueBtn.click();
    }


}
