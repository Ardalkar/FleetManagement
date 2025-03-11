package createUser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepositoriesUtils.readDatafromPropertFile;
import SeleniumUtils.SeleniumActions;
import browserUtils.browserInitilizer;
import frameworkUtils.resusableComponent;

public class amzon {

	@BeforeTest 
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.amzonUrl);
	}
	
	@Test (priority=1)
	public void getLinks() throws Exception {
		
		List <WebElement> links =browserInitilizer.driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
	}
	
	@Test (priority=2)
	public void CheckSearchboxEnableOrNo() throws Exception {
		//AmazonRepo_url is location of repository
		boolean result =browserInitilizer.driver.findElement(By.xpath(readDatafromPropertFile.readDataFromORFile(resusableComponent.AmazonRepo_url, "Search.input"))).isEnabled();
		System.out.println(result);
	}
	
	@Test (priority=3)
	public void Bestseller() throws Exception {
		
		browserInitilizer.driver.findElement(By.xpath(readDatafromPropertFile.readDataFromORFile(resusableComponent.AmazonRepo_url, "BestSeller.a"))).click();
		
		WebDriverWait wait = new WebDriverWait(browserInitilizer.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readDatafromPropertFile.readDataFromORFile(resusableComponent.AmazonRepo_url, "img.alt")))).click();
	}
	
	@Test (priority=4)
	public void ExpandMenuAndChooseoption() throws Exception {
		
		browserInitilizer.driver.findElement(By.xpath(readDatafromPropertFile.readDataFromORFile(resusableComponent.AmazonRepo_url, "menu.i"))).click();
		
		WebDriverWait wait = new WebDriverWait(browserInitilizer.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readDatafromPropertFile.readDataFromORFile(resusableComponent.AmazonRepo_url, "menu.bestSeller.a")))).click();
	}
	
	
	@AfterTest
	public void closebrowser()
	{
		browserInitilizer.driver.close();
	}
	
	
}
