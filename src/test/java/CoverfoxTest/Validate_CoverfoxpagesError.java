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

import com.sun.net.httpserver.Authenticator.Result;
import CoverfoxBase.BaseClass;
import CoverfoxPOM.CF_Homepage;
import CoverfoxPOM.Coverfox_Health_Plan;
import CoverfoxPOM.Coverfox_Helathplan_Resuletpage;
import CoverfoxPOM.Coverfox_Member_Details;
import CoverfoxPOM.coverfox_Address_details;
import CoverfoxUtility.UtilityClass;


@Listeners(listeners.Listeners_CF.class)
public class Validate_CoverfoxpagesError extends BaseClass  

{	
		CF_Homepage hp;  
		Coverfox_Health_Plan chp1;
		Coverfox_Member_Details cmd1;
		coverfox_Address_details cad1;
		
	
		@BeforeClass
		public void LaunchBrowser() throws InterruptedException 
		{
			LaunchCoverfox();
			hp = new CF_Homepage(driver);
			chp1 = new Coverfox_Health_Plan(driver);
			cmd1 = new Coverfox_Member_Details(driver);
			cad1 = new coverfox_Address_details(driver);
		}
		
		@BeforeMethod
		public void EnterUserDetails() throws InterruptedException, EncryptedDocumentException, IOException 
		{
			hp.maleButton();
			Thread.sleep(1000);
			chp1.ClickonNextButton();
			Thread.sleep(1000);
			cmd1.HandleDropdown(UtilityClass.ReaddatafromPropertiesclass("Age"));
			Thread.sleep(1000);
			cmd1.nextButtonclick();
			Thread.sleep(1000);
			cad1.EnterMobileNumber(UtilityClass.ReaddatafromPropertiesclass("MobileNo"));
			Thread.sleep(1000);
			cad1.ClickOnContinueButton();
			Thread.sleep(1000);
			
		}
		
		@Test
		public void pincoderrormsg() 
		{
			Reporter.log("Validate PinCode Error Msg", true);
			boolean result = cad1.ValidatePinErrorMsg();
			
			Assert.assertTrue(result,"Pincode Error Msg Is Not Displayed,Tc failed");
			Reporter.log("Test case Is passed", true);
			
		}
		
		
		@AfterMethod
		public void closingBrowser () throws InterruptedException 
		{
			Reporter.log("Closing Browser Method", true);
			Thread.sleep(7000);
			CloseBrowser();
		}
	}
