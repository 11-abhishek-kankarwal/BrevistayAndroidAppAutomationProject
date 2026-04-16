package com.qa.brevistay.base;

import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.bevistay.factory.DriverSetUp;
import com.qa.brevistay.screens.homeScreen;
import com.qa.brevistay.screens.logout;

import io.appium.java_client.android.AndroidDriver;

@Listeners(ChainTestListener.class)

public class BaseTest {

	protected AndroidDriver driver;

	protected homeScreen home;
	protected logout out;

	Properties prop;

	DriverSetUp Ds;

	@BeforeClass
	public void setUp() throws Exception {

		Ds = new DriverSetUp();
		prop = Ds.initProp();
		driver = Ds.initializeDriver(prop);

		

		home = new homeScreen(driver);
		out = new logout(driver);
	}

	// --------------------------------------------------------

	@AfterMethod

	public void attachSS(ITestResult result) {
		if (!result.isSuccess() && DriverSetUp.getDriver() != null) {
			ChainTestListener.embed(DriverSetUp.getScreenshotFile(), "image/png");
		}
	}

	
	//----------------------------------------------------------
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
