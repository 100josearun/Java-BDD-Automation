package GenericTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Managers.WebDriverManager;

public class WindowSwitchTest extends Faredetails{
			
	
		
	@Test(enabled=false)
	public void TestMethod() throws InterruptedException{
		driver.findElement(By.xpath(Fare_Details)).click();
		
		//Switching to frame
		driver.switchTo().frame(Frame_Name);
		String captured_text = driver.findElement(By.id(insurance)).getText().toString();
		System.out.println("Displayed text is>>"+captured_text);
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id(Window_Close)).click();
		Thread.sleep(3000);
	}
	
	
	
}
