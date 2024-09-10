package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.StartShipment;
import com.test.wrappers.NativeBaseTest;

public class TC008_AddShipment_StartShipment extends NativeBaseTest{
	
	@Test
	public void addShipment_startShipment()
	{
		System.out.println("TC008_AddShipment_StartShipment execution started...");
		new StartShipment()
		.clickStartShipmentButton()
		.clickConfirmShipment()
		//.verifyTest();
		.waitForShipmentToStart();
		System.out.println("TC008_AddShipment_StartShipment execution ended...");
	}

}
