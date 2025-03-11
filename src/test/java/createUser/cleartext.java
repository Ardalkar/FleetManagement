package createUser;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class cleartext {

	
	@BeforeTest 
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.googleUrl);
	}
	
	@Test (priority=1)
	public static void performClear() throws Exception {
		
		
		SeleniumActions.clearTextfromTextbox();
	}
	 
	

	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.close();
	}
}
