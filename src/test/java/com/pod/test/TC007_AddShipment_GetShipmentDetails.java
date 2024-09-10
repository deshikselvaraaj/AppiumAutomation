package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.AddShipmentGetShipmentDetails;
import com.test.wrappers.NativeBaseTest;

public class TC007_AddShipment_GetShipmentDetails extends NativeBaseTest{
	
	@Test
	public void addShipment_GetShipmentDetails()
	{
		System.out.println("TC007_AddShipment_GetShipmentDetails execution started...");
		new AddShipmentGetShipmentDetails()
		.getShipmentDetails("23048171")
		.clickAddShipment()
		.enterShipmentID("23048121")
		.clickGetShipmentDetails();
		System.out.println("TC007_AddShipment_GetShipmentDetails execution ended...");
	}

}
