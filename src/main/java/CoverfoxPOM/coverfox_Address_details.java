package CoverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class coverfox_Address_details 
{
	@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement PincodeFiled;
	
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement MobileNumberFiled;
	
	@FindBy(xpath = "//div[text()='Continue']") private WebElement ContinueButtonClick; 	
	
	@FindBy(xpath ="//div[contains(text(),'valid pincode')]") private WebElement PinErrorMsg;
	
	 
	public coverfox_Address_details(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);	
	}
	
	public void EnterPincodeField(String Pincode) 
	{
		PincodeFiled.sendKeys(Pincode);		
	}
	
	public void EnterMobileNumber(String Mobnos)
	{
		MobileNumberFiled.sendKeys(Mobnos);
	}
	
	public void ClickOnContinueButton() 
	{
		ContinueButtonClick.click();
	}
	
	public boolean ValidatePinErrorMsg() 
	{
		boolean result = PinErrorMsg.isDisplayed();
		
		return result;
	}
	
	
}
