package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.MMTGiftCardsPage;
import PageObjects.MMTUserDetailsPage;
import testBase.BaseClass;

public class TC_002_GiftCardPage extends BaseClass{
	
	MMTGiftCardsPage giftCard ;
	MMTUserDetailsPage userDetails ;
	BaseClass bc = new BaseClass();
	
	@Test(priority = 9, groups = {"sanity"})
	public void weddingCardTest() {
		logger.info("****** Starting TC_002_GiftCardPage ******");
		
		try {
			giftCard = new MMTGiftCardsPage(driver);
			giftCard.closeAd();
			logger.info("Closed Ad");
			giftCard.giftCardsClick();
			logger.info("Clicked on giftcards");
			giftCard.weddingGiftCardClick();
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail();
		}
		
	}
	
	@Test(priority = 10, groups = {"sanity"})
	public void enterUserDetailsTest()
	{
		
		try {
			userDetails = new MMTUserDetailsPage(driver);
			userDetails.enterSenderRecipientDetails();
			captureScreen("SenderRecipientDetails");
			logger.info("Sender and Recipient details enter");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to enter details");
		}
	}
	
	@Test(priority = 11, groups = {"sanity"})
	public void getErrorMessage()
	{
		try {
			userDetails = new MMTUserDetailsPage(driver);
			userDetails.getAlertMessage();
			captureScreen("ErrorMessage");
			logger.info("Error message captured");
			logger.info("****** TC_002_GiftCardPage Finished ******");
		} catch (Exception e) {
			System.out.println(e.toString());
			Assert.fail("Failed to fetch error message");
		}
	}

}
