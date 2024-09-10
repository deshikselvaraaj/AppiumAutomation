package com.pod.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.NoSuchElementException;

import com.test.wrappers.NativeBaseTest;

public class DamageReports extends NativeBaseTest {


	public DamageReports selectStop() {
		threadSleep(10);
		String xpath = "//android.view.ViewGroup[contains(@resource-id,'staticImage')]";
		/*
		 * for(int i=0;i<3;i++) { driver.getOrientation(); threadSleep(40); }
		 */
		waitForElementToBeClickable(xpath, 120);
		driver.findElements(By.xpath(xpath)).get(1).click();
		System.out.println("Clicked " + xpath);
		return this;
	}


	public DamageReports clickHandlingUnits() {
		clickByXpath("//*[@text='Handling Units']");
		return this;
	}

	public DamageReports clickDamageReports() {
		clickByXpath("//*[@text='Damage Reports']");
		return this;
	}

	public DamageReports selectDamageType()
	{
		clickByXpath("//*[@resource-id='dropDown3$openButton']");
		clickByXpath("//*[@text='Wet']");
		return this;
	}
	
	
	public DamageReports addPhoto()
	{
		clickByXpath("//*[@text='Add Photo']");
		threadSleep(2);
		try {
		if(driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).isDisplayed())
			clickById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
		}catch (NoSuchElementException e) {
			System.err.println(e);
		}
		clickByXpath("//android.widget.ImageView[@content-desc='Shutter']");
		try {
			clickByXpath("//android.widget.ImageButton[@content-desc='Done']");
			clickById("com.sec.android.app.camera:id/done_button");
		} catch (NoSuchElementException e) {
			System.err.println(e);		}
		return this;
	}
	
	/*
	 * public DamageReports verifyTest() {
	 * waitForElementToBePresent("//*[@text='Uploaded date']");
	 * Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Uploaded date']")).
	 * isDisplayed(), "The photo is not uploaded"); return this; }
	 */
	
	public DamageReports navigateToShipmentDetails()
	{
		threadSleep(2);
		pressBackKey();
		threadSleep(2);
		pressBackKey();
		return this;
	}
	
}
