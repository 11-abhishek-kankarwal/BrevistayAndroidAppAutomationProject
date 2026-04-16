package com.qa.brevistay.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mock.qa.brevistay.constant.appConstants;
import com.qa.brevistay.utils.ElementUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class homeScreen {

	private AndroidDriver driver;

	private ElementUtils util;

	public homeScreen(AndroidDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}

	

	// ------------------ locator --------------------------------

	//private final By mainBanner = AppiumBy.accessibilityId("Wide Banner").get(0);
	private final By mainBanner = By.xpath("//android.view.View[@content-desc=\"Wide Banner\"][1]");
	

	// -------------------------tabs------------------------------
	private final By hourlyTab = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]");
	private final By fulldayTab = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]");

	private final By hourlyTabText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Hourly Stay\")");

	private final By FulldayTabText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Full-Day Stay\")");
	private final By FulldayTabOfferText = AppiumBy.androidUIAutomator("new UiSelector().text(\"NEW\")");

	// -------------------------Search Bar------------------------------

	private final By searchBar = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(24)");
	private final By searchBarText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Search Hourly Hotels...\")");
	private final By searchBarIcon = AppiumBy.accessibilityId("Right Image");

	// -------------------------- city list -----------------------------

	private final By cityCarousel = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)");

	// --------------------------------- coupon list --------------------------------

	private final By couponList = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(20)");

	// ---------------------------------- PnW banner ----------------------------------------------------------------
	
	//private final By wideBanner = By.id("com.brevistay.customer:id/exo_overlay");
	//private final By wideBanner = By.xpath("//android.widget.FrameLayout[@resource-id=\"com.brevistay.customer:id/exo_subtitles\"]/android.view.View");
	
	private final By wideBanner = AppiumBy.androidUIAutomator("new UiSelector().description(\"Wide Banner\")");
	
	//------------------------------------ RnE Banner ------------------------------------------------------------------------
	
	private final By RnE_wideBanner = AppiumBy.accessibilityId("Wide Banner");
	
	//-------------------------------------- Brevistay banner -----------------------------------------------------------------
	
	//private final By brevistayBlogsList = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(7)");
	//private final By brevistayBlogsList = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]");
	private final By brevistayBlogsList = AppiumBy.accessibilityId("Is Brevistay Safe? Here’s Everything You Need to Know");
	//private final By brevistayBlogsList = Brevi1stblog;
	
	
	
	//--------------------------------------- Benefits of Brevistay -----------------------------------------------------------
	
	private final By BenefitsOfBrevistay = AppiumBy.androidUIAutomator("new UiSelector().text(\"Benefits of Brevistay\")");
	
	//	private final By benefitsCardsContainer = AppiumBy.accessibilityId("Freedom of anytime check-in");
	
	
	//--------------------------------------- Footer ---------------------------------------------------------------------------

	private final By footerLogo = AppiumBy.androidUIAutomator("new UiSelector().description(\"Footer Logo\")");
	
	private final By footerText1 = AppiumBy.androidUIAutomator("new UiSelector().text(\"Freedom of Flexible Check-in\")");
	
	private final By footerText2 = AppiumBy.androidUIAutomator("new UiSelector().text(\"Trusted by over 2 Million Indians\")");
	
	
	
	//--------------------------------------- Navigation Bar ---------------------------------------------------------------------
	
	private final By Home = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.brevistay.customer:id/hometxt\")");
	
	private final By fav = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.brevistay.customer:id/favic\")");
	
	private final By myBookings = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.brevistay.customer:id/bookingic\")");
	
	private final By offerSection = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.brevistay.customer:id/offersic\")");
	
	private final By myProfile = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.brevistay.customer:id/profileic\")");
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	
	
	

	@Description("Main banner on  home screen")

	public boolean isMainBannerAvailable() {
		return util.isElementDisplayed(mainBanner);
	}

	public String getMainBannerType() {
		return util.appAttribute(mainBanner, "content-desc");
	}

	// -----------------------------------------------------------------------------------------------------------------

	@Description("Tabs")

	public boolean isHourlyTabAvailable() {
		return util.isElementDisplayed(hourlyTab);
	}

	public boolean isFulldayTabAvailable() {
		return util.isElementDisplayed(fulldayTab);
	}

	public boolean isFulldaynewOfferTabAvailable() {
		return util.isElementDisplayed(FulldayTabOfferText);
	}

	public String getHourlyTabText() {
		return util.findElement(hourlyTabText).getText();
	}

	public String getFulldayTabText() {
		return util.findElement(FulldayTabText).getText();
	}

	public String getFulldaynewOfferTabText() {
		return util.findElement(FulldayTabOfferText).getText();
	}

	// -----------------------------------------------------------------------------------------------------------------

	@Description("Search Bar")

	public boolean isSearchBarAvailable() {
		return util.isElementDisplayed(searchBar);
	}

	public String getSearchBarText() {
		return util.findElement(searchBarText).getText();
	}

	public boolean isSearchBarIconAvailable() {
		return util.isElementDisplayed(searchBarIcon);
	}

	// -------------------------------------------------------------------------------------------------------------------

	@Description("city list")

	public void swipeCityCarouselRight() {
		WebElement carousel = driver.findElement(cityCarousel);
		util.swipeLeftOnElement(carousel);
	}

	private By citiesInList(String cityName) {
		return AppiumBy.androidUIAutomator("new UiSelector().description(\"" + cityName + "\")");
	}

	public boolean isCityPresent(String cityName) {
		return util.isElementDisplayed(citiesInList(cityName));

	}

	public String getCityList(String cityName) {
		return util.findElement(citiesInList(cityName)).getAttribute("content-desc");
	}

	// --------------------------------------------------------------------------------------------------------------------------

	@Description("coupon list")

	public boolean isCouponListAvailable() {
		return util.isElementDisplayed(couponList);
	}

	public By couponBannerByDesc(String couponElement) {
		return AppiumBy.androidUIAutomator("new UiSelector().description(\"" + couponElement + "\")");
	}

	public String getCouponContentDesc(String couponName) {
		return util.findElement(couponBannerByDesc(couponName)).getAttribute("content-desc");
	}

	public boolean isCouponAvailable(String coupon) {
		try {
			return util.isElementDisplayed(couponBannerByDesc(coupon));
		} catch (Exception e) {
			return false;
		}
	}

	public String getFirstVisibleBanner() {
		for (String coupon : appConstants.couponList) {
			if (isCouponAvailable(coupon)) {
				return coupon;
			}
		}
		return null;
	}
	
	
	
	public boolean swipeOnCouponBanner(String couponName) {
		By targetLoctaor = couponBannerByDesc(couponName);
		By firstElementLocator = couponBannerByDesc(appConstants.couponList[0]);
		
		return util.swipeUntilElementVisible(targetLoctaor, firstElementLocator, couponList);
	}
	
	
//-------------------------------------------------------------------------------------------------------------------------------


	@Description("PnW Wide Banner")
	public boolean isWideBannerPresent() {
		//util.scrollDown();
		util.scrollToElement(wideBanner);
		return util.isElementDisplayed(wideBanner);
	}

//---------------------------------------------------------------------------------------------------------------------------




	@Description("refer and Earn banner")
	
	public void scrollToRnf() {
		util.scrollToElement(RnE_wideBanner);
	}
	
	
	public boolean isRnF_BannerPresent() {
		return util.isElementDisplayed(RnE_wideBanner);
	}
	
	public String RnF_BannerDesc() {
		return util.appAttribute(RnE_wideBanner, "content-desc");
	}


//----------------------------------------------------------------------------
	
	
	
	@Description("brevistay blogs")
	
	
	
	
	public boolean  scrollToBreviBlogsList() {
		return util.scrollToElement(brevistayBlogsList);
	}
	
	public boolean isBreviBlogsListPresent() {
		return util.isElementDisplayed(brevistayBlogsList);
		
	}
	
	
	public By BreviBlogByElement(String BlogElement) {
		return AppiumBy.androidUIAutomator("new UiSelector().description(\""+ BlogElement +"\")");
	}
	
	
	public String BreviBlogContentDesc(String BlogElement) {
		return util.findElement(BreviBlogByElement(BlogElement)).getAttribute("content-desc");
	}
	
	public boolean isBreviblogAvailable(String blog) {
		try {
			return util.isElementDisplayed(BreviBlogByElement(blog));
		} catch (Exception e) {
			return false;
		}
	}

	
	public String getFirstVisibleBlog() {
		for (String blog : appConstants.blogList) {
			if (isBreviblogAvailable(blog)) {
				return blog;
			}
		}
		return null;
	}
	
	
	
	public boolean swipeOnBreviBlog(String Blog) {
		By targetLoctaor = BreviBlogByElement(Blog);
		By firstElementLocator = BreviBlogByElement(appConstants.blogList[0]);
		
		return util.swipeUntilElementVisible(targetLoctaor, firstElementLocator, brevistayBlogsList);
	}
	
	
	//------------------------------------------------------------------------------------------------
	
	

	@Description("Benefits of Brevistay")
	
	public boolean scrollToBenefitsOfBrevistay( ) {
		return util.scrollToElement(BenefitsOfBrevistay);
	}
	
	public boolean isBenefitsOfBrevistayTextAvailable() {
		return util.isElementDisplayed(BenefitsOfBrevistay);
	}
	
	public String getBenefittsOfBrevistayTitle() {
		//return util.findElement(BenefitsOfBrevistay).getText();
		return util.appAttribute(BenefitsOfBrevistay, "text");
		
	}
	
	
	
	public By BenefitsOfBrevistayList(String BenefitsElements) {
		return AppiumBy.androidUIAutomator("new UiSelector().description(\""+ BenefitsElements +"\")");
	}
	
	 public String getBenefitsOfBrevistayCardText(String BenefitsElements) {
		 return util.appAttribute( BenefitsOfBrevistayList(BenefitsElements), "content-desc");
	 }
	
	 public Boolean isBenefitsOfBrevistayCardPresent(String BenefitsElement) {
		try {
			return util.isElementDisplayed(BenefitsOfBrevistayList(BenefitsElement));
		} catch (Exception e) {
			return false;
			}
	 }
	
	
		public String getFirstBenefitsOfBrevistayVisibleCard() {
			for (String Card : appConstants.BenefitsOfBreviCardList) {
				if (isBenefitsOfBrevistayCardPresent(Card)) {
					return Card;
				}
			}
			return null;
		}
	
	
	
	
		public boolean swipeOnBenefitsCards(String card) {

		    if (isBenefitsOfBrevistayCardPresent(card)) {
		        return true;
		    }

		    boolean startedCycle = false;
		    String firstCard = appConstants.BenefitsOfBreviCardList[0];

		    while (true) {
		        String currentCard = getFirstBenefitsOfBrevistayVisibleCard();

		        if (currentCard == null) {
		            return false;
		        }

		        WebElement visibleCard = util.findElement(BenefitsOfBrevistayList(currentCard));
		        util.swipeLeftOnElement(visibleCard);

		        try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		            return false;
		        }

		        if (isBenefitsOfBrevistayCardPresent(card)) {
		            return true;
		        }

		        if (isBenefitsOfBrevistayCardPresent(firstCard)) {
		            if (startedCycle) {
		                break;
		            }
		        } else {
		            startedCycle = true;
		        }
		    }

		    return false;
		}

//-----------------------------------------------------------------------------


	@Description("Brevistay footer")

	public boolean isFooterText1() {
		return util.isElementDisplayed(footerText1);
	}
	
	public boolean isFooterText2() {
		return util.isElementDisplayed(footerText2);
	}
	
	
	public String getFooterText1() {
		return util.findElement(footerText1).getText();
	}
	
	
	
	public String getFooterText2() {
		return util.findElement(footerText2).getText();
	}
	
	
	@Description("Brevistay Logo")
	public void scrollToFooterLogo() {
		util.scrollToElement(footerLogo);
	}

	
	public boolean isFooterLogoPresent() {
		return util.isElementDisplayed(footerLogo);
	}



//-------------------------------------------------------------------------

	@Description("navigation bar")

	@Step("for availablity")
	public boolean isHomeAvailable() {
		return util.isElementDisplayed(Home);
	}

	public boolean isFavAvailable() {
		return util.isElementDisplayed(fav);
	}

	public boolean isMyBookingsAvailable() {
		return util.isElementDisplayed(myBookings);
	}

	public boolean isOffesAvailable() {
		return util.isElementDisplayed(offerSection);
	}

	public boolean isProfileAvailable() {
		return util.isElementDisplayed(myProfile);
	}


	@Step("for text")
	
	
	public String getHomeText() {
		return util.findElement(Home).getText();
	}

	public String getFavText() {
		return util.findElement(fav).getText();
	}

	public String getMyBookingText() {
		return util.findElement(myBookings).getText();
	}

	public String getOffersText() {
		return util.findElement(offerSection).getText();
	}

	public String getProfileText() {
		return util.findElement(myProfile).getText();
	}



}


