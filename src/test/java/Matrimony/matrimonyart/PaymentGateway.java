package Matrimony.matrimonyart;

import java.awt.Robot;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentGateway extends BaseTest
{


	Actions acc;
	String marital_statuswid;
	public static WebDriver driver;
	String marital_statusany;
	String marital_statussep5;
	String shwoprofilewith5;
	String marital_statussep6;
	String marital_statuswid5;
	String marital_statusdiv6;
	String marital_statuswid6;
	String marital_statusdiv5;
	 String marital_statussep;
	String marital_statusdiv;
	Boolean flag=false;
	int count = 0;
	@BeforeMethod
	public void setup() throws MalformedURLException 
	{
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","D:\\Java\\Window7\\First\\matrimonyart\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
//==================================================================================================//	
	@Test(enabled = true)
	public void setup6() throws Throwable 
	{
		searchPOM g = new searchPOM(driver);
		 acc = new Actions(driver);
		//Robot r = new Robot();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		Robot r = new Robot();

		//Open URL	
		Thread.sleep(3000);
		driver.get(BaseTest.getExcelsearchnep("Authenticate", 2, 3));
		driver.manage().window().maximize();
		
		//Enter Username and Password from Excel
		Thread.sleep(1000);
		BaseTest.click(g.getMatriID());
		BaseTest.typeData(g.getMatriID(), getExcelsearchnep("Authenticate", 2, 0));
		Thread.sleep(1000);
		BaseTest.click(g.getPasswordClear());
		BaseTest.typeData(g.getPassword(), getExcelsearchnep("Authenticate", 2, 1));
		
		//Click on the LoginButton
		Thread.sleep(3000);
		BaseTest.click(g.getLogin_btn());
		
		//Skip the intermediate page
		try {
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//a[@class='clr7']")));
			} catch (Exception e) {
				System.err.println("There is some Exception in the above Topic");
			}
			
		//Handling the Notification
			Thread.sleep(5000);
			Runtime.getRuntime().exec("D:\\Java\\Window7\\First\\matrimonyart\\Exe\\ClickNotification.exe");
			Thread.sleep(5000);
			
		//click on UPgrade
			String parent = driver.getWindowHandle();
			driver.findElement(By.xpath("(//*[text()='Upgrade'])[1]")).click();
			Set<String> child = driver.getWindowHandles();
			for (String string : child) 
			{
				if (!parent.equals(string)) 
				{
					driver.switchTo().window(string);
					System.out.println("New Window is Handeled");
					Thread.sleep(5000);
				}
			}
			
		//To find number of rows and columns
			FileInputStream fis = new FileInputStream("D:\\Java\\Window7\\First\\matrimonyart\\Excel\\upgrade.xlsx");
			 Workbook wb = WorkbookFactory.create(fis);
			 System.out.println("workbook is created");
			 Sheet sh = wb.getSheet(getExcelsearchnep("Authenticate", 2, 2));
			 System.out.println("inside sheet");
			 int rowCount = sh.getLastRowNum();
//			 System.out.println(sh.getFirstRowNum());
//			 System.out.println(sh.getPhysicalNumberOfRows());
//			 System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
			 
			
		//check the rates
			List<WebElement> Rates = driver.findElements(By.xpath("//*[@class='boldtxt font18']"));
//			for (int i = 0; i < Rates.size(); i++) 
//			{
//				//System.out.println(Rates.get(i).getText());
//				for (int j = 0; j < rowCount; j++) 
//				{
//					 short columnCount = sh.getRow(j).getLastCellNum();
//
//					for (int k = 0; k < columnCount; k++) 
//					{
//						if (sh.getRow(j).getCell(k).getStringCellValue().equals(Rates.get(i).getText())) 
//						{
//							System.out.println(sh.getRow(j).getCell(k).getStringCellValue());
//						}else
//						{
//							//System.out.println(sh.getRow(j).getCell(k).getStringCellValue());
//							//System.out.println("else part is activated");
//						}
//					}
//				}
//			}
			
			if (sh.getRow(1).getCell(1).getStringCellValue().equals(Rates.get(count).getText())) 
			{
				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
				count++;
			}else 
			{
				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
				count++;
			}
			
			if (sh.getRow(1).getCell(2).getStringCellValue().equals(Rates.get(count).getText())) 
			{
				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
				count++;
			}else 
			{
				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
				count++;
			}
			
			if (sh.getRow(2).getCell(1).getStringCellValue().equals(Rates.get(count).getText())) 
			{
				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
				count++;
			}else 
			{
				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
				count++;
			}
				
			if (sh.getRow(2).getCell(2).getStringCellValue().equals(Rates.get(count).getText())) 
			{
				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
				count++;
			}else 
			{
				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
				count++;
			}
			
			if (sh.getRow(3).getCell(1).getStringCellValue().equals(Rates.get(count).getText())) 
			{
				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
				count++;
			}else 
			{
				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
				count++;
			}
			
			if (sh.getRow(3).getCell(2).getStringCellValue().equals(Rates.get(count).getText())) 
			{
				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
				count++;
			}else 
			{
				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
				count++;
			}
			
			if (sh.getRow(4).getCell(1).getStringCellValue().equals(Rates.get(count).getText())) 
			{
				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
				count++;
			}else 
			{
				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
				count++;
			}
		
			
			
			
		
			
	

		}
	
}
