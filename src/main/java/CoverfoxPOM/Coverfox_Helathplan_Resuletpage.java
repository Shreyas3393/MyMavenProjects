package CoverfoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Coverfox_Helathplan_Resuletpage 
{
	
	@FindBy(xpath = "//div[contains(text(),'Insurance Plans')]") private WebElement TextofResultPage;
	@FindBy(id = "plans-list") private List<WebElement> PlanListDetails;
	
	public Coverfox_Helathplan_Resuletpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public int AvailablePlanNumberFromText() throws InterruptedException 
	{
			
		String txt = TextofResultPage.getText();
		
		String ar[] = txt.split(" ");
		
		String numofresultstring = ar[0];
		
		//Converting String Into Integer
		
		  int intigResult = Integer.parseInt(numofresultstring);
		  return intigResult;
		  
		  }
		  
	public int AvailablePlanNumberFromBanner() 
	{
		  
		   int TotalnumofPlans = PlanListDetails.size();
		   return TotalnumofPlans;
		   
	}
	
}
