package com.generalstore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.wrappers.NativeBaseTest;


public class VerifyTotalAmount extends NativeBaseTest {
	

	public VerifyTotalAmount verfyTotalAamount()
	{
	List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	int totalProduct = products.size();
	double totalAmount = 0;

	for (int i = 0; i < totalProduct; i++) {
		Double price = Double.parseDouble(products.get(i).getText().substring(1));
		totalAmount = totalAmount + price;
	}

	String actual = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText()
			.substring(2);
	String expected = String.valueOf(totalAmount);

	Assert.assertTrue(actual.contains(expected), "Actual : " + actual + "\tExpected : " + expected);
	
	return this;
	}
	
	public VerifyTotalAmount clickProceed()
	{	
	longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
	clickById("android:id/button1");
	clickByClassName("android.widget.CheckBox");
	clickById("com.androidsample.generalstore:id/btnProceed");
	
	threadSleep(3);
	/*
	 * for (String context : driver.getContextHandles()) {
	 * System.out.println(context); }
	 * 
	 * driver.context("WEBVIEW_com.androidsample.generalstore"); threadSleep(5);
	 * driver.findElement(By.name("q")).sendKeys("facebook"); threadSleep(3);
	 * driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	 * 
	 * threadSleep(10);
	 */
	
	return this;
	}

}
