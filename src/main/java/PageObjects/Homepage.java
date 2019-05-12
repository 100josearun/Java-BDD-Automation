package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Managers.FileReaderManager;

public class Homepage {
	
	WebDriver driver;
	FileReaderManager fileReaderObject;
	Select dropDown;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//span[@title='Cleartrip ']") 
	private WebElement PageTitle;
	
	@FindBy(how = How.ID, using = "FromTag") 
	private WebElement Origin;
	
	@FindBy(how = How.ID, using = "ToTag") 
	private WebElement Destination;
	
	@FindBy(how = How.CLASS_NAME, using = "calendar") 
	private WebElement Calendar;
	
	@FindBy(how = How.CLASS_NAME, using = "ui-datepicker-year") 
	private WebElement CalendarYear;
	
	@FindBy(how = How.CLASS_NAME, using = "nextMonth") 
	private WebElement NextMonth;
	
	@FindBy(how = How.CLASS_NAME, using = "ui-datepicker-month") 
	private WebElement Month;
	
	@FindBy(how = How.ID, using = "Childrens") 
	private WebElement ChildNumberDropDown;
	
	@FindBy(how = How.ID, using = "SearchBtn") 
	private WebElement FlightSearchButton;
	
	By LoaderInFlightSearch = By.className("loaderContainer");
	
	public String getText() {
		try{
		return PageTitle.getText();
		}catch(Exception e){
			String error = e.toString();
			e.printStackTrace();
			return error;
		}
	}
	
	public void navigateTo_HomePage() {
		driver.get(fileReaderObject.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void OriginSelection(String Code,String City){
		Origin.sendKeys(Code);
	    new WebDriverWait(driver, 5).until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath(".//*[@id='ui-id-1']//a[contains(.,'"+City+"')]")))
	                .click();
	}
	
	public void OriginDestinationSelection(String From,String To){
		try{
		Origin.sendKeys(From);
		Origin.sendKeys(Keys.TAB);
		Destination.sendKeys(To);
		Destination.sendKeys(Keys.TAB);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Element not displayed/Visible");
		}
	   
	}
	
	public void SearchFlightsButtonClick(){
		try{
			FlightSearchButton.click();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Element not displayed/Visible/Clickable");
		}
	}
	
	public void DropDownSelection(int count){
		try{
		Select dropDown = new Select(ChildNumberDropDown);
		dropDown.selectByValue(String.valueOf(count));
		}catch(Exception e){
			System.out.println("Element not displayed/Visible");
			e.printStackTrace();
		}
	}
	
	public void DatePicker(String DateOfTravel,int Days){
		
		//Format = 16/June/2005
		
		String TravelDate = DateOfTravel;
		String date,month,year;
		String caldate,calmonth,calyear;		

		String dateArray[]= TravelDate.split("/");
		date=dateArray[0];
		month=dateArray[1];
		year=dateArray[2];

 
		WebElement cal;
		cal=Calendar;
		calyear=CalendarYear.getText();
		
		//Selecting Year
		while (!calyear.equals(year)) 
		{
			NextMonth.click();
			calyear=CalendarYear.getText();
			System.out.println("Displayed Year::" + calyear);
		}
 
		calmonth=Month.getText();
		
		//Selecting Month
		while (!calmonth.equalsIgnoreCase(month)) 
		{
			NextMonth.click();
			calmonth=Month.getText();
		}
 
		cal=Calendar;
		
		//Selecting Date
		
		List<WebElement> rows,cols;
		rows=cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) 
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) 
			{
				caldate=cols.get(j).getText();
				if (caldate.equals(date)) 
				{
					cols.get(j).click();
					break;
				}
			}
		}
	}
	
	public void FlightSearchVerification(){
		try{
		new WebDriverWait(driver, 5).until(
		        ExpectedConditions.invisibilityOfElementLocated(LoaderInFlightSearch));
		Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getText(WebElement element){
		try{
			String text = element.getText();
			return text;
		}catch(Exception e){
			e.printStackTrace();
			return "Element not Visible/Displayed";
		}
	}
	

}
