package createUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class calender {

	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.Calender_url);
		
	}
	
	@Test
	public static void Calender() throws Exception
	{
		SeleniumActions.ActionOnCalender();
		
	}
		
	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.quit();
	}
}
