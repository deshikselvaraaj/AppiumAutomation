package com.pod.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.test.wrappers.NativeBaseTest;

public class UnassignShipment extends NativeBaseTest {
	
	public UnassignShipment gotoAddOnShipment()
	{
		clickByXpath("//*[@text='Go to Add-on Shipment']");
		return this;
	}

	public UnassignShipment clickHereToUnassignShipment() {
		threadSleep(2);
		clickByXpath("//*[@text='Click here to Unassign Shipment']");
		return this;
	}

	public UnassignShipment enterReason(String reason) {
		waitForElementToBePresent("//android.widget.TextView[contains(@text,'Enter Comments') or contains(@text,'Enter Reason')]");
		driver.findElements(By.xpath("//android.widget.EditText")).get(1).click();
		driver.findElements(By.xpath("//android.widget.EditText")).get(1).sendKeys("Test");
		pressBackKey();
		return this;
	}
	
	public UnassignShipment clickProceed()
	{
		threadSleep(2);
		clickByXpath("//*[@text='Proceed']");
		try {
			if(driver.findElement(By.xpath("//*[@text='Proceed']")).isDisplayed())
				clickByXpath("//*[@text='Proceed']");
			}catch (Exception e) {
				System.err.println(e);
			}
		return this;
	}
	
	public UnassignShipment acceptConfirmation()
	{
		clickByXpath("//*[@resource-id='android:id/button1']");
		threadSleep(10);
		return this;
	}
	
	public UnassignShipment verifyTest()
	{
		waitForElementToBePresent("//*[@resource-id='text4']");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@resource-id='text4']")).getText(), "Incomplete Shipments");
		//System.out.println(driver.findElement(By.xpath("//*[@resource-id='text4']")).getText());
		return this;
	}
	
}
