package com.browser.web;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.test.wrappers.BrowserBaseTest;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class OpenApp extends BrowserBaseTest{

	@Test
	public void openApp()
	{
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("facebook");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
}
