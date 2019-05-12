package GenericTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Managers.WebDriverManager;

public class FlightSearchDetails {
	
	private String URL = "https://www.cleartrip.com/flights/results?from=DEL&to=BOM&depart_date=16/06/2019&adults=1&childs=1&infants=0&class=Economy&airline=&carrier=&intl=n&sd=1550556365357&page=loaded";
	private String Search_Results_Grid_View = "//ul[@class='listView flights']/li";
	private String loader = "//div[@class='progress']";
	private WebDriver driver;
	private WebDriverWait mywait;
	
	@BeforeTest
	public void beforeTestMethod(){
		driver = WebDriverManager.getInstance().getDriver();
		mywait = new WebDriverWait(driver,20);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMethod() throws InterruptedException{
		driver.get(URL);
		mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loader)));
		FlightResultsCapture();
	}
	
	@AfterTest
	public void afterTestMethod(){
		
	}
	
	public void FlightResultsCapture() throws InterruptedException{
		List<WebElement> elements = driver.findElements(By.xpath(Search_Results_Grid_View));
		System.out.println("Going to click on element");
		elements.get(0).click();
		System.out.println("Element click performed");
	}
	
	public void FareRuletabClick(){
		
	}

}
