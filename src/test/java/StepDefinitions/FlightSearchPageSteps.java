package StepDefinitions;

import org.openqa.selenium.WebDriver;
import Managers.WebDriverManager;
import PageObjects.FlightSearchResultsPage;
import TestContext.TestContextDefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightSearchPageSteps {
	
	WebDriver driver;
	FlightSearchResultsPage searchresults;
	TestContextDefinition textcontext;
	
	public FlightSearchPageSteps(TestContextDefinition context){
		textcontext = context;	
		textcontext.getWebDriverManager();
		driver = WebDriverManager.getDriver();
		searchresults = context.getPageObjectManager().getFlightSearchResultsPage();
	}
	
	@Given("^user is on Flight Search results page$")
	public void user_is_on_Flight_Search_results_page() throws Throwable {
		searchresults.FlightSearchResultDisplay();
	}

	@When("^user hover on \"([^\"]*)\", Only text should be displayed$")
	public void user_hover_on_Only_text_should_be_displayed(String arg1) throws Throwable {
		searchresults.FilteringFlightResults();
	}

	@When("^when user click on Only button$")
	public void when_user_click_on_Only_button() throws Throwable {
		System.out.println("\n\n\t*******Displaying Filtered Flight Results*******\n\n\t");
		searchresults.FlightSearchResultDisplay();
	}

	@Then("^Flights of SpiceJet should be filtered and displayed$")
	public void flights_of_SpiceJet_should_be_filtered_and_displayed() throws Throwable {
		System.out.println("\n\n\t*******Displaying No Baggage Flights On Console*******\n\n\t");
		searchresults.DisplayingNoBaggageFlights();
	}

	@Then("^Flights with no checkin baggage should be displayed as well$")
	public void flights_with_no_checkin_baggage_should_be_displayed_as_well() throws Throwable {
		//searchresults.FlightBooking();
		driver.quit();
	}

}
