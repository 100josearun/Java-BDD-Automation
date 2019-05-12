package TestContext;

import Managers.PageObjectManager;
import Managers.WebDriverManager;

public class TestContextDefinition {
	
	private PageObjectManager pageobject;
	private WebDriverManager webdriverobject;
	
	public TestContextDefinition() {
		webdriverobject = WebDriverManager.getInstance();
		pageobject = new PageObjectManager(webdriverobject.getDriver());
	}
	public PageObjectManager getPageObjectManager() {
		return pageobject;
	}
	
	public WebDriverManager getWebDriverManager() {
		return webdriverobject;
	}

}
