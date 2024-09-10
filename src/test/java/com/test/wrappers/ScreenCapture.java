package com.test.wrappers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;

public class ScreenCapture {

	public String getScreenshotPath(String testcaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
