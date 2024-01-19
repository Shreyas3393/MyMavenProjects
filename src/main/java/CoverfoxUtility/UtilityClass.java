package CoverfoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;


public class UtilityClass 
{

	public static String ReaddatafromExcel(int row,int cell) throws EncryptedDocumentException, IOException 
	{
		Reporter.log("Reading data from Excel", true);
		
		FileInputStream myfile = new FileInputStream("C:\\Users\\Shree\\Desktop\\ExcelProgram\\coverfox.xlsx");
		Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
		String data = mysheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public static void Takescreenshot(WebDriver driver,String TCID) throws IOException 
	{
		Reporter.log("Taking Screenshot", true);
		//String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest= new File("C:\\Users\\Shree\\Desktop\\desktopfiles\\Screenshots\\coverfox"+TCID+".png");
		Reporter.log("Saved Screenshot at "+dest, true);
		
		FileHandler.copy(src, dest);
	}
	
		
	public static String ReaddatafromPropertiesclass(String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream myfile= new FileInputStream(System.getProperty("user.dir")+"\\Coverfoxes.properties");
		
		prop.load(myfile);
		String value = prop.getProperty(key);
		
		return value;
		
		
	}
	
}

