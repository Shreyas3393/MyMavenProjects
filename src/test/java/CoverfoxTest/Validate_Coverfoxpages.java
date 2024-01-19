package CoverfoxTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CoverfoxBase.BaseClass;
import CoverfoxPOM.CF_Homepage;
import CoverfoxPOM.Coverfox_Health_Plan;
import CoverfoxPOM.Coverfox_Helathplan_Resuletpage;
import CoverfoxPOM.Coverfox_Member_Details;
import CoverfoxPOM.coverfox_Address_details;
import CoverfoxUtility.UtilityClass;


@Listeners(listeners.Listeners_CF.class)
public class Validate_Coverfoxpages extends BaseClass  

{	
		CF_Homepage hm1;  
		Coverfox_Health_Plan chp1;
		Coverfox_Member_Details cmd;
		coverfox_Address_details cad;
		Coverfox_Helathplan_Resuletpage chr;
		
		@BeforeClass
		public void launchbrowsers() throws InterruptedException 
		{
			LaunchCoverfox();
			hm1=new CF_Homepage(driver);
			chp1= new Coverfox_Health_Plan(driver);
			cmd=new Coverfox_Member_Details(driver);
			cad=new coverfox_Address_details(driver);
			chr=new Coverfox_Helathplan_Resuletpage(driver);
			
			Reporter.log("Opening Browser", true);
		}
		
		@BeforeMethod
		public void EnterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException 
		{
			Reporter.log("Clicking On gender Button", true);
			hm1.maleButton();
			
			Thread.sleep(1000);
			Reporter.log("Clicking On next Button", true);
			chp1.ClickonNextButton();
			Thread.sleep(2000);
			
			Reporter.log("Handling Age Dropdown", true);
			cmd.HandleDropdown(UtilityClass.ReaddatafromPropertiesclass("Age"));
			Thread.sleep(2000);
			
			Reporter.log("Clicking On next Button", true);
			cmd.nextButtonclick();
			Thread.sleep(2000);
			
			Reporter.log("Enter Pincode", true);
			cad.EnterPincodeField(UtilityClass.ReaddatafromPropertiesclass("Pincode"));
			Thread.sleep(2000);
			
			Reporter.log("Enter Mobile Number", true);
			cad.EnterMobileNumber(UtilityClass.ReaddatafromPropertiesclass("MobileNo"));
			Thread.sleep(2000);
			
			Reporter.log("Clicking On Continue Button", true);
			cad.ClickOnContinueButton();
			Thread.sleep(2000);
		
				
		}
		
		@Test
		public void ValidateTestPlanFromTextAndBanner() throws InterruptedException, IOException 
		{
			
		Thread.sleep(5000);
		Reporter.log("Fatching Number Of Result From Page", true);
		int textResult = chr.AvailablePlanNumberFromText();
		Thread.sleep(7000);
		int bannerResult = chr.AvailablePlanNumberFromBanner();
		Thread.sleep(7000);	
		
		Assert.assertEquals(textResult, bannerResult,"Text Result is  equals to banner Result,TC Failed");
		Reporter.log("Test Case Is Pass", true);
		
		}
		
		@AfterMethod
		public void closingBrowser () throws InterruptedException 
		{
			Reporter.log("Closing Browser Method", true);
			Thread.sleep(10000);
			CloseBrowser();
		}
	}
