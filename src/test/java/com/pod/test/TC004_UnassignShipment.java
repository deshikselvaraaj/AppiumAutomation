package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.UnassignShipment;
import com.test.wrappers.NativeBaseTest;

public class TC004_UnassignShipment extends NativeBaseTest {

	@Test
	public void unassignShipment() {
		System.out.println("TC004_UnassignShipment execution started...");
		new UnassignShipment()
		.clickHereToUnassignShipment()
		.enterReason("Test Reason")
		.clickProceed()
		.acceptConfirmation()
		.verifyTest();
		System.out.println("TC004_UnassignShipment execution ended...");
	}
}
