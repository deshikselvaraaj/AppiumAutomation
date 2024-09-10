package com.pod.pages;

import com.test.wrappers.NativeBaseTest;

public class Login extends NativeBaseTest {

	public Login enterUsername(String usernamer) {
		clickByXpath("//android.widget.EditText[@text='Username']");
		enterByXpath("//android.widget.EditText[@text='Username']", usernamer);
		pressBackKey();
		return this;
	}

	public Login enterPassword(String password) {
		clickByXpath("//android.widget.EditText[@text='Password']");
		enterByXpath("//android.widget.EditText[@text='Password']", password);
		pressBackKey();
		return this;
	}

	public Login clickSubmitButton() {
		clickByXpath("//android.view.ViewGroup[contains(@resource-id,'actionButton2')]");
		threadSleep(5);
		return this;
	}

}
