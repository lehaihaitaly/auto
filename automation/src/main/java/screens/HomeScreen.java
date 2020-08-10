package screens;

import baseScreen.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends ScreenBase {
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        System.out.println(driver.getSessionId());
    }
    @AndroidFindBy(id="com.todoist:id/fab")
    public WebElement addTaskIcon;
    @AndroidFindBy(id="android:id/message")
    public WebElement taskContent;
    @AndroidFindBy(id="android:id/button1")
    public WebElement insertBtn;
    @AndroidFindBy(id="android:id/summary")
    public WebElement summaryTxt;

    public void addTask(String content) throws Exception{
        addTaskIcon.click();
        Thread.sleep(4000);
        taskContent.sendKeys(content);
        Thread.sleep(4000);
        insertBtn.click();
        summaryTxt.click();
        Thread.sleep(4000);


    }



}
