package createUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class uploadFile {

	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.radioURL);
		
	}
	
	@Test
	public static void performFileupload() throws Exception
	{
		
		
		SeleniumActions.uploadFile(readDatafromPropertFile.readDataFromORFile(resusableComponent.uploadURL,"Uploadfile.input"));
	}

	@Test
	public static void performRadio() throws Exception
	{
		SeleniumActions.handleRadioButton(1);
	}

	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.quit();
	}
	
}
