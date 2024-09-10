package com.generalstore.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.wrappers.NativeBaseTest;

public class AddProductToCart extends NativeBaseTest {

	public AddProductToCart addItemToCart(String productName) {
		appiumScrollAndClickAction(productName);

		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < productCount; i++) {
			String productLabel = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();

			if (productLabel.equalsIgnoreCase(productName)) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		return this;
	}
	
	public AddProductToCart navigateToCart()
	{
		clickById("com.androidsample.generalstore:id/appbar_btn_cart");
		threadSleep(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicitWait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text" ,"Cart"));
		return this;
		
	}

}
