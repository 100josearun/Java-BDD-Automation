package Managers;

import org.openqa.selenium.WebDriver;
import PageObjects.FlightSearchResultsPage;
import PageObjects.Homepage;

public class PageObjectManager {
	
	private WebDriver driver;
	private Homepage homepage;
	private FlightSearchResultsPage flightsearchresults;
 
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
 
	public Homepage getHomePage() {
		return (homepage == null) ? homepage = new Homepage(driver) : homepage;
	}
	
	public FlightSearchResultsPage getFlightSearchResultsPage() {
		return (flightsearchresults == null) ? flightsearchresults = new FlightSearchResultsPage(driver) : flightsearchresults;
	}

}
