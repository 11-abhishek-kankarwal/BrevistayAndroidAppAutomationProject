package com.qa.brevistay.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mock.qa.brevistay.constant.appConstants;
import com.qa.brevistay.base.BaseTest;
import com.qa.brevistay.screens.homeScreen;
import com.qa.brevistay.utils.ElementUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;




public class homeScreenTest extends BaseTest {
	
	private homeScreen home ;
	private ElementUtils utils;
	
	
	@BeforeClass
	
	public void SetuphomeScreenTest() {
		home = new homeScreen(driver);
	}
	
	
	
	//----------------------------------------------------------
	
	
	@Owner("QA: Abhishek Kankarwal")
	
	
	@Description("Checking for Main Banner on Home Screen")
	@Test(priority = 1)
	
	public void testMainBanner() {
		Assert.assertTrue(home.isMainBannerAvailable());
		Assert.assertEquals(home.getMainBannerType(), appConstants.MainBannerType);
	}
	
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------
	
	
	
	
	@Description("Checking for Hourly and Fullday Tabs")
	@Test(priority = 2)
	
	public void testHomeScreenTabs() {
		
		Assert.assertTrue(home.isHourlyTabAvailable());
		Assert.assertTrue(home.isFulldayTabAvailable());
		Assert.assertTrue(home.isFulldaynewOfferTabAvailable());
		
		Assert.assertEquals(appConstants.hourlyTabText, home.getHourlyTabText());
		Assert.assertEquals(appConstants.FulldayTabText, home.getFulldayTabText());
		Assert.assertEquals(appConstants.FulldaynewOfferTabText, home.getFulldaynewOfferTabText());
		
	}
	
	
	
	//--------------------------------------------------------------------------------------------------------
	
	
	@Description("Checking for Search Bar")
	@Test(priority = 3)
	
	public void testSearchBar() {
		
		Assert.assertTrue(home.isSearchBarAvailable());
		Assert.assertTrue(home.isSearchBarIconAvailable());
		
		
		Assert.assertEquals(appConstants.searchBarText, home.getSearchBarText());
		
	}
	
	
	
	//---------------------------------------------------------------------------------------------------------
	
	
	

	@Description("Validate first 5 cities on home screen")
	@DataProvider(name = "firstSetOfCities")

	
	
	public Object[][] getFirst5Cities() {
		Object[][] cities = new Object[appConstants.firstSetOfCities.length][1];
		
		for (int i = 0; i < appConstants.firstSetOfCities.length; i++) {
			cities[i][0] = appConstants.firstSetOfCities[i];
		}
		
		return cities;
	}
	
	@Test(priority = 4, dataProvider = "firstSetOfCities")
	
	public void testFirst5Cities(String cityName) {
		Assert.assertTrue(home.isCityPresent(cityName), cityName + " is not visible on home screen");
		Assert.assertEquals(home.getCityList(cityName), cityName, "Content-desc mismatch for city: " + cityName);

	}

	// -----------------------------------------------------------------------------------------------------

	
	@Description("using right sweep")
	@Test(priority = 5)

	public void testCityCarouselSwipeRight() {
		home.swipeCityCarouselRight();
	}

	// --------------------------------------------------------------------

	
	
	@Description("Validate first 5 cities on home screen")
	@DataProvider(name = "LastSetOfCities")
	

	public Object[][] LastCities() {
		Object[][] cities = new Object[appConstants.lastSetOfCities.length][1];

		for (int i = 0; i < appConstants.lastSetOfCities.length; i++) {
			cities[i][0] = appConstants.lastSetOfCities[i];
		}

		return cities;
	}

	@Test(priority = 6, dataProvider = "LastSetOfCities")
	public void testLastSetCities(String cityName) {
		Assert.assertTrue(home.isCityPresent(cityName), cityName + " is not visible on home screen");
		Assert.assertEquals(home.getCityList(cityName), cityName, "Content-desc mismatch for city: " + cityName);
		

	}
	
	//---------------------------------------------------------------------------------------------------
	
	
	
	@Description("Validating coupon list")
	@Test(priority = 7)
	public void testIsCouponListPresent() {
	    Assert.assertTrue(home.isCouponListAvailable(), "Coupon list is not visible on home screen");
	}

	@DataProvider(name = "Coupon")
	public Object[][] couponName() {
	    Object[][] coupon = new Object[appConstants.couponList.length][1];

	    for (int i = 0; i < appConstants.couponList.length; i++) {
	        coupon[i][0] = appConstants.couponList[i];
	    }

	    return coupon;
	}

	@Test(priority = 8, dataProvider = "Coupon")
	public void testCouponBannerList(String couponName) {
	    boolean found = home.swipeOnCouponBanner(couponName);

	    Assert.assertTrue(found, couponName + " not visible after swipe");

	    Assert.assertEquals(
	            home.getCouponContentDesc(couponName),
	            couponName,
	            "Content-desc mismatch for " + couponName
	    );
	}
	
	
	
	//-------------------------------------------------------------------------------------------
	
	@Description("validating on PnW Wide Banner")
	
	@Test(priority = 9)

	
	
	
	public void testWideBanner() {
		Assert.assertTrue(home.isWideBannerPresent());
	}
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	@Description("Validating Refer and Earn Banner")
	
	
	@Test(priority = 10)
	
	public void testRnF_WideBanner()
	{
		
		//utils.scrollToElement(home.RnE_wideBanner);
		home.scrollToRnf();
		Assert.assertTrue(home.isRnF_BannerPresent());
		Assert.assertEquals(appConstants.RnE_Banner, home.RnF_BannerDesc());
	}
	
	
	
	//-------------------------------------------------------------------------------------------------
	@Description("Validating Brevistay blog")
	
	
	@DataProvider(name = "blogs")
	public Object[][] blogName() {
	    Object[][] blog = new Object[appConstants.blogList.length][1];

	    for (int i = 0; i < appConstants.blogList.length; i++) {
	    	blog[i][0] = appConstants.blogList[i];
	    }

	    return blog;
	}

	
	

	@Test(priority = 11, dataProvider = "blogs")
	 
	public void testBrevistayBlogs(String Blogs) {
		
		home.scrollToBreviBlogsList();
		Assert.assertTrue(home.isBreviBlogsListPresent(),"Blog list is not visible on home screen");
		
		boolean found = home.swipeOnBreviBlog(Blogs);
		
		Assert.assertTrue(found, Blogs + "not visible after swipe");
		Assert.assertEquals(home.BreviBlogContentDesc(Blogs), Blogs, "Content-desc mismatch for " + Blogs);
	
	}
	
	

	//--------------------------------------------------------------------------------------------------
	
	@Description("Validating Benefits of Brevistay")
	
	
	
	@DataProvider(name = "Cards")
	public Object[][] CardsName() {
	    Object[][] Cards = new Object[appConstants.BenefitsOfBreviCardList.length][1];

	    for (int i = 0; i < appConstants.BenefitsOfBreviCardList.length; i++) {
	    	Cards[i][0] = appConstants.BenefitsOfBreviCardList[i];
	    }

	    return Cards;
	}

	
	
	
	
	
	
	
	@Test(priority = 12 , dataProvider = "Cards")
	
	public void testBenefitsOfBrevistay(String Cards) {
		
		home.scrollToBenefitsOfBrevistay();
		Assert.assertTrue(home.isBenefitsOfBrevistayTextAvailable());
		Assert.assertEquals(home.getBenefittsOfBrevistayTitle(), "Benefits of Brevistay");
		
		
		boolean found = home.swipeOnBenefitsCards(Cards);
		Assert.assertTrue(found, Cards + " not visible after swipe");
		Assert.assertEquals(home.getBenefitsOfBrevistayCardText(Cards), Cards, "Content-desc mismatch for " + Cards);
		
		
	}
	
	
	
	
	
	
	
	

	//--------------------------------------------------------------------------------------------------
	
	@Description("Validating footor")

	@Test(priority = 13)

	public void testFooter() {
		home.scrollToFooterLogo();
		Assert.assertTrue(home.isFooterText1());
		Assert.assertEquals(appConstants.footerText1, home.getFooterText1());
		Assert.assertTrue(home.isFooterText2());
		Assert.assertEquals(appConstants.footerText2, home.getFooterText2());
		
		Assert.assertTrue(home.isFooterLogoPresent());
		
	}
	
	
	
	
	//-------------------------------------------------------------------------------------
	
	@Description("Validating navigation bar")
	@Test(priority = 14)
	
	public void testNaviBar() {
		Assert.assertTrue(home.isHomeAvailable());
		Assert.assertTrue(home.isFavAvailable());
		Assert.assertTrue(home.isMyBookingsAvailable());
		Assert.assertTrue(home.isOffesAvailable());
		Assert.assertTrue(home.isProfileAvailable());
	}
	
	
	
	/*
	 * public void bannerTest() { home = new homeScreen(driver); String actualTitle
	 * = home.banner(); Assert.assertEquals(actualTitle, appConstants.bannerTitle);
	 * Assert.assertTrue(actualTitle.contains("100%")); }
	 */
	
	/*
	 * public void bannerTest() { //home = new homeScreen(driver);
	 * 
	 * Assert.assertFalse(home.banner()); }
	
	
	/*@Description("Checking for hourlyStay option...")
	@Test(priority = 2)
	
	public void hourlyStayTest() {
		Assert.assertTrue(home.hourlyStay());
	}
	
	
	
	@Description("Checking for navigation bar...")
	@Test(priority = 3)
	
	public void navgBar() {
		Assert.assertTrue(home.home());
		Assert.assertTrue(home.fav());
		Assert.assertTrue(home.mybookings());
		Assert.assertTrue(home.offers());
		Assert.assertTrue(home.profileScreen());
	}
	
//----------------------------------------------------
	
	
	
	@Description("Checking for search bar...")
	@Test(priority = 4)
	
	public void serachBarTest() {
		String actualText = home.searchBar();
		Assert.assertEquals(actualText, appConstants.searchBarText);
		Assert.assertTrue(home.serachField());
		Assert.assertTrue(home.searchlogo());
	}
	
	
//-----------------------------------------------------
	
	
	
	@Description("Checking for logos")
	@Test(priority = 6)
	
	public void logos() {
		//utils.scrollToText("Freedom of Flexible Check-in");
		
		Assert.assertTrue(home.breviLogo());
	}
//------------------------------------------------------
	
	@Description("Checking for Benefits of Brevistay Banners")
	@Test(priority =6)
	
	public void BenefitsOfBrevistayBanner() {
		//Assert.assertTrue(home.FreedomCheckinBanner());
		Assert.assertEquals("Freedom of anytime check-in", home.FreedomCheckinText());
	}
	*/
	
}
