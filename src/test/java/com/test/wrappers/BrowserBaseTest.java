package com.test.wrappers;

import java.net.MalformedURLException;  
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeTest
	public void tearUp() throws MalformedURLException {
		// Automatically start the appium server
		service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
		// service.start();

		// Seeting up the emulator
		UiAutomator2Options options = new UiAutomator2Options();
		
		  options.setDeviceName("Emulator Pixel 3A");
		  options.setChromedriverExecutable(System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		  options.setCapability("browserName", "Chrome");
		 
		
			/*
			 * options.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
			 * options.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			 * options.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
			 * System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			 */
		  
		  
		// Creating Android driver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	public void threadSleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clickById(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void enterByXpath(String xpath, String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}

	public void enterById(String id, String data) {
		driver.findElement(By.id(id)).sendKeys(data);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		// service.stop();
	}

}
