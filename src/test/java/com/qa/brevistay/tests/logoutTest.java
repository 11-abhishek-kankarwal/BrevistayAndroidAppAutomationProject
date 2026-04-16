package com.qa.brevistay.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.brevistay.base.BaseTest;
import com.qa.brevistay.screens.logout;

public class logoutTest extends BaseTest{

	
	//logout log = new logout(driver);
	
	@Test
	
	public void checkSignInTest() throws InterruptedException {
		out.clickProfile();
		Assert.assertTrue(out.checkSignIn());
	}
	
}
