package com.pod.pages;

import org.testng.Assert;

import com.pod.test.TC002_GetShipmentDetails;
import com.test.wrappers.NativeBaseTest;

public class AddShipmentGetShipmentDetails extends NativeBaseTest {


	public AddShipmentGetShipmentDetails getShipmentDetails(String shipmentID) {
		new TC002_GetShipmentDetails().getShipmentDetails(shipmentID);
		return this;
	}

	public AddShipmentGetShipmentDetails clickAddShipment() {
		clickByXpath("//*[@text='Add Shipment']");
		return this;
	}

	public AddShipmentGetShipmentDetails enterShipmentID(String shipmentID) {
		clickByXpath("//*[@resource-id='RyersonPOD.Shipment_DetailNative_Popup']//descendant::android.widget.EditText");
		enterByXpath("//*[@resource-id='RyersonPOD.Shipment_DetailNative_Popup']//descendant::android.widget.EditText", shipmentID);
		Assert.assertTrue(shipmentID.length() == 8, "shipmentID should be 8 digits");
		return this;
	}
	
	public AddShipmentGetShipmentDetails clickGetShipmentDetails()
	{
		clickByXpath("//*[@resource-id='RyersonPOD.Shipment_DetailNative_Popup']//descendant::android.widget.TextView[@text='Get shipment details']");
		waitForElementToBePresent("//*[@text='Shipment Number']");
		return this;
	}

}
