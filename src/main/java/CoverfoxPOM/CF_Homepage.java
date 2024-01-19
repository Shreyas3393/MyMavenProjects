package CoverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CF_Homepage 
{
	@FindBy(xpath = "//div[text()='Male']") private WebElement Male_Button;
	
	public CF_Homepage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver,this);
	}
	
	
	public void maleButton() 
	{
		Male_Button.click();
	}
}

