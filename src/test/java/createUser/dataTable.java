package createUser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class dataTable {

	
	@BeforeTest 
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.datatable_url);
	}
	
	@Test (priority=1)
	public static void handleDataTable() throws Exception {
		
		List<WebElement> tr = browserInitilizer.driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		System.out.println("length of the datatable" +tr.size());//25
		for (int i = 1; i<tr.size(); i++) {
			
			List<WebElement> td	= browserInitilizer.driver.findElements(By.xpath("//table[@class='dataTable']//tr["+i+"]//td"));
			for (int j = 1; j <= td.size(); j++) 
			{				
			String CompanyData =browserInitilizer.driver.findElement(By.xpath("//table[@class='dataTable']//tr["+i+"]//td["+j+"]")).getText();
			System.out.println("data for row ["+i+"] is :"  +CompanyData);
			//System.out.println(CompanyData);
			}
		
		
		}
		
	}
	
	

	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.close();
	}
}
