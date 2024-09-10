package com.pod.test;

import org.testng.annotations.Test; 

import com.pod.pages.DamageReports;
import com.test.wrappers.NativeBaseTest;

public class TC010_AddShipment_DamageReports extends NativeBaseTest{
	
	@Test
	public void damageReports()
	{
		System.out.println("TC010_AddShipment_DamageReports execution started...");
		
		/*
		 * new GetShipmentDetails() .enterShipmentID("22286598")
		 * .clickGetShipmentDetails(); //.verifyTest();
		 * 
		 * new AddShipmentGetShipmentDetails() .clickAddShipment()
		 * .enterShipmentID("23048121") .clickGetShipmentDetails();
		 * 
		 * new StartShipment() .addOnClickStartShipmentButton() .clickConfirmShipment();
		 * //.verifyTest();
		 */		
		new DamageReports()
		.selectStop()
		.clickHandlingUnits()
		.clickDamageReports()
		.selectDamageType()
		.addPhoto()
		.navigateToShipmentDetails();
		//.verifyTest();
		
		System.out.println("TC010_AddShipment_DamageReports execution ended...");
	}
	
}
