package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.LogOut;

public class TC011_LogOut {
	
	@Test
	public void logOut()
	{
		System.out.println("TC011_LogOut execution started...");
		new LogOut()
		.clickMyProfile()
		.clickLogOut();
		System.out.println("TC011_LogOut execution ended...");
	}

}
