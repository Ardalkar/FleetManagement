package createUser;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import excelUtils.readDataFromExcel;
import frameworkUtils.resusableComponent;

public class handleAlert {

private static final Logger logger = Logger.getLogger(createUser.class);
	
	@BeforeTest 
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.Alert_path);
	}
	
	@Test (priority=1)
	public static void handleralert() throws Exception {
		
		SeleniumActions.click(readDatafromPropertFile.readDataFromORFile(resusableComponent.AlertRepository_path,"DeleteCustomer.Submit.input"));
		String alertmsg = SeleniumActions.AlertActions(true);
		System.out.println(alertmsg);
	}
	
	

	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.close();
	}
}
