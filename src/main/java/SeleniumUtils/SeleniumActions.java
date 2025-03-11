package SeleniumUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class SeleniumActions {

	public static String AlertActions(boolean flag)
	{
		
		Alert alert = browserInitilizer.driver.switchTo().alert();
		String msg = alert.getText();
		System.out.println(msg);
		if(flag= true)
		{
			alert.accept();
		}
		else
			alert.dismiss();
		return msg;
	}
	
	public static void sendkeys(String xpath, String value)
	{
		browserInitilizer.driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	public static void dropdown(String xpath, String ddvalue)
	{
		WebElement dd = browserInitilizer.driver.findElement(By.xpath(xpath));
		Select sel = new Select(dd);
		sel.selectByContainsVisibleText(ddvalue);
//		sel.selectByIndex(1);
//		sel.selectByValue("AMERICAN SAMOA");
		
	}
	
	public static void FetchAllOptionsFromdropdown()
	{
		List<WebElement> list = browserInitilizer.driver.findElements(By.xpath("//select[@name='country']//option") );
		for (int i = 0; i < list.size(); i++) {		
			String Options = list.get(i).getText();
			System.out.println(Options);
			
//			if (Options=="ANDORRA" || Options=="BAHAMAS" || Options=="EGYPT") {
//				
//			}
		}
		
	}
	
	public static void ImplicitWait(int time)
	{
		browserInitilizer.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void ExplicitWait(int time, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(browserInitilizer.driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	public static void CaptureScreenshot(String name) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)browserInitilizer.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\MyTrainingProjectGithub\\batch50-main\\batch50-main\\FleetManagemnet\\FleetManagemnet\\Screenshot\\"+name+".png"));
		
	}
	public static void frameAction(String frameid) throws Exception
	{
		browserInitilizer.driver.switchTo().frame(frameid);
	}
	
	//dataTable
	public static void fetchvaluesFromdatatable() throws Exception
	{
		List<WebElement> rows = browserInitilizer.driver.findElements(By.xpath("//table[@class=\"dataTable\"]//tr"));
		
	}
	
	//WindowsHandling
	public static void SwitchToNewWindow() throws Exception
	{
		WebElement ele= browserInitilizer.driver.findElement(By.xpath("//button[@id='tabButton']"));
		JavascriptExecutor js=(JavascriptExecutor)browserInitilizer.driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		ele.click();
		
		String PID = browserInitilizer.driver.getWindowHandle();
		System.out.println(PID);
		
		Set<String> ChildID =  browserInitilizer.driver.getWindowHandles();
		System.out.println(ChildID);
		
		for(String id:ChildID)
		{
			if(!id.equals(PID))
				
			{
				browserInitilizer.driver.switchTo().window(id);
				break;
			}
		}
		String data= browserInitilizer.driver.getTitle();
		System.out.println(data);
	}
	
	public static void ActionOnCalender() throws Exception
	{
		browserInitilizer.driver.findElement(By.xpath("//input[@name=\"bdaytime\"]")).sendKeys("12/01/1997");
		browserInitilizer.driver.findElement(By.xpath("//input[@name='bdaytime']")).sendKeys(Keys.TAB);
		browserInitilizer.driver.findElement(By.xpath("//input[@name='bdaytime']")).sendKeys("02:45PM");
			
	}
	public static void pagination() throws Exception
	{
			List<WebElement> list =browserInitilizer.driver.findElements(By.xpath("//a[@class='page-numbers']"));
			for (int i = 0; i < list.size(); i++) {
				if(i==6)
				{
					list.get(i).click();
				}
			}
	}
	
	public static void uploadFile(String path) throws Exception
	{
		
		WebElement ele = browserInitilizer.driver.findElement(By.xpath(path));
		File file = new File("C:\\MyTrainingProjectGithub\\batch50-main\\batch50-main\\FleetManagemnet\\FleetManagemnet\\fileupload\\data.txt");
		ele.sendKeys(file.getAbsolutePath());
		
	}
	
	public static void handleRadioButton(int ele) throws Exception
	{
		
		List<WebElement> listbtns =browserInitilizer.driver.findElements(By.xpath("//input[@class='form-check-input']"));
		int size = listbtns.size();
		
		for (int i = 0; i < size; i++) {
			if(i == ele)
			{
				listbtns.get(i).click();
			}
		}
	}
	@Test
	public static void click(String xpath)
	{
		browserInitilizer.driver.findElement(By.xpath(xpath)).click();
	}
	@Test
	public static void clearTextfromTextbox() throws Exception
	{
		browserInitilizer.driver.findElement(By.xpath(readDatafromPropertFile.readDataFromORFile(resusableComponent.AmazonRepo_url,"google.search"))).sendKeys("mobile");
		browserInitilizer.driver.findElement(By.xpath(readDatafromPropertFile.readDataFromORFile(resusableComponent.AmazonRepo_url,"google.search"))).clear();
			
		
	}
	@Test
	public static void ddpractice() throws Exception
	{
		List<WebElement> ddoptions = browserInitilizer.driver.findElements(By.xpath("//select[@name=\"country\"]//option"));
		System.out.println(ddoptions.size());
		
		for(int i=1;i<=ddoptions.size()-1;i++)
		{
			
			System.out.println(ddoptions.get(i).getText());
		}
	}
	
	@Test
	public static void runheadless() throws Exception
	{
		
	}
}
