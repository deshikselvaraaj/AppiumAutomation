package com.generalstore.test;

import org.testng.annotations.Test;

import com.generalstore.pages.VerifyTotalAmount;
import com.test.wrappers.NativeBaseTest;

public class TC003TotalAmount extends NativeBaseTest {

	@Test
	public void tc003VerifyTotalAmount() {
		
		new VerifyTotalAmount()
		.verfyTotalAamount()
		.clickProceed();
	}

}
