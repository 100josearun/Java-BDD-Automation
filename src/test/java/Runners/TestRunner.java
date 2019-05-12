package Runners;

import java.io.File;
import org.junit.AfterClass;
import com.cucumber.listener.Reporter;
import Managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		/*plugin= {"pretty","usage"},*/
		format= {"pretty","html:target/Cucumber_Reports",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
				"json:target/Cucumber_Reports/cucumber.json",
				"junit:target/Cucumber_Reports/cucumber.xml"/*.json and .xml are post processed by CI servers/3d party tools like Cucumber-Jenkins
				for visual reports*/
		},
		monochrome=true,
		features="src/test/resources/Features",
		glue="StepDefinitions",
		dryRun=false
		)
public class TestRunner extends AbstractTestNGCucumberTests{

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User_Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Project_Directory", System.getProperty("user.dir"));
	    Reporter.setSystemInfo("Selenium_Version", "3.7.0");
	    Reporter.setSystemInfo("Maven_Version", "3.5.2");
	    Reporter.setSystemInfo("Java_Version", "1.8.0_181");
	}
	
}
