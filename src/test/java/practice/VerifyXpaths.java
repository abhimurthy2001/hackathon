package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyXpaths {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		WebElement closeAdButton = driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
		wait.until(ExpectedConditions.visibilityOf(closeAdButton));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", closeAdButton);
		driver.switchTo().defaultContent();
		
		
//		driver.findElement(By.xpath("//div[class=\"wrapper-outer\"]")).click();
		
		driver.findElement(By.xpath("//li[@class='menu_Cabs']")).click();
		
//		Actions act = new Actions(driver);
//		act.click(driver.findElement(By.xpath("//label[@for=\"fromCity\"]"))).build().perform();
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		
		//click on input //div[@class='autoSuggestPlugin hsw_autocomplePopup']
		
		//click on delhi //span[@class='sr_city blackText' and text()='Delhi']
		driver.findElement(By.xpath("//span[@class='sr_city blackText' and text()='Delhi']")).click();
		
		//click on to city //label[@for='toCity']
		driver.findElement(By.xpath("//label[@for='toCity']/..")).click();
		
		//search manali in input //div[@class='react-autosuggest__container react-autosuggest__container--open']//input
		driver.findElement(By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']//input")).sendKeys("Manali, Himachal Pradesh, India");
		
		//click on manali hp //span[@class='sr_city blackText' and text()='Manali, Himachal Pradesh, India']
		driver.findElement(By.xpath("//span[@class='sr_city blackText' and text()='Manali, Himachal Pradesh, India']")).click();
		
		//click on date label //div[@class='csw_inputBox dates increaseHeight'] not necessary
		//driver.findElement(By.xpath("//div[@class='csw_inputBox dates increaseHeight']")).click();
		
		//enter departure date //div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Week'][2]//div[7]
		driver.findElement(By.xpath("//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Week'][2]//div[7]")).click();
		
		//enter pick up hour //ul[@class='newTimeSlotHrUl']//li//span[text()='06  Hr']
		driver.findElement(By.xpath("//ul[@class='newTimeSlotHrUl']//li//span[text()='06  Hr']")).click();
		
		//enter pick up minute //ul[@class='newTimeSlotMinUl']//li//span[text()='30  min']
		driver.findElement(By.xpath("//ul[@class='newTimeSlotMinUl']//li//span[text()='30  min']")).click();
		
		//enter pick up AM/PM //ul[@class='newTimeSlotMerUl']//span[text()='AM']
		driver.findElement(By.xpath("//ul[@class='newTimeSlotMerUl']//span[text()='AM']")).click();
		
		//click on apply button //span[@class='applyBtnText']
		driver.findElement(By.xpath("//span[@class='applyBtnText']")).click();
		
		//click on search button //a[text()='Search']
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		//click on suv in filters
		driver.findElement(By.xpath("//label[text()='SUV']")).click();
		
		//list of cab prices
		List<WebElement> cabPrices = driver.findElements(By.xpath("//p[@class='font28 latoBlack blackText ']"));
		System.out.println("Cab prices: ");
		for(WebElement ele: cabPrices)
		{
			System.out.println(ele.getText());
		}
		
		//click on gift cards
		driver.findElement(By.xpath("//li[@class='menu_More moreItem']")).click();
		driver.findElement(By.xpath("//a[@class=\"appendBottom5 blackText\" and text()='Giftcards']")).click();
		
		
	}
	
}
