package CoverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Coverfox_Member_Details
{
	@FindBy(id = "Age-You") private WebElement agedropdown;
	
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	public Coverfox_Member_Details(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void HandleDropdown(String age) 
	{
		Select age1 = new Select(agedropdown);
		age1.selectByValue(age+ "y");
		
	}

	public void nextButtonclick() 
	{
		
		nextButton.click();
	}
	
}
