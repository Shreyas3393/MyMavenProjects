package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersProg implements ITestListener 
{
	
	public void onTestSuccess(ITestResult result) 
	{
		
		String TCName = result.getName();
		Reporter.log("TC, " + TCName + " Is Completed Successfully", true);
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("TC, " +result.getName()+ " Is Skipped Please Check Dependant Method", true);
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC, " +result.getName()+ " Is Failed Please Check Again", true);
	}
	
		public void onTestStart(ITestResult result) 
		{
			Reporter.log("TC, " +result.getName()+ " Execution Is Started", true);
		}
}
