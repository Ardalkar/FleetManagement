package createUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;


public class pagination {

	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.pagination);
		
	}
	
	@Test
	public static void handlepagination() throws Exception
	{
		SeleniumActions .pagination();
	}
	
	
	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.quit();
	}
	
}
