package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CommonUtils {
    private static AppiumDriver<MobileElement> driver;
    private static URL serverUrl;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static void setAndroidCapabilities() {
        File appDir = new File("src/main/resources");
        File app = new File(appDir, "todoist.apk");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Note 7");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions",true);
        capabilities.setCapability("appWaitActivity","com.todoist.activity.WelcomeActivity");
    }
    public static AppiumDriver<MobileElement> getAndroidDriver() {
        try {
            serverUrl=new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver = new AndroidDriver<MobileElement>(serverUrl,capabilities);
        return driver;
    }
}
