package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Managers.WebDriverManager;
import PageObjects.Homepage;
import TestContext.TestContextDefinition;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
	
	WebDriver driver;
	Homepage homepage;
	TestContextDefinition textcontext;
	
	public HomePageSteps(TestContextDefinition context){
		textcontext = context;	
		textcontext.getWebDriverManager();
		driver = WebDriverManager.getDriver();
		homepage = context.getPageObjectManager().getHomePage();
	}
	
	@Given("^user is on Cleartrip Homepage$")
	public void user_is_on_Cleartrip_Homepage() throws Throwable {
		homepage.navigateTo_HomePage();
		String text = homepage.getText();
		Assert.assertEquals("Home", text);
	}

	@When("^user enters Origin and Destination$")
	public void user_enters_Origin_and_Destination(DataTable arg1) throws Throwable {
		List<Map<String, String>> tablemap = arg1.asMaps(String.class, String.class);
		for(Map<String, String> obj:tablemap){
		homepage.OriginDestinationSelection(obj.get("Origin"), obj.get("Destination"));
		}
	}

	@When("^Date as \"([^\"]*)\"$")
	public void date_as(String arg1) throws Throwable {
		System.out.println("Travel Date is>>>"+arg1);
		homepage.DatePicker(arg1, 20);
	}

	@When("^select (\\d+) Adult and (\\d+) Child$")
	public void select_Adult_and_Child(int arg1, int arg2) throws Throwable {
		homepage.DropDownSelection(arg2);
	}

	@When("^clicked on Search Flights button$")
	public void clicked_on_Search_Flights_button() throws Throwable {
		homepage.SearchFlightsButtonClick();
	}

	@Then("^Flight Search Results should be displayed$")
	public void flight_Search_Results_should_be_displayed() throws Throwable {
		homepage.FlightSearchVerification();
	}


}
