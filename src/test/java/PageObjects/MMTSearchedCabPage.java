package PageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;

public class MMTSearchedCabPage extends BasePage{
	
	public MMTSearchedCabPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//label[text()='SUV']")
	WebElement filterSUV;
	
	@FindBy(xpath="//span[@class='appendTop5 makeFlex hrtlCenter']")
	List<WebElement> searchedCabsType;
	
	@FindBy(xpath="//p[@class='font28 latoBlack blackText ']")
	List<WebElement> searchedCabsPrice;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	public void clickOnSUV() {
		wait.until(ExpectedConditions.visibilityOf(filterSUV));
		filterSUV.click();
	}

	public boolean checkSUVs() {
		
		// To check only SUVs are being displayed
		
		boolean flag = true;
		
		if(searchedCabsType.size() < 1) {
			System.out.println("No results found");
			return false;
		}
		
		System.out.println(searchedCabsType.size()+" cab results found");
		
		for(WebElement var:searchedCabsType)
		{
			if(var.getText().contains("SUV"))
			{
				continue;
			} else {
				flag = false;
				System.out.println("Not an SUV");
			}
		}
		
		return flag;
	}

	public void lowestPrice() throws Exception {
		//convert list of web elements to string array
		String [] searchedCabsPriceText = new String[searchedCabsPrice.size()];
		int i = 0 ;
		for(WebElement element : searchedCabsPrice) {
			searchedCabsPriceText[i] = element.getText();
			i++;
		}
		int[] cabPricesInt = getPriceIntArray(searchedCabsPriceText);
		Arrays.sort(cabPricesInt);
		System.out.println("Searched cab Prices: "+Arrays.toString(cabPricesInt));
		
		//display lowest price
		System.out.println("Lowest prices: ");
		i = ((cabPricesInt.length) / 2) +1;
		int r = 1;
		ExcelUtils et = new ExcelUtils(System.getProperty("user.dir") + "\\testdata\\test_data.xlsx");
		for(int cab: cabPricesInt) {
			if(i>0) {
				i--;
				System.out.println(cab);
			} else {
				break;
			}
			String s = ""+cab;
			et.setCellData("Sheet1", r, 0, s);
			r++;
		}
	}

	public int[] getPriceIntArray(String[] searchedCabsPriceText) {
		int[] convertedToInteger = new int[searchedCabsPriceText.length];
		int i = 0;
		for(String str:searchedCabsPriceText)
		{	
			String [] amtArray;
			if(str.length() >= 7) {
				amtArray = str.substring(2).split(",");
				convertedToInteger[i] = Integer.parseInt(amtArray[0]+amtArray[1]);
			} else {
				convertedToInteger[i] = Integer.parseInt(str.substring(2));;
			}
			i++;
		}
		return convertedToInteger;
	}
}
