package com.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.wrappers.NativeBaseTest;

import io.appium.java_client.AppiumBy;

public class MobileGestures extends NativeBaseTest{
	
	@Test
	public void longPress()
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement longPressElement = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(longPressElement);
		
		
	}
	
	@Test
	public void scroll()
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		appiumScrollAndClickAction("WebView");
	}
	
	@Test
	public void swipe()
	{
		clickByXpath("//android.widget.TextView[@content-desc=\"Views\"]");
		clickByXpath("//android.widget.TextView[@content-desc=\"Gallery\"]");
		clickByAccessibilityId("1. Photos");
		WebElement firstImage = driver.findElement(By.xpath("//(android.widget.ImageView)[1]"));
		Assert.assertEquals(firstImage.getAttribute("focusable"),"true");
		appiumSwipeAction(firstImage,"left");
		Assert.assertEquals(firstImage.getAttribute("focusable"),"false");
	}
	
	@Test
	public void dragAndDrop()
	{
		clickByXpath("//android.widget.TextView[@content-desc=\"Views\"]");
		clickByXpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]");
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		dragAndDropAction(source, 800, 800);
		Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");
	}

}
