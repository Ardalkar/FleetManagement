package createUser;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import excelUtils.readDataFromExcel;
import frameworkUtils.resusableComponent;

public class handleWait {

	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.wait_url);
		
	}
	
	@Test
	public static void handlewaitforselenium() throws Exception
	{
		SeleniumActions.click(readDatafromPropertFile.readDataFromORFile(resusableComponent.WaitOR_path,"WaitsDemo.textbox1.button"));
		SeleniumActions.ImplicitWait(10);
		SeleniumActions.click(readDatafromPropertFile.readDataFromORFile(resusableComponent.WaitOR_path,"WaitsDemo.textbox.input"));
	}
	
	@Test
	public static void ExplicitHandle() throws Exception
	{
		SeleniumActions.click(readDatafromPropertFile.readDataFromORFile(resusableComponent.WaitOR_path,"WaitsDemo.textbox2.button"));
		SeleniumActions.ExplicitWait(50, "WaitsDemo.textbox.input");
		SeleniumActions.click(readDatafromPropertFile.readDataFromORFile(resusableComponent.WaitOR_path,"WaitsDemo.textbox.input"));
		
	}
	
	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.quit();
	}
	
}
