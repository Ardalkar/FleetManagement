package createUser;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class redbus {

	@BeforeTest
	public static void launchBrowser() throws Exception {
		browserInitilizer.readDriverUtils(resusableComponent.redbus);
		
	}
	

	@Test
	public static void busbookings() throws Exception
	{
		
		//GoToInputboxFrom-->InputCity-->selectOneCityfromList
		WebElement fromTab=browserInitilizer.driver.findElement(By.xpath("//input[@id='src']"));
		fromTab.sendKeys("pune");
		List<WebElement> searchResultsOfFrom = browserInitilizer.driver.findElements(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']//li"));
		for (int i = 1; i < searchResultsOfFrom.size(); i++) {
			if(!searchResultsOfFrom.isEmpty())
			{
//				WebElement data = searchResults.getLast();
//				System.out.println(data);
				searchResultsOfFrom.getLast().click();
				break;
			}
			else
				System.out.println("Buses not found..!!");
		}
		
		WebElement toTab=browserInitilizer.driver.findElement(By.xpath("//input[@id='dest']"));
		toTab.sendKeys("mumbai");
		
		List<WebElement> searchResultsOfTo = browserInitilizer.driver.findElements(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']//li"));
		for (int i = 1; i < searchResultsOfTo.size(); i++) {
			if(!searchResultsOfTo.isEmpty())
			{
//				WebElement data = searchResults.getLast();
//				System.out.println(data);
				searchResultsOfTo.get(1).click();
				//searchResultsOfTo.getFirst().click();
				break;
			}
			else
				System.out.println("Buses not found..!!");
		}
		
		WebElement Date=browserInitilizer.driver.findElement(By.xpath("//div[@class='sc-kAzzGY jiFglw']"));
		Date.click();

//		// Get the current date
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
//        String formattedDate = currentDate.format(formatter);
//
        WebDriverWait wait = new WebDriverWait(browserInitilizer.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sc-kAzzGY jiFglw']")));
        element.click();
        		
	}
	
	
	@AfterTest
	public void closebrowser()
	{
		//browserInitilizer.driver.quit();
	}
	
}
