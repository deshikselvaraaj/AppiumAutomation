package com.pod.pages;

import com.test.wrappers.NativeBaseTest;

public class LogOut extends NativeBaseTest{
	
	public LogOut clickMyProfile()
	{
		threadSleep(5);
		clickByXpath("//*[@text='My Profile']");
		return this;
	}
	
	public LogOut clickLogOut()
	{
		clickByXpath("//android.view.ViewGroup[@resource-id='actionButton2']");
		clickByXpath("//*[@text='YES']");
		return this;
	}

}
