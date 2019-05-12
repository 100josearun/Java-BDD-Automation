package Managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {
	
	private static WebDriver driver;
	private static WebDriverManager webdriverManager = new WebDriverManager();
	private static String browser;

	private WebDriverManager() {
		
	}
	
	public static WebDriverManager getInstance() {
		return webdriverManager;
	}
		
	public static WebDriver getDriver() {
		if(driver==null) {
			driver= createDriver();
		}
		return driver;
	}
	
	public static WebDriver createDriver() {
		browser = FileReaderManager.getInstance().getConfigReader().getBrowser();
		
        switch (browser) {	    
        case "Firefox" : 
        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\"+FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	driver = new FirefoxDriver();
	    	break;
        case "Chrome" : 
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\"+FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	ChromeOptions chromeOptions = new ChromeOptions();
        	chromeOptions.addArguments("--disable-infobars");
        	chromeOptions.addArguments("--disable-notifications");
        	driver = new ChromeDriver(chromeOptions);
    		break;
        case "Internet_Explorer" : 
        	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\"+FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	DesiredCapabilities desiredCapability = DesiredCapabilities.internetExplorer();
        	desiredCapability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        	desiredCapability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        	driver = new InternetExplorerDriver(desiredCapability);
    		break;
        }
 
        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
        	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
	
	public String getPagetitle() {
		return driver.getTitle();
	}
 
	public void closeDriver() {
		driver.close();
		driver.quit();
	}	

}
