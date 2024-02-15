package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMTHomePage extends BasePage{

	public MMTHomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//li[@class='menu_Cabs']")
	WebElement cabIcon;
	
	@FindBy(xpath="//label[@for='fromCity']")
	WebElement fromCity;
	
	@FindBy(xpath="//span[@class='sr_city blackText' and text()='Delhi']")
	WebElement delhi;
	
	@FindBy(xpath="//label[@for='toCity']/..")
	WebElement toCityLabel;
	
	@FindBy(xpath="//div[@class='react-autosuggest__container react-autosuggest__container--open']//input")
	WebElement toCityInputBox;
	
	@FindBy(xpath="//span[@class='sr_city blackText' and text()='Manali, Himachal Pradesh, India']")
	WebElement toCityClick;
	
	@FindBy(xpath="//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Week'][2]//div[7]")
	WebElement fromDateClick;
	
	@FindBy(xpath="//ul[@class='newTimeSlotHrUl']//li//span[text()='06  Hr']")
	WebElement pickUpTimeHrClick;
	
	@FindBy(xpath="//ul[@class='newTimeSlotMinUl']//li//span[text()='30  min']")
	WebElement pickUpTimeMinClick;
	
	@FindBy(xpath="//ul[@class='newTimeSlotMerUl']//span[text()='AM']")
	WebElement pickUpTimeAPClick;
	
	@FindBy(xpath="//span[@class='applyBtnText']")
	WebElement pickUpTimeApplyButton;
	
	@FindBy(xpath="//a[text()='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[@class='close']")
	WebElement closeAdButton;
	
	
	
	//action methods substring method
	
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
	
	public void clickOnCab() {
		cabIcon.click();
	}
	
	public void enterFromCity() {
		fromCity.click();
		delhi.click();
	}
	
	public void enterToCity() {
		toCityLabel.click();
		toCityInputBox.sendKeys("Manali, Himachal Pradesh, India");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(toCityClick));
		toCityClick.click();
	}
	
	public void enterStartDate() {
		fromDateClick.click();
	}
	
	public void enterPickUpTime() {
		pickUpTimeHrClick.click();
		pickUpTimeMinClick.click();
		pickUpTimeAPClick.click();
		pickUpTimeApplyButton.click();
	}

	public void searchVehicleBtn() {
		searchButton.click();
	}

	

}














