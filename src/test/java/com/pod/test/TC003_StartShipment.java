package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.StartShipment;
import com.test.wrappers.NativeBaseTest;

public class TC003_StartShipment extends NativeBaseTest{

	@Test
	public void startShipment()
	{
		System.out.println("TC003_StartShipment execution started...");
		new StartShipment()
		.clickStartShipmentButton()
		.clickConfirmShipment()
		.verifyTest();
		System.out.println("TC003_StartShipment execution ended...");
	}
}
