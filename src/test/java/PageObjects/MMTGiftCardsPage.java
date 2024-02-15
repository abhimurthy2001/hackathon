package PageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;

public class MMTGiftCardsPage extends BasePage{

	public MMTGiftCardsPage(WebDriver driver) {
		super(driver);
	}
	
	// @FindBy(xpath="//li[@class='menu_More moreItem']") WebElement moreIcon;
	
	@FindBy(xpath="//li[@class='choosFrom__list--item'][5]")
	WebElement giftCards;
	
	@FindBy(xpath="//div[@class='card__details text-center']//h3[text()='Wedding Gift Card']")
	WebElement weddingGiftCardText;
	
	@FindBy(xpath="(//div[@class='card__data'])[1]")
	WebElement weddingGiftCardClick;
	
	@FindBy(xpath="//a[@class='close']")
	WebElement closeAdButton;
	
	
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
	
	public void giftCardsClick() {
		giftCards.click();
		Set<String> window_handles = driver.getWindowHandles();
		
		for(String win : window_handles) {
			driver.switchTo().window(win);
			String title = driver.getTitle();
			
			if(title.contains("Gift Cards")) {
				break;
			}
		}
	}
	
	public void weddingGiftCardClick() throws Exception {
		scrollTo(weddingGiftCardClick);
		String giftCardName = weddingGiftCardText.getText();
		ExcelUtils et = new ExcelUtils(System.getProperty("user.dir") + "\\testdata\\test_data.xlsx");
		et.setCellData("Sheet1", 1, 1, giftCardName);
		System.out.println(giftCardName);
		weddingGiftCardClick.click();
	}
	
	public void scrollTo(WebElement webElement)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}
	
}
