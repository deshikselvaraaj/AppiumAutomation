package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.GetShipmentDetails;
import com.test.wrappers.NativeBaseTest;

public class TC002_GetShipmentDetails extends NativeBaseTest {

	@Test
	public void getShipmentDetails()
	{
		System.out.println("TC002_GetShipmentDetails execution started...");
		new GetShipmentDetails()
		.enterShipmentID("23042818")
		.clickGetShipmentDetails()
		.verifyTest();
		System.out.println("TC002_GetShipmentDetails execution ended...");
	}
	
	public void getShipmentDetails(String shipmentID)
	{
		System.out.println("TC002_GetShipmentDetails method call started...");
		new GetShipmentDetails()
		.enterShipmentID(shipmentID)
		.clickGetShipmentDetails()
		.verifyTest();
		System.out.println("TC002_GetShipmentDetails method call ended...");
	}
}
