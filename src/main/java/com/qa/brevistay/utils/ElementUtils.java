package com.qa.brevistay.utils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.aventstack.chaintest.plugins.ChainTestListener;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class ElementUtils {

	public AndroidDriver driver;

	public ElementUtils(AndroidDriver driver) {
		this.driver = driver;
	}

	// ----------------------------------------------

	@Step("findinding the element : {0}")
	public WebElement findElement(By locator) {
		ChainTestListener.log("locator : " + locator.toString());
		return driver.findElement(locator);
	}

	// -----------------------------------------------

	public void doClick(By locator) {
		findElement(locator).click();
	}

	// -----------------------------------------------

	public void doSendkeys(By locator, String value) {
		findElement(locator).sendKeys(value);
	}

	// -----------------------------------------------

	public void doSearch(By searchField, By searchList, String search, String match) throws Exception {

		Thread.sleep(1000);
		driver.findElement(searchField).sendKeys(search);

		Thread.sleep(750);

		List<WebElement> whereList = driver.findElements(searchList);

		for (WebElement e : whereList) {
			String wherePlace = e.getText();

			if (wherePlace.toLowerCase().contains(match)) {
				e.click();
			}
		}

	}

	// -----------------------------------------------

	public void doSelectDate(By selectField, By calField, String selectDate)  {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(selectField).click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> dateList = driver.findElements(calField);

		System.out.println(dateList.size());

		for (WebElement e : dateList) {

			String dates = e.getText();

			if (dates.contains(selectDate)) {

				e.click();
			}

		}
	}

	// -----------------------------------------------

	public boolean isElementDisplayed(By locator) {

		try {
		return findElement(locator).isDisplayed();
		}catch(Exception e) {
	        return false;
	    }
	}

	// -----------------------------------------------

	public String appAttribute(By locator, String attributeName) {
		return findElement(locator).getAttribute(attributeName);

	}

	//------------------------------------------------
	
	public void performSwipe(int startX, int startY, int endX, int endY) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY));

        swipe.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(500),
                PointerInput.Origin.viewport(),
                endX,
                endY));

        swipe.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }
	  
	
	
	// -------------------------------------------------

	public void swipeRightOnElement(WebElement element) {
	    int startX = element.getRect().x + (int)(element.getRect().width * 0.9);
	    int endX   = element.getRect().x + (int)(element.getRect().width * 0.1);
	    int y      = element.getRect().y + (element.getRect().height / 2);

	    performSwipe(startX, y, endX, y);
	}
	
	
	
	
	
	
	public void swipeLeftOnElement(WebElement element) {
	    int startX = element.getRect().x + (int)(element.getRect().width * 0.9);
	    int endX   = element.getRect().x + (int)(element.getRect().width * 0.1);
	    int y      = element.getRect().y + (element.getRect().height / 2);

	    performSwipe(startX, y, endX, y);
	}
	
	//----------------------------------------------------------------
	
	
	public boolean swipeUntilElementVisible(By targetLocator, By firstItemLocator, By carouselLocator) {

	    if (isElementDisplayed(targetLocator)) {
	        return true;
	    }

	    WebElement carousel = findElement(carouselLocator);
	    boolean startedCycle = false;

	    while (true) {
	        swipeLeftOnElement(carousel);

	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            return false;
	        }

	        if (isElementDisplayed(targetLocator)) {
	            return true;
	        }

	        // Fix - use isElementDisplayed instead of findElement
	        boolean firstItemVisible = false;
	        try {
	            firstItemVisible = isElementDisplayed(firstItemLocator);
	        } catch (Exception e) {
	            firstItemVisible = false;
	        }

	        if (firstItemVisible) {
	            if (startedCycle) {
	                break;
	            }
	        } else {
	            startedCycle = true;
	        }
	    }

	    return false;
	}
	//----------------------------------------------------------------
	
	public void scrollDown() {
	    Dimension size = driver.manage().window().getSize();

	    int startX = size.width / 2;
	    int startY = (int) (size.height * 0.80);
	    int endY = (int) (size.height * 0.30);

	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence swipe = new Sequence(finger, 1);

	    swipe.addAction(finger.createPointerMove(Duration.ZERO,
	            PointerInput.Origin.viewport(), startX, startY));
	    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
	            PointerInput.Origin.viewport(), startX, endY));
	    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Arrays.asList(swipe));
	}
	
	
	
	public boolean scrollToElement(By locator) {

	    int maxScrolls = 6; 
	    for (int i = 0; i < maxScrolls; i++) {

	        if (isElementDisplayed(locator)) {
	            return true;
	        }

	        scrollDown();

	        try {
	            Thread.sleep(800);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            return false;
	        }
	    }

	    return false;
	}
	
	
	
	
	
	
	
	
}
