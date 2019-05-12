package GenericTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Managers.WebDriverManager;

public class Faredetails {
	String URL = "https://www.cleartrip.com/flights/itinerary/68ddc88804-253b-4050-9342-e6bda2ff7ef7-1550481336491/review";
	static WebDriver driver;
	String Fare_Details = "//a[contains(text(),'fare details')]";
	String Window_Close = "close";
	String Frame_Name = "modal_window";
	
	String Fare_Breakup = "breakUp";
	String insurance = "insurance_fare_block";
	String Base_Fare = "//div[@id='breakUp']/dl[1]/dd/span[2]";
	
	@BeforeTest
	public void BeforeTestMethod(){
		driver = WebDriverManager.getInstance().getDriver();
		driver.get(URL);
	}
	
	@Test
	public void FareDetails() throws InterruptedException{
		driver.findElement(By.xpath(Fare_Details)).click();
		
		//Switching to frame
		driver.switchTo().frame(Frame_Name);
		getBaseFareDetails();
	}
	
	public void getBaseFareDetails() throws InterruptedException{
		WebElement FareBreakUp = driver.findElement(By.id(Fare_Breakup));
		if(!(FareBreakUp==null)){
			System.out.println(FareBreakUp.getText().toString()+" >>details are as follows<<\n\n");
			driver.switchTo().defaultContent();
			driver.findElement(By.id(Window_Close)).click();
			Thread.sleep(3000);
			
		}else{
			System.out.println("Fare Breakup Popup is not displayed");
		}
	}
	
	@AfterTest
	public void AfterTestMethod(){
		driver.close();
		driver.quit();
	}
	
}
