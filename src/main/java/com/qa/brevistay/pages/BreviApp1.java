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


public class BreviApp1{
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
        
        By TItle = By.xpath("//android.widget.TextView[@text=\"Get upto 100% OFF with Brevi Cash\"]");
        String homeTitle = driver.findElement(TItle).getText();
        System.out.println("Text = "+homeTitle);
        
        
        
    }
}
