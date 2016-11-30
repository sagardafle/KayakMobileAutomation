package Test;

import org.testng.annotations.BeforeMethod;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestAppium {

	WebDriver driver;
	
	
	@Test
	public void setUp() throws Exception {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android deviceName desired capability. Set it Android Emulator.
		capabilities.setCapability("deviceName", "emulator-5554");

		// Set browserName desired capability. It's Android in our case here.

		// Set android platformVersion desired capability. Set your emulator's
		// android version.
		capabilities.setCapability("platformVersion", "5.1");

		// Set android platformName desired capability. It's Android in our case
		// here.
		capabilities.setCapability("platformName", "Android");

		// Set android appPackage desired capability. It is
		// com.android.calculator2 for calculator application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appPackage", "com.kayak.android");

		// Set android appActivity desired capability. It is
		// com.android.calculator2.Calculator for calculator application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appActivity", "com.facebook.FacebookActivity");

		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch calculator app in emulator.
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		closeButton();
		clickLooksGoodBtn();
		checkIfHomeScreen();
		System.out.println("*--*--*-- Current screen orientation Is : " + ((AppiumDriver) driver).getOrientation());
		((AppiumDriver) driver).rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		//countUIElements();
		driver.quit();

	}

//	private void countUIElements() {
//	    List<WebElement> elements = ( driver).findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
//	    if(elements.size()>0)System.out.println(elements);
//		
//	}

	private void clickLooksGoodBtn() {
		String looksGoodBtn = "android:id/button1";
		WebElement looksGoodView = driver.findElement((By.id(looksGoodBtn)));
		if(looksGoodView.isDisplayed()){
			System.out.println("LooksGood present");
			looksGoodView.click();
		} else{
			System.out.println("LooksGood absent");
		}
	}
	
	

	

	private void checkIfHomeScreen() {
		String homeScreenToolbar = "com.kayak.android:id/toolbar";
		WebElement homeToolBar = driver.findElement((By.id(homeScreenToolbar)));
		if(homeToolBar.isDisplayed()){
			System.out.println("HomeScree present");
		} else{
			System.out.println("HomeScree absent");
		}		
	}

	private void closeButton() {
		String crossimgbtn = "com.kayak.android:id/closeBtn";
		WebElement crsbtn = driver.findElement((By.id(crossimgbtn)));
		if(crsbtn.isDisplayed()){
			System.out.println("Crossbtn present");
			crsbtn.click();
			} else{
				System.out.println("Crossbtn absent");
			}
		}
}