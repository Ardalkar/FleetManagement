package createUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class dropdown {

	
	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.url);
		
	}
	
	@Test
	public static void ddwork() throws Exception
	{
		SeleniumActions.ddpractice();
		
	}
		
	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.quit();
	}
}
