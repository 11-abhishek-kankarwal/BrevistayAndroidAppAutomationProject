package com.qa.brevistay.screens;

import org.openqa.selenium.By;

import com.qa.brevistay.utils.ElementUtils;

import io.appium.java_client.android.AndroidDriver;

public class logout {
	
	
private AndroidDriver driver;
private ElementUtils util;


//----------------------------------------------------------------------------------
// By locators



private final By profile = By.id("com.brevistay.customer:id/profileic");
private final By signInBtn = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Button");


//-------------------------------------------------------------------------------------

	public logout(AndroidDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	
	
	
	
	public void clickProfile() throws InterruptedException {
		Thread.sleep(1500);
		util.doClick(profile);
		//driver.findElement(profile).click();
	}
	
	public boolean checkSignIn()  {
		return util.isElementDisplayed(signInBtn);
		//return driver.findElement(signInBtn).isDisplayed();
	}
	

}
