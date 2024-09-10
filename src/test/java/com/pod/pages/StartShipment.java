	package com.pod.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.wrappers.NativeBaseTest;

public class StartShipment extends NativeBaseTest {

	public StartShipment clickStartShipmentButton() {
		threadSleep(30);
		clickByXpath("//*[@text='Start Shipment']");
		return this;
	}
	
	public StartShipment addOnClickStartShipmentButton() {
		threadSleep(30);
		clickByXpath("//*[@text='Start Shipment']");
		return this;
	}

	public StartShipment clickConfirmShipment() {
		clickByXpath("//*[@resource-id='android:id/button1']");
		return this;
	}
	
	public StartShipment verifyTest()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='android:id/alertTitle']")));
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='android:id/alertTitle']")).getText(),"Information");
		clickByXpath("//*[@resource-id='android:id/button1']");
		return this;
	}
	
	public StartShipment waitForShipmentToStart()
	{
		waitForElementToBePresent("//*[@text='Go to Add-on Shipment']");
		threadSleep(15);
		return this;
	}
}
