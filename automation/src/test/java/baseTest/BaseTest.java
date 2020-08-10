package baseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import utilities.CommonUtils;

public class BaseTest {
    public AppiumDriver<MobileElement> driver;
    public  void setUp() {
        if (driver == null) {
                CommonUtils.setAndroidCapabilities();
                driver = CommonUtils.getAndroidDriver();
                System.out.println(driver.getSessionId());

        }

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
