package com.generalstore.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.test.wrappers.NativeBaseTest;

public class FillForm extends NativeBaseTest{
	
	public void fillForm(String name, String gender, String country)
	{
		threadSleep(10);
		clickById("android:id/text1");
		appiumScrollAndClickAction(country);
		enterById("com.androidsample.generalstore:id/nameField", name);
		clickById("com.androidsample.generalstore:id/radioFemale");
		clickById("com.androidsample.generalstore:id/btnLetsShop");
		threadSleep(2);
		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText(),"Products");
		threadSleep(2);

	}
	
	public void toastMessage()
	{
		clickById("com.androidsample.generalstore:id/btnLetsShop");
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertTrue(toastMessage.contains("Please enter your name"));
	}

}
