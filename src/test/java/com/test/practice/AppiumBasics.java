package com.test.practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.wrappers.NativeBaseTest;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends NativeBaseTest{

	@Test
	public void testAppium() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertTrue(alertTitle.contains("WiFi settings"), "Expected text is different from the actual test");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Bixby A52s");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();	
		
		

	}

}
