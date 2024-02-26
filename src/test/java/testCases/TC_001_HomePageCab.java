package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.MMTHomePage;
import PageObjects.MMTSearchedCabPage;
import testBase.BaseClass;

public class TC_001_HomePageCab extends BaseClass{
	
	MMTHomePage homepage;
	MMTSearchedCabPage searchpage;
	
	
	
	@Test(priority = 1, groups = {"sanity"})
	public void closeAdvertisement() {
		
		try {
			logger.info("****** Starting TC_001_HomePageCab ******");
			homepage = new MMTHomePage(driver);
			homepage.closeAd();
			logger.info("Closed advertisement");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			Assert.fail("Failed to close ad.");
		}
		
	}
	
	@Test(priority = 2, groups = {"sanity"})
	public void cabSelectTest()
	{
		homepage = new MMTHomePage(driver);
		try {
			homepage.clickOnCab();
			logger.info("Clicked on cabs.");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to click on Cabs");
		}
	}
	
	@Test(priority = 3, groups = {"sanity"})
	public void selectFromCity()
	{
		homepage = new MMTHomePage(driver);
		try {
			homepage.enterFromCity();
			logger.info("Entered from city.");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to enter from city.");
		}
	}
	
	@Test(priority = 4, groups = {"sanity"})
	public void selectToCity()
	{
		homepage = new MMTHomePage(driver);
		try {
			homepage.enterToCity();
			logger.info("Entered to city.");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to enter to city");
		}
	}
	
	@Test(priority = 5, groups = {"sanity"})
	public void selectPickUpDate()
	{
		homepage = new MMTHomePage(driver);
		try {
			homepage.enterStartDate();
			logger.info("Entered pickup date.");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to enter date.");
		}
	}
	
	@Test(priority = 6, groups = {"sanity"})
	public void selectPickUpTime()
	{
		homepage = new MMTHomePage(driver);
		try {
			homepage.enterPickUpTime();
			captureScreen("EnteredDetails");
			logger.info("Entered pickup time.");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to enter time");
		}
	}
	
	@Test(priority = 7, groups = {"sanity"})
	public void clickSearchButton()
	{
		homepage = new MMTHomePage(driver);
		try {
			homepage.searchVehicleBtn();
			logger.info("Clicked on vehicle search button");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to click on search button");
		}
	}
	
	@Test(priority = 8, groups = {"sanity"})
	public void verifySUVs() {
		searchpage = new MMTSearchedCabPage(driver);
		try {
			searchpage.clickOnSUV();
			searchpage.lowestPrice();
			captureScreen("SUVs");
			logger.info("Clicked on SUVs in filters and lowest price fetched");
			logger.info("****** TC_001_HomePageCab Finished ******");
		} catch (Exception e) {
			System.out.println(e.toString()+"\nFailed to search only SUVs");
		}
		
	}
}
