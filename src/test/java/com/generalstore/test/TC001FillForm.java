package com.generalstore.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generalstore.pages.FillForm;
import com.test.wrappers.NativeBaseTest;


public class TC001FillForm extends NativeBaseTest{
	
	
	@Test(dataProvider = "getData")
	public void tc001FillForm(String name, String gender, String country)
	{
		new FillForm().fillForm(name,gender,country);
		
	}
	
	@DataProvider
	public Object[][]  getData()
	{
		return new Object[][] {{"Subha", "Female", "Argentina"}};
	}
	
}
