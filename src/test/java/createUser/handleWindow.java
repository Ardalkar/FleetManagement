package createUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class handleWindow {

	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.multipleWindow_url);
		
	}
	
	@Test
	public static void handleMultiplewindowa() throws Exception
	{
		//SeleniumActions.click("//button[@id=\"windowButton\"]");
		SeleniumActions.SwitchToNewWindow();
		
	}
	
	
	
	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.quit();
	}
}
