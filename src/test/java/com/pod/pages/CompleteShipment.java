package com.pod.pages;

import java.time.Duration;  
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.test.wrappers.NativeBaseTest;

public class CompleteShipment extends NativeBaseTest {

	/*
	 * When TC005 is completed, page should be navigated to the homepage.
	 */
	/*
	 * public CompleteShipment() { int i = 0; while (i < 3) { threadSleep(0.2);
	 * pressBackKey(); i++; } }
	 */

	/*
	 * public CompleteShipment getShipmentDetailsFromTC002() { new
	 * TC002_GetShipmentDetails().getShipmentDetails(); return this; }
	 */

	public CompleteShipment cantComplete() {
		System.out.println("Can't complete scenario running...");
		threadSleep(15);
		String xpath = "//android.view.ViewGroup[contains(@resource-id,'staticImage')]";
		List<WebElement> stops = driver.findElements(By.xpath(xpath));
		int sizeOfStops = stops.size()-1;
		int endStopIsPresent = 0;

		if (sizeOfStops / 2 == 1) {
			sizeOfStops--;
			System.out.println("Decreased size : " + sizeOfStops);
			System.out.println("Size of stops : " + sizeOfStops);
		} else {
			endStopIsPresent = 1;
			System.out.println("Size of stops : " + sizeOfStops);
			System.out.println("End stop is present");
		}
		

		for (int i = 1; i <= sizeOfStops; i += 2) {
			if (i != sizeOfStops && i < sizeOfStops) {
				stops = driver.findElements(By.xpath(xpath));
				System.out.println("i = " + i);
				if (i==sizeOfStops-1 && endStopIsPresent == 1) {
					stops.get(i).click();
					stops.get(sizeOfStops).click();
					System.out.println("Clicked arrow");
				} else {
					stops.get(i).click();
					System.out.println("Clicked icon");
				}

				clickByXpath("//*[@resource-id='image2']");
				threadSleep(20);
				clickByXpath("//*[@resource-id='actionButton2$caption']");
				clickById("android:id/button1");
				threadSleep(2);
				clickById("android:id/button1");

				System.out.println("Size of stops : " + sizeOfStops);
				
				threadSleep(30);
				pressBackKey();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				wait.until(
						ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='Shipment Details']"))));
				System.out.println("Loop i=" + i + " ended");

				
			}
		}
		return this;
	}

	public void enterCustomerNameAndSign() {
		threadSleep(23);
		clickByXpath("//*[@text='Name']");
		enterByXpath("//*[@text='Name']", "Test Name");
		pressBackKey();
		clickByXpath("//*[@text='Click here to Sign']");
		if (driver.findElement(By.xpath("//*[@text='Click here to Sign']")).isDisplayed()) {
			clickByXpath("//*[@text='Click here to Sign']");
		}
		waitForElementToBePresent("//*[@resource-id='RyersonPOD.Signature_New_Native']");
		WebElement sign = driver.findElement(By.xpath("//*[@resource-id='RyersonPOD.Signature_New_Native']"));
		appiumSwipeAction(sign, "right");
		driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='container14']")).get(2).click();
		clickByXpath("//*[@resource-id='android:id/button1']");

	}

	@Test
	public void sign() {
		System.out.println("Sign");
		
		  WebElement sign = driver.findElement(By.xpath(
		  "//*[@resource-id='RyersonPOD.Signature_New_Native']"));
		  appiumSwipeAction(sign, "right");
		 

		System.out.println(driver.getContextHandles());

		Set<String> context = driver.getContextHandles();
		driver.context((String) context.toArray()[1]);

		System.out.println(driver.getContext());
		//driver.context("WEBVIEW_myapp.ryersonpod");

		System.out.println(driver.getContext());

		threadSleep(2);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	}

	public CompleteShipment completeAllStops() {
		System.out.println("Complete all stops scenario running...");
		threadSleep(1);
		String xpath = "//android.view.ViewGroup[contains(@resource-id,'staticImage')]";
		List<WebElement> stops = driver.findElements(By.xpath(xpath));
		int sizeOfStops = stops.size();
		int endStopIsPresent = 0;

		if (sizeOfStops % 2 == 0) {
			sizeOfStops--;
			System.out.println("Decreased size : " + sizeOfStops);
		} else {
			endStopIsPresent = 1;
			System.out.println("End stop is present");
		}

		for (int i = 1; i <= sizeOfStops; i++) {
			if (i != sizeOfStops && i < sizeOfStops) {
				stops = driver.findElements(By.xpath(xpath));
				System.out.println("i = " + i);
				if (sizeOfStops - i == 2 && endStopIsPresent == 1) {
					stops.get(sizeOfStops - 1).click();
					System.out.println("Clicked arrow");
				} else {
					stops.get(i).click();
					System.out.println("Clicked icon");
				}
				clickByXpath("//*[@text='Complete Stop']");
				clickByXpath("//*[@text='OK']");
				enterCustomerNameAndSign();
				sizeOfStops--;
				System.out.println("Size of stops : " + sizeOfStops);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(
						ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='Shipment Details']"))));
				System.out.println("Loop i=" + i + " ended");

				threadSleep(25);
			}
		}
		/*
		 * if(endStopIsPresent==1) { System.out.println("End stop is present"); stops =
		 * driver.findElements(By.xpath(xpath)); System.out.println("Size of stops: " +
		 * stops.size()); stops.get(stops.size()).click();
		 * clickByXpath("//*[@text='Complete Stop']"); clickByXpath("//*[@text='OK']");
		 * enterCustomerNameAndSign(); System.out.println("Size of stops : " +
		 * sizeOfStops); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(60)); wait.until(
		 * ExpectedConditions.visibilityOf(driver.findElement(By.
		 * xpath("//*[@text='Shipment Details']")))); }
		 */
		return this;
	}

	public CompleteShipment clickCompleteShipment() {
		clickByXpath("//*[@text='Complete Shipment']");
		clickByXpath("//*[@resource-id='android:id/button1']");
		clickByXpath("//*[@resource-id='android:id/button1']");

		return this;
	}
}
