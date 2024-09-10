package com.pod.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.test.wrappers.NativeBaseTest;

public class GetShipmentDetails extends NativeBaseTest {

	public GetShipmentDetails enterShipmentID(String shipmentID) {
		clickByXpath("//android.widget.EditText");
		enterByXpath("//android.widget.EditText", shipmentID);
		Assert.assertTrue(shipmentID.length() == 8, "shipmentID should be 8 digits");
		return this;
	}

	public GetShipmentDetails clickGetShipmentDetails() {

		clickByXpath("//android.widget.TextView[@text='Get shipment details']");
		waitForElementToBePresent("//android.view.View[@resource-id='RyersonPOD.Shipment_DetailNative$headerTitle']");
		try {
			WebElement confirmAssignment = driver.findElement(By.xpath("//android.widget.TextView[@text='Shipment Found: Confirm Assignment']"));
			if(confirmAssignment.isDisplayed())
				clickByXpath("android:id/button1");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}

	public GetShipmentDetails verifyTest() {
		Assert.assertEquals("Shipment Details",
				driver.findElement(
						By.xpath("//android.view.View[@resource-id='RyersonPOD.Shipment_DetailNative$headerTitle']"))
						.getText());
		return this;
	}

}
