package com.k2forms.pages;

import org.testng.annotations.Test;

import com.test.wrappers.NativeBaseTest;

public class Feedback extends NativeBaseTest {

	@Test
	public void sendFeedback() {
		//threadSleep(3);
		clickByXpath("//*[@resource-id='feedback1$button']");

		enterByXpath("//*[@text='Type your feedback here']", "Test feedback");
		clickByXpath("//*[@resource-id='feedback1$switch']");
		clickByXpath("//*[@resource-id='feedback1$send']");
		clickByXpath("//*[@resource-id='feedback1$success$ok']");
	}

}
