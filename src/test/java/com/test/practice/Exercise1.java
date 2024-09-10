package com.test.practice;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.test.wrappers.NativeBaseTest;

public class Exercise1 extends NativeBaseTest{
	
	@Test
	public void acceptDialogbox()
	{
		clickByAccessibilityId("App");
		clickByAccessibilityId("Alert Dialogs");
		
		clickById("io.appium.android.apis:id/two_buttons2");
		clickById("android:id/button1");
	}
	
	@Test
	public void listDialog()
	{
		clickByAccessibilityId("App");
		clickByAccessibilityId("Alert Dialogs");
		
		clickByAccessibilityId("List dialog");
		clickByXpath("//android.widget.TextView[@text=\"Command one\"]");
		
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
		    "x", 600,
		    "y", 600
		));
	}
	
	@Test
	public void radioButtons()
	{
		clickByAccessibilityId("App");
		clickByAccessibilityId("Alert Dialogs");
		
		clickById("io.appium.android.apis:id/radio_button");
		clickByXpath("//android.widget.CheckedTextView[@text=\"Satellite\"]");
		clickById("android:id/button1");
		threadSleep(2);
	}
	

}
