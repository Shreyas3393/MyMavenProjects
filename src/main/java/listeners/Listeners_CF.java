package listeners;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import CoverfoxBase.BaseClass;
import CoverfoxUtility.UtilityClass;

public class Listeners_CF extends BaseClass implements ITestListener
{

	public void onTestFailure(ITestResult result) {
		try {
			UtilityClass.Takescreenshot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onTestSuccess(ITestResult result) 
	{
		
	}	
	
	public void onTestSkipped(ITestResult result) 
	{
		
	}
	

}
