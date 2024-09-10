package com.k2forms.pages;

import org.testng.annotations.Test;

import com.test.wrappers.NativeBaseTest;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LogIn extends NativeBaseTest {

	@Test
	public void logIn()
	{
		
		enterByXpath("//android.widget.EditText[@text=\"Username\"]", "Requestor");
		clickByXpath("//android.widget.EditText[@text=\"Password\"]");
		enterByXpath("//android.widget.EditText[@text=\"Password\"]", "Admin@1");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//clickByXpath("//android.widget.TextView[@text=\"Login\"]");

	}
}
