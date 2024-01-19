package CoverfoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseClass
{
	
	protected static WebDriver driver;
	//Open Browser
	public void LaunchCoverfox() throws InterruptedException 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching Browser", true);
		driver.get("https://www.coverfox.com/");
		Thread.sleep(1000);
	}
	
	public void  CloseBrowser() throws InterruptedException 
	{
		Reporter.log("Closing Browser", true);
		Thread.sleep(1000);
		driver.close();
	}

}
