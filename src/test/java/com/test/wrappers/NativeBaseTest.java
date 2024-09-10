package com.test.wrappers;

import java.io.FileInputStream; 
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class NativeBaseTest {

	// public static AppiumDriverLocalService service;
	public static AndroidDriver driver;
	protected Properties properties = new Properties();
	private static Logger logger = LogManager.getLogger();
	WebDriverWait wait;

	@BeforeSuite
	public void setup() throws MalformedURLException {

		// Load the properties file
		{
			InputStream input = null;

			try {
				input = new FileInputStream("src\\main\\resources\\config.properties");
				properties.load(input);
				logger.info("Properties file load completed.");
			} catch (IOException ex) {
				logger.error("An exception occurred in locating properties file : " + ex.getMessage());
			} finally {
				if (input != null) {
					try {
						input.close();
						logger.info("FileInputStream closed");
					} catch (IOException ex) {
						logger.error("An exception occurred in closing FileInputStream : " + ex.getMessage());
					}
				}
			}
		}

		// Automatically start the appium server
		// service = new
		// AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
		// service.start();

		// Seeting up the emulator
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(properties.getProperty("DEVICE_NAME"));
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\" + properties.getProperty("APP_NAME")
				+ ".apk");
		logger.info("Opening app " + properties.getProperty("APP_NAME"));
		if (properties.getProperty("APP_RESET").equalsIgnoreCase("false")) {
			options.noReset();
			logger.info("App reset : " + properties.getProperty("APP_RESET"));
		}
		//WebDriverManager.chromedriver().setup();
		options.setChromedriverExecutable(System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		
		logger.info("UiAUtomator2Options set.");
		
		// Creating Android driver
		String ipAddress = properties.getProperty("IP_ADDRESS");
		logger.info("IP_ADDRESS fecthed from configuration properties");
		String port = properties.getProperty("PORT");
		logger.info("PORT fecthed from configuration properties");
		
		//options.setCapability("newCommandTimeout", 130000);
		
		driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + port), options);
		logger.info("driver initialized with URL and Options.");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	public void threadSleep(double seconds) {
		try {
			logger.info("Thread sleep started for " + seconds + " seconds");
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
	}

	public void clickByXpath(String xpath) {
		logger.info("clickByXpath arguments received - Xpath : "+xpath+".");
		waitForElementToBePresent(xpath);
		driver.findElement(By.xpath(xpath)).click();
		logger.info("Clicked "+xpath + " by xpath.");

	}

	public void clickById(String id) {
		logger.info("clickById arguments received - ID : "+id+".");
		waitForElementToBePresentById(id);
		driver.findElement(By.id(id)).click();
		logger.info("Clicked "+id + " by ID.");

	}

	public void clickByAccessibilityId(String id) {
		logger.info("clickByAccessibilityId arguments received - AccessibilityId : "+id+".");
		driver.findElement(AppiumBy.accessibilityId(id)).click();
		logger.info("Clicked "+id + " by AccessibilityId.");

	}

	public void clickByClassName(String className) {
		logger.info("clickByClassName arguments received - Xpath : "+className+".");
		driver.findElement(AppiumBy.className(className)).click();
		logger.info("Clicked "+className + " by ClassName.");


	}

	public void enterByXpath(String xpath, String data) {
		logger.info("enterByXpath arguments received - Xpath : "+xpath+", Value : "+data + ".");
		waitForElementToBePresent(xpath);
		WebElement enterable = driver.findElement(By.xpath(xpath));
		enterable.clear();
		enterable.sendKeys(data);
		logger.info("Entered value " +data+ " in " +xpath +".");
	}

	public void enterById(String id, String data) {
		logger.info("enterById arguments received - Xpath : "+id+", Value : "+data + ".");
		driver.findElement(By.id(id)).sendKeys(data);
		logger.info("Entered value " +data+ " in " +id +".");
	}

	public void enterByAccessibilityId(String id, String data) {
		logger.info("enterByAccessibilityId arguments received - Xpath : "+id+", Value : "+data + ".");
		driver.findElement(AppiumBy.accessibilityId(id)).sendKeys(data);
		logger.info("Entered value " +data+ " in " +id +".");
	}

	public void enterByClassName(String className, String data) {
		logger.info("enterByClassName arguments received - Xpath : "+className+", Value : "+data + ".");
		driver.findElement(AppiumBy.className(className)).sendKeys(data);
		logger.info("Entered value " +data+ " in " +className +".");
	}

	public void longPressAction(WebElement element) {
		logger.info("longPressAction arguments received - WebElement : "+element+".");
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
		logger.info("longClickGesture executed for 2s.");
	}

	public void appiumScrollAndClickAction(String uiText) {
		logger.info("appiumScrollAndClickAction arguments received - WebElement : "+uiText+".");
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + uiText + "\"));"))
				.click();
		logger.info("Scroll until and click element with UI text : " +uiText+" is found.");

	}

	public void appiumScrollAction(String uiText) {
		logger.info("appiumScrollAction arguments received - WebElement : "+uiText+".");
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"" + uiText + "\"));"));
		logger.info("Scroll until element with UI text : " +uiText+" is found.");


		/*
		 * This will scroll to child element. Not sure if this will work String
		 * androidUIAutomatorLocator =
		 * "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").resourceId(\"textBox6$label\"))"
		 * ;
		 * driver.findElement(AppiumBy.androidUIAutomator(androidUIAutomatorLocator));//
		 * .findElement(AppiumBy.className("android.widget.EditText"));
		 */

		/*
		 * driver.findElement(AppiumBy.androidUIAutomator(
		 * "new UiScrollable(new UiSelector().scrollable(true)).scrollForward().getChildByText(new UiSelector().text(\"Element Text\"))"
		 * ));
		 */

	}

	public void appiumScrollForward() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
		logger.info("Scroll foward action completed.");

	}

	public void appiumSwipeAction(WebElement element, String direction) {
		logger.info("appiumSwipeAction arguments received - WebElement : "+element+", Direction : "+direction+".");
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", 0.75));
		logger.info("Swipe action completed.");

	}

	public void dragAndDropAction(WebElement source, int xCoordinate, int yCoordinate) {
		logger.info("dragAndDropAction arguments received - WebElement : "+source+", xCoordinate : "+xCoordinate+" , yCoordinate : "+yCoordinate+".");
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) source).getId(), "endX", xCoordinate, "endY", yCoordinate));
		logger.info("Drag and Drop action completed.");

	}

	public void setActivity(String appPackage, String appActivity) {
		/*
		 * Activity activity = new Activity(appPackage , appActivity);
		 * driver.startActivity(activity);
		 */

	}

	public void waitForElementToBeClickable(String xpath, int seconds) {
		logger.info("waitForElementToBeClickable aruguments received - WebElement : " + xpath + ", Seconds : " + seconds);
		Duration time = Duration.ofSeconds(seconds);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
		logger.info("Waiting explicitly for element to be clickable.");

	}
	
	public void waitForElementToBeVisible(String xpath, int seconds) {
		logger.info("waitForElementToBeVisible aruguments received - Xpath : " + xpath + ", Seconds : " + seconds);
		Duration time = Duration.ofSeconds(seconds);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		logger.info("Waiting explicitly for element to be clickable.");

	}
	
	public void waitForElementToBePresent(String xpath) {
		logger.info("waitForElementToBePresent aruguments received - XPath : " + xpath + ".");
		wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		logger.info("Wait complete for the element "+xpath+" to be present.");

	}
	
	public void waitForElementToBePresentById(String id) {
		logger.info("waitForElementToBePresentById aruguments received - ID : " + id + ".");
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		logger.info("Wait complete for the element "+id+" to be present.");
	}


	public void pressBackKey() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		logger.info("Back key pressed");
	}

	public void pressEnterKey() {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		logger.info("Enter key pressed");
	}

	/*
	 * @AfterTest() public void tearDown() { driver.quit(); // service.stop(); }
	 */

}
