package createUser;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import excelUtils.readDataFromExcel;
import frameworkUtils.resusableComponent;
import org.apache.log4j.Logger;
@Listeners(ListenersUtils.Listeners.class)
public class createUser {
	private static final Logger logger = Logger.getLogger(createUser.class);
	
	@BeforeTest 
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.url);
	}
	
	@Test (priority=1)
	public static void ContactInformation() throws Exception {
		
		
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "ContactInformation.FirstName.input"), readDataFromExcel.fetchdatafromExcel(0,0));
		SeleniumActions.CaptureScreenshot("ContactInformation.FirstName");
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "ContactInformation.lastName.input"), readDataFromExcel.fetchdatafromExcel(0,0));
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "ContactInformation.phone.input"), readDataFromExcel.fetchdatafromExcel(0,0));
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "ContactInformation.email.input"), readDataFromExcel.fetchdatafromExcel(0,0));
	}
	
	@Test (priority=2)
	public static void MailingInformation() throws Exception {
		
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "MailingInformation.Address.input"), readDataFromExcel.fetchdatafromExcel(0, 0));
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "MailingInformation.city.input"), readDataFromExcel.fetchdatafromExcel(0, 0));
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "MailingInformation.state.input"), readDataFromExcel.fetchdatafromExcel(0, 0));
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "MailingInformation.postalcode.input"), readDataFromExcel.fetchdatafromExcel(0, 0));
		SeleniumActions.dropdown(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "MailingInformation.country.select"),"ANGOLA");
//		SeleniumActions.FetchAllOptionsFromdropdown();
	}
	@Test (priority=3)
	public static void UserInformation() throws Exception {
		
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "UserInformation.username.input"), readDataFromExcel.fetchdatafromExcel(0, 0));
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "UserInformation.password.input"), readDataFromExcel.fetchdatafromExcel(0, 0));
		SeleniumActions.sendkeys(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "UserInformation.confirmPassword.input"), readDataFromExcel.fetchdatafromExcel(0, 0));
		SeleniumActions.click(readDatafromPropertFile.readDataFromORFile(resusableComponent.registerOR_path, "UserInformation.Submit.input"));
	
	}
	
	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.close();
	}
	
}
