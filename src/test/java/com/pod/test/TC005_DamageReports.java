package com.pod.test;

import org.testng.annotations.Test;

import com.pod.pages.DamageReports;
import com.test.wrappers.NativeBaseTest;

public class TC005_DamageReports extends NativeBaseTest{
	
	@Test
	public void damageReports()
	{
		System.out.println("TC005_DamageReports execution started...");
		/*
		 * new TC002_GetShipmentDetails() .getShipmentDetails("23042660"); new
		 * TC003_StartShipment() .startShipment();
		 */
		new DamageReports()
		.selectStop()
		.clickHandlingUnits()
		.clickDamageReports()
		.selectDamageType()
		.addPhoto()
		.navigateToShipmentDetails();
		
		System.out.println("TC005_DamageReports execution ended...");
	}
	
}
