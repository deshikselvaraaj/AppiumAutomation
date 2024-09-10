package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.CompleteShipment;
import com.test.wrappers.NativeBaseTest;

public class TC006_CompleteShipment extends NativeBaseTest {

	public void completeAllStops() {
		System.out.println("completeAllStops test running...");
		new TC002_GetShipmentDetails().getShipmentDetails("23042660");
		new TC003_StartShipment().startShipment();
		new CompleteShipment().completeAllStops().clickCompleteShipment();
	}

	@Test
	public void dontCompleteAllStops() {
		System.out.println("TC006_CompleteShipment execution started...");
		System.out.println("dontCompleteAllStops test running...");
		threadSleep(5);
		new TC002_GetShipmentDetails()
			.getShipmentDetails("23042660");
		new TC003_StartShipment()
			.startShipment();
		new CompleteShipment()
			.cantComplete()
			.clickCompleteShipment();
		System.out.println("dontCompleteAllStops test ended...");
		System.out.println("TC006_CompleteShipment execution ended...");
		
	}

}
