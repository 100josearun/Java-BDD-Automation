package StepDefinitions;

import org.openqa.selenium.WebDriver;
import Managers.WebDriverManager;
import cucumber.api.java.After;

public class Hookable{
	private WebDriver driver;
	
	@After("@Final")
	public void AfterHookMethod() {
		WebDriverManager.getInstance();
		driver = WebDriverManager.getDriver();
		driver.close();
		driver.quit();
	}

}
