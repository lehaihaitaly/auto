import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class test  {
    AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public void logInTest() throws Exception {

        // TODO Auto-generated method stub
        File appDir = new File("src/main/resources");
        File app = new File(appDir, "todoist.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5X");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions",true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<AndroidElement>(url, capabilities);
        Thread.sleep(6000);


    }
    @Test
    public void test() throws Exception{
        driver.findElementById("com.todoist:id/btn_google").click();
        Thread.sleep(5000);


    }
}


    

