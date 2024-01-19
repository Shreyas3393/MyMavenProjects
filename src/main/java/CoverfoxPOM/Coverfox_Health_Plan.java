package CoverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Coverfox_Health_Plan
{
		@FindBy(className ="next-btn") private WebElement Next_Button;
		
		public Coverfox_Health_Plan(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
			
		}
		
		public void ClickonNextButton() 
		{
			
			Next_Button.click();
		}
}
