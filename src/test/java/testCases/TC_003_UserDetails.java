package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.MMTUserDetailsPage;
import testBase.BaseClass;

public class TC_003_UserDetails extends BaseClass{
	
	MMTUserDetailsPage userDetails;
	BaseClass bc;
	
	
	
	@Test(priority = 12, groups = {"sanity"})
	public void clickHotels()
	{
		logger.info("****** Starting TC_003_UserDetails ******");
		try {
			userDetails = new MMTUserDetailsPage(driver);
			bc = new BaseClass();
			
			try {
				userDetails.closeAd();
				logger.info("Closed Ad");
			} catch (Exception e) {
				e.printStackTrace();
			}
			userDetails.clickOnHotels();
			logger.info("Clicked on Hotels");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to click on hotels");
		}
	}
	
	@Test(priority = 13, groups = {"sanity"})
	public void getNumberOfPeopleTest()
	{
		try {
			userDetails = new MMTUserDetailsPage(driver);
			bc = new BaseClass();
			
			userDetails.getNumberOfPeople();
			captureScreen("NumberOfPeople");
			logger.info("Number of people is fetched");
			logger.info("****** TC_003_UserDetails Finished ******");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to fetch number of people");
		}
	}
	
}
