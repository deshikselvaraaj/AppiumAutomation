package com.k2forms.pages;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.wrappers.NativeBaseTest;

public class CreateForm extends NativeBaseTest {

	@Test
	public void createFormStep1() {

		clickByXpath("//android.widget.TextView[@text=\"Create Form\"]");

		enterByXpath(
				"//android.view.ViewGroup[contains(@resource-id,'layoutGrid6$row0$column1')]//following-sibling::android.widget.EditText",
				"Engineer");
		clickByXpath(
				"//android.view.ViewGroup[contains(@resource-id,'layoutGrid6$row0$column1')]//following-sibling::android.widget.EditText");

		clickByXpath("//*[@text='Type *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Type");

		clickByXpath("//*[@text='Source *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Source");

		clickByXpath("//*[@text='Nominal wall tickness *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Sample");

		enterByXpath("//*[@text='Begin station *']//following-sibling::android.widget.EditText", "Chennai");
		clickByXpath("//*[@text='Begin station *']//following-sibling::android.widget.EditText");
		pressBackKey();
		enterByXpath("//*[@text='End station *']//following-sibling::android.widget.EditText", "Salem");
		clickByXpath("//*[@text='End station *']//following-sibling::android.widget.EditText");
		pressBackKey();

		appiumScrollAction("SMYS *");
		enterByXpath("//*[@text='SMYS *']//following-sibling::android.widget.EditText", "Test SMYS");
		clickByXpath("//*[@text='SMYS *']//following-sibling::android.widget.EditText");
		pressBackKey();

		clickByXpath("//*[@text='Pipe OD *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("PipeOD");

		appiumScrollAction("Condition of coating *");
		clickByXpath("//*[@text='Condition of coating *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Good");

		clickByXpath("//*[contains(@text,'Exposed typing coating type')]//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Paint");

		appiumScrollAction("ExposedTypingCoatingType");
		clickByXpath("//*[@resource-id='radio-button-Wax_Type']");

		clickByXpath("//*[@resource-id='switch1']");

		appiumScrollAction("Is mail sent");
		clickByXpath("//*[@resource-id='checkBox1']");

		for (int i = 0; i < 5; i++)
			appiumSwipeAction(driver.findElement(By.xpath("//*[@resource-id='rangeSlider1$rightMarker']")), "right");

		appiumScrollAction("Transition coating type *");
		clickByXpath("//*[@text='Transition coating type *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Paint");

		clickByXpath("//*[@text='Type of transition *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Air to soil");

		appiumScrollAction("Condition of coating transition *");
		clickByXpath("//*[@text='Condition of coating transition *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Fair");

		appiumScrollAction("Corrosion observed *");
		clickByXpath("//*[@text='Corrosion observed *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Pitting");

		clickByXpath("//*[@text='Location *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Chennai");

		appiumScrollAction("Deepest pit depth *");
		enterByXpath("//*[@text='Deepest pit depth *']//following-sibling::android.widget.EditText", "65");
		clickByXpath("//*[@text='Deepest pit depth *']//following-sibling::android.widget.EditText");
		pressBackKey();
		enterByXpath("//*[@text='Lengthof pitting area *']//following-sibling::android.widget.EditText", "70");
		clickByXpath("//*[@text='Lengthof pitting area *']//following-sibling::android.widget.EditText");
		pressBackKey();

		appiumScrollAction("Description *");
		enterByXpath("//*[@text='Description *']//following-sibling::android.widget.EditText", "Test Desc");
		clickByXpath("//*[@text='Description *']//following-sibling::android.widget.EditText");
		pressBackKey();

		appiumScrollAction("Organisation *");
		clickByXpath("//*[@text='Organisation *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Mendix");

		appiumScrollAction("Approver Name *");
		clickByXpath("//*[@text='Approver Name *']//following-sibling::android.view.ViewGroup");
		appiumScrollAndClickAction("Approver1");

		appiumScrollForward();
		clickByXpath("//android.widget.TextView[@text=\"Next\"]");

	}

	@Test
	public void createFormStep2() {

		enterByXpath("//*[@text='Inspector Name *']//following-sibling::android.widget.EditText", "Salem");

		clickByXpath("//*[@text='Inspection date *']//following-sibling::android.view.ViewGroup");
		clickByXpath("//*[@text='OK']");

		WebElement sign = driver.findElement(By.xpath("//android.widget.Image[@index=\"0\"]"));
		appiumSwipeAction(sign, "down");
		appiumSwipeAction(sign, "up");

		clickByXpath("//android.widget.Button[@text='Next']");
	}

	@Test
	public void createFormStep3() throws Exception {
		
		clickByXpath("//*[@text='Upload Document']");

		String filePath = "/sdcard/download/sample.pdf";
		driver.pushFile(filePath, new File(System.getProperty("user.dir") + "\\src\\test\\sample.pdf"));

		clickById("com.android.documentsui:id/icon_thumb");

		threadSleep(2);
		clickById("android:id/button1");
		threadSleep(1);
		clickByXpath("//*[@text='Save']");
		clickById("android:id/button1");
	}


}
