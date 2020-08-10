package baseScreen;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.Set;

public class ScreenBase {
	
	
	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	//screen base constructor
	public ScreenBase(AppiumDriver<MobileElement> driver) {
		
		this.driver=driver;
	}
	public static void switchView() throws Exception{
		Thread.sleep(10000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("WEBVIEW_com.todoist")){
				driver.context("WEBVIEW_com.todoist");
			}
			else{
				driver.context("NATIVE_APP");

			}
		}
	}
	
	public void hideKeyboard() {
		
		
		driver.hideKeyboard();
		
		
	}
	
	public void enter() {
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
	}
	
	

}
