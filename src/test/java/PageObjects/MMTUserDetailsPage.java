package PageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;



public class MMTUserDetailsPage extends BasePage{

	public MMTUserDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//div[@class='deliver__wrap'])[1]//li[2]") 
	WebElement sendViaEmail;
	
	@FindBy(xpath="//div[@class='deliver__content']") 
	WebElement scrollToEle;
	
	@FindBy(xpath="//input[@name='name']") 
	WebElement recipientName;
	
	@FindBy(xpath="//input[@name='mobileNo']") 
	WebElement rerecipientMobile;
	
	@FindBy(xpath="//input[@name='emailId']") 
	WebElement recipientEmail;
	
	@FindBy(xpath="//textarea[@name='giftMessage']") 
	WebElement composeMsg;
	
	@FindBy(xpath="//input[@name='senderName']") 
	WebElement senderName;
	
	@FindBy(xpath="//input[@name='senderMobileNo']") 
	WebElement senderMobile;
	
	@FindBy(xpath="//input[@name='senderEmailId']") 
	WebElement senderEmail;
	
	@FindBy(xpath="//button[contains(text(),'BUY NOW')]") 
	WebElement buyNowButton;
	
	@FindBy(xpath="//p[@class='red-text font11 append-top5']") 
	List<WebElement> alertRedMsg;
	
	@FindBy(xpath="//li[@class='menu_Hotels']") 
	WebElement hotelsIcon;
	
	@FindBy(xpath="//div[@class='hsw_inputBox roomGuests']//label") 
	WebElement adultsBox;
	
	@FindBy(xpath="(//div[@class='gstSlct'])[2]") 
	WebElement adultDropBox;
	
	@FindBy(xpath="//li[@data-cy='GuestSelect$$_323']") 
	List<WebElement> noOfAdultList;
	
	@FindBy(xpath="//a[@class='close']")
	WebElement closeAdButton;
	//action methods
	
	public void closeAd() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			wait.until(ExpectedConditions.visibilityOf(closeAdButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", closeAdButton);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
	
	public void enterSenderRecipientDetails()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",sendViaEmail);
		
		scrollTo(scrollToEle);
		
		recipientName.sendKeys(randomString());
		rerecipientMobile.sendKeys(randomNumber());
		recipientEmail.sendKeys(wrongEmail());
		composeMsg.sendKeys(randomString());
		
		senderName.sendKeys(randomString());
		senderMobile.sendKeys(randomNumber());
		senderEmail.sendKeys(wrongEmail());
		
		buyNowButton.click();
	}
	
	public void getAlertMessage() throws Exception 
	{
		String user = "Recipient's alert: ";
		int r=1;
		for(WebElement alert:alertRedMsg)
		{
			String alertStr = alert.getText();
			System.out.println(user+alertStr);
			
			ExcelUtils et = new ExcelUtils(System.getProperty("user.dir") + "\\testdata\\test_data.xlsx");
			et.setCellData("Sheet1", r, 2, alertStr);
			r++;
			user="Sender's alert: ";
		}
	}
	
	public void clickOnHotels()
	{
//		scrollTo(hotelsIcon);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", hotelsIcon); 
	}
	
	public void getNumberOfPeople() throws Exception
	{
		String adult;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(adultDropBox));
		JavascriptExecutor js = (JavascriptExecutor) driver ; 
		js.executeScript("arguments[0].click();", adultsBox);
		//adultsBox.click();
		adultDropBox.click();
		System.out.println("------------------------------------");
		System.out.println("Displaying number of adults");
		System.out.println("------------------------------------");
		
		int r = 1;
		for(WebElement adultNo:noOfAdultList)
		{	
			adult = adultNo.getText();
			
			ExcelUtils et = new ExcelUtils(System.getProperty("user.dir") + "\\testdata\\test_data.xlsx");
			et.setCellData("Sheet1", r, 3, adult);
			r++;
			System.out.print(adult+",");
			
		}
	
	}
	
	
	//utility methods
	public String randomString()
	{
		String randomAlphabets = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabets;
	}
	
	public String randomNumber()
	{
		String randomNum = RandomStringUtils.randomNumeric(10);
		return randomNum;
	}
	
	public String wrongEmail()
	{
		String str = RandomStringUtils.randomAlphabetic(6);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+num+"gmail.com");
	}
	
	public void scrollTo(WebElement webElement)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}
}
