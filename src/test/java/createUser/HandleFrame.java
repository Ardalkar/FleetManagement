package createUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class HandleFrame {

	

	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.frame_path);
		
	}
	
	@Test
	public static void handleFrameInselenium() throws Exception
	{
		
		SeleniumActions.frameAction("a077aa5e");
		SeleniumActions.click(readDatafromPropertFile.readDataFromORFile(resusableComponent.FrameRepository_path, "Frame.Jmeter.img"));
		
	}
	
	
	@AfterTest
	public void closebrowser()
	{
		//browserInitilizer.driver.quit();
	}
}
