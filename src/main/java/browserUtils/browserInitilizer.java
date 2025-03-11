package browserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//Author:Neelam
import frameworkUtils.resusableComponent;

public class browserInitilizer {
//	this function is used to launch the browser
	public static WebDriver driver;
	public static WebDriver readDriverUtils (String url) throws Exception{
		if (resusableComponent.browserType=="chrome") {
			System.setProperty(resusableComponent.chrome_exte, resusableComponent.chrome_path);
			 driver = new ChromeDriver();
			 		}
		else if(resusableComponent.browserType=="edge")
		{
			System.setProperty(resusableComponent.edge_exte, resusableComponent.edge_path);
			 driver = new EdgeDriver();
		}
		
		else {
			System.out.println("no correct browser type provided");
		}
		
		driver.get(url);
		return driver;
	}

	
}
