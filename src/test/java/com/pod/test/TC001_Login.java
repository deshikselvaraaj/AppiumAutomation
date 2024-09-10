package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.Login;
import com.test.wrappers.NativeBaseTest;

public class TC001_Login extends NativeBaseTest {

	@Test
	public void loginTest()
	{	
		  System.out.println("TC001_Login execution started...");
		  new Login() 
		  .enterUsername("Driver10864") 
		  .enterPassword("70823") 
		  .clickSubmitButton();		 
		  System.out.println("TC001_Login execution ended...");
	}

}
