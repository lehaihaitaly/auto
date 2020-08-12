package baseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import utilities.CommonUtils;

import java.util.Set;

import static baseScreen.ScreenBase.waitFor;

public class BaseTest {
    public AppiumDriver<MobileElement> driver;
    public  void setUp() {
        if (driver == null) {
                CommonUtils.setAndroidCapabilities();
                driver = CommonUtils.getAndroidDriver();
        }
    }
    public void switchTo(String view) throws Exception{
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains(view)){
                driver.context(view);
            }
        }
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
