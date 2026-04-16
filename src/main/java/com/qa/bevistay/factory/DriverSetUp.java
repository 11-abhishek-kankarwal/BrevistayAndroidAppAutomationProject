package com.qa.bevistay.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSetUp {

	public static AndroidDriver driver;

	Properties prop;
	
	public static ThreadLocal<AndroidDriver> tlDriver = new ThreadLocal<AndroidDriver>();
	
	
	

	public AndroidDriver initializeDriver(Properties prop) throws Exception {

		String adbDevice = prop.getProperty("ADB devices");

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName(adbDevice);
		options.setAutomationName("UiAutomator2");

		options.setAppPackage("com.brevistay.customer");
		options.setAppActivity("com.brevistay.app.view.main.MainActivity");

		options.setAutoGrantPermissions(true);
		options.setNewCommandTimeout(Duration.ofSeconds(300));
		
		
		
		//tlDriver.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), options));

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		tlDriver.set(driver); 
		return driver;
	}
	
	
	public static AndroidDriver getDriver() {
		return tlDriver.get();
	}


	// ---------------------------------------------------------------------------------------------------------------

	// -------------------- using mvn--------------------------------------
//    	public Properties initProp() {
//    		
//    		String envName = System.getProperty("env");
//    		FileInputStream ip = null;
//    		prop = new Properties();
//    		
//    		try {
//    		if(envName == null) {
//    			System.out.println("env is null hence running the default Prod env...");
//    			 ip = new FileInputStream("./src/test/resources/config/config.properties");
//    		}
//    		else {
//    			System.out.println("Running on : "+envName);
//    			switch (envName.toLowerCase().trim()) {
//				case "prod": {
//					
//					ip = new FileInputStream("./src/test/resources/config/config.properties");
//					break;
//				}
//				default:
//					break;
//				}
//    		}
//    		}
//    		catch(FileNotFoundException e) {
//    			e.printStackTrace();
//    		}
//    		
//    		
//    		try {
//				prop.load(ip);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//    		
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 👉 Initialize Properties
	public Properties initProp() {

		prop = new Properties();

		try {
			InputStream ip = new FileInputStream("src/test/resources/config/config.properties");

			prop.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		return prop;
	}
	
	//------------------------------------------------------------------------------------------------------------
	
	
	
	
	//-------------------------------- Screenshot --------------------------------
	
	
	public static File getScreenshotFile() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		return srcFile;
	}

	public static byte[] getScreenshotByte() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);// temp dir

	}

	public static String getScreenshotBase64() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);// temp dir

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}