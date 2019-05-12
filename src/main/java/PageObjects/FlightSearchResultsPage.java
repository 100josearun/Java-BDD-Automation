package PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchResultsPage {
	
	WebDriver driver;
	Actions action;
	
	public FlightSearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//form[@id='flightForm']//nav/ul[contains(@class,'listView')]/li") 
	private List<WebElement> FlightSearchData;
	
	@FindBy(how = How.XPATH, using = "//label[contains(@for,'1_1_SG')]//span[contains(@class,'span span18 truncate')][contains(text(),'SpiceJet')]") 
	private WebElement SpiceJetCheckBox;
	
	@FindBy(how = How.XPATH, using = "//label[contains(@for,'1_1_SG')]//a[contains(@class,'showOnly weak')][contains(text(),'Only')]") 
	private WebElement OnlyTextIdentifier;
	
	@FindBy(how = How.XPATH, using = "//form[@id='flightForm']//nav/ul[contains(@class,'listView')]/li//div/span[contains(@class,'noBaggage')]") 
	private List<WebElement> NoBaggage;
	
	By BookingButton  = By.xpath("//button[contains(@type,'submit')][contains(text(),'Book')]");
	
	public void FlightSearchResultDisplay(){
		try{
		for(WebElement result:FlightSearchData){
			System.out.println(result.getText());
		}
		}catch(Exception e){
			e.toString();
		}
	}
	
	public void FilteringFlightResults(){
		try {
			action = new Actions(driver);
			action.moveToElement(SpiceJetCheckBox).build().perform();
			Thread.sleep(2000);
			OnlyTextIdentifier.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DisplayingNoBaggageFlights(){
		try {
			System.out.println("Number of Flights with No Baggage>>"+NoBaggage.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void FlightBooking(){
		try {
			NoBaggage.get(0).findElement(BookingButton).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
