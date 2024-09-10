package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.UnassignShipment;
import com.test.wrappers.NativeBaseTest;

public class TC009_AddShipment_UnassignShipment extends NativeBaseTest{
	
	@Test
	public void addShipment_UnassignShipment() {
		System.out.println("TC009_AddShipment_UnassignShipment execution started...");
		new UnassignShipment()
		.gotoAddOnShipment()
		.clickHereToUnassignShipment()
		.enterReason("Test Reason")
		.clickProceed()
		.acceptConfirmation()
		.clickHereToUnassignShipment()
		.enterReason("Test Reason")
		.clickProceed()
		.acceptConfirmation()
		.verifyTest();
		System.out.println("TC009_AddShipment_UnassignShipment execution ended...");
	}

}
