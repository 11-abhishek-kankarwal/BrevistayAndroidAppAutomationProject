package com.qa.brevistay.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import com.sun.tools.javac.jvm.Profile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BreviApp{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {


       
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("ZA222ZFX36");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.brevistay.customer");
        options.setAppActivity("com.brevistay.app.view.main.MainActivity");
        
    
        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        System.out.println("✅ App launched successfully!");
        System.out.println("📱 Current Activity: " + driver.currentActivity());
        


        Thread.sleep(2000);
//        System.out.println("1");
//     
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            WebElement closeBtn = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                    AppiumBy.xpath("//android.widget.TextView[@text='Skip']")
//                )
//            );
//            closeBtn.click();
//        } catch (Exception e) {
//            System.out.println("Popup not shown");
//        }

        System.out.println("-----1");
        Thread.sleep(2000);
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        
        Thread.sleep(2000);
        
        WebElement  header =driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"BreviStay Logo\"]"));
      //  String Htext = header.getText();
        System.out.println("Header : "+header.isDisplayed());
        
        
        Thread.sleep(2000);
        
//        driver.findElement(
//        	    AppiumBy.androidUIAutomator(
//        	        
//        	    		"new UiScrollable(new UiSelector().scrollable(true))" +
//        	        ".scrollIntoView(new UiSelector().text(\"Freedom of Flexible Check-in\"))"
//        	    )
//        	);
//        
        
        driver.findElement(
        	    AppiumBy.androidUIAutomator(
        	        "new UiScrollable(new UiSelector().scrollable(true))" +
        	        ".scrollToEnd(1000)"
        	    )
        	);

        driver.findElement(
        	    AppiumBy.androidUIAutomator(
        	        "new UiScrollable(new UiSelector().scrollable(true))" +
        	        ".scrollToEnd(1000)"
        	    )
        	);
        
        

        
        WebElement footer1 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Freedom of Flexible Check-in\"]"));
        WebElement footer2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Trusted by over 2 Million Indians\"]"));
        
        String f1 = footer1.getText();
        String f2 = footer2.getText();
        System.out.println("Footer 2 :"+f2);
        System.out.println("Footer 1 :"+f1);
        
        
        WebElement fav = driver.findElement(By.id("com.brevistay.customer:id/favic"));
        fav.click();
        System.out.println("-----2");
        Thread.sleep(2000);
        
        WebElement profile = driver.findElement(By.id("com.brevistay.customer:id/profileic"));
        profile.click();
        System.out.println("-----3");
        
        WebElement booking = driver.findElement(By.id("com.brevistay.customer:id/bookingic"));
        booking.click();
        System.out.println("-----4");
        
        
        WebElement offers = driver.findElement(By.id("com.brevistay.customer:id/offersic"));
        offers.click();
        System.out.println("-----5");
        
        
        profile.click();
        System.out.println("-----6");
        
        
        WebElement signin = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Button"));
        signin.click();
        System.out.println("-----7");
        
        Thread.sleep(2000);
       
        WebElement enterMno =  driver.findElement(By.id("com.brevistay.customer:id/numEditText"));
        enterMno.sendKeys("7760291354");
        
        WebElement UsePwd = driver.findElement(By.id("com.brevistay.customer:id/option2Btn"));
        UsePwd.click();
        
      	driver.findElement(By.id("com.brevistay.customer:id/passEditText")).sendKeys("999");
       
    	driver.findElement(By.id("com.brevistay.customer:id/progressBtnYellow_txt")).click();
        
        Thread.sleep(2000);
     //   driver.pressKey(new KeyEvent(AndroidKey.BACK));
        System.out.println("-----9");
        
        
        Thread.sleep(1500);
     	driver.findElement(By.id("com.brevistay.customer:id/profileic")).click();    
        System.out.println("-----10");
        
        driver.findElement(By.id("com.brevistay.customer:id/favic")).click();        
        System.out.println("-----11");
        
       driver.findElement(By.id("com.brevistay.customer:id/offersic")).click(); 
        System.out.println("-----12");
        
        
       // booking.click();  
        System.out.println("-----13");
        
        
        
        Thread.sleep(2000);
        driver.findElement(By.id("com.brevistay.customer:id/homeic")).click();
       // driver.findElement(By.xpath("//android.view.View[@content-desc=\"Wide Banner\"]")).click();
       // driver.findElement(By.xpath("//android.view.View[@content-desc=\"Delhi\"]")).click();
      //  Thread.sleep(2000);
        
    //    driver.findElement(By.id("com.brevistay.customer:id/hotel_name")).click();
        
        //driver.quit();
    }
}
