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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentGatewayAmoutCheck extends BaseTest
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
		driver.get(BaseTest.getExcelsearchnep("Authenticate", 3, 3));
		driver.manage().window().maximize();
		
		//Enter Username and Password from Excel
		Thread.sleep(1000);
		BaseTest.click(g.getMatriID());
		BaseTest.typeData(g.getMatriID(), getExcelsearchnep("Authenticate", 3, 0));
		Thread.sleep(1000);
		BaseTest.click(g.getPasswordClear());
		BaseTest.typeData(g.getPassword(), getExcelsearchnep("Authenticate", 3, 1));
		
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
			try {
				//Runtime.getRuntime().exec("D:\\Java\\Window7\\First\\matrimonyart\\Exe\\ClickNotification.exe");
				driver.findElement(By.xpath("(//*[text()='Upgrade'])[1]")).click();
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("no notification");
			}
			
			
		//click on UPgrade
			String parent = driver.getWindowHandle();
			Thread.sleep(3000);
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
			
			
		//open regional URL
			String URL = driver.getCurrentUrl();
			URL=URL+BaseTest.getExcelsearchnep("Authenticate", 3, 4);
			System.out.println(URL);
			driver.navigate().to(URL);
			
			
			
		//To find number of rows and columns
			FileInputStream fis = new FileInputStream("D:\\Java\\Window7\\First\\matrimonyart\\Excel\\upgrade.xlsx");
			 Workbook wb = WorkbookFactory.create(fis);
			 System.out.println("workbook is created");
			 Sheet sh = wb.getSheet(getExcelsearchnep("Authenticate", 3, 2));
			 System.out.println("inside sheet");
			 int rowCount = sh.getLastRowNum();
//			 System.out.println(sh.getFirstRowNum());
//			 System.out.println(sh.getPhysicalNumberOfRows());
//			 System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
			 
			
		//check the rates
			List<WebElement> Rates = driver.findElements(By.xpath("//*[@class='boldtxt font18']"));
			
			
			System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
			System.out.println(sh.getRow(1).getCell(1));
			System.out.println(Rates.get(count).getText());
			Rates.get(count).click();
			String ClickedAmt = Rates.get(count).getText();
//			if (sh.getRow(1).getCell(1).getStringCellValue().equals(Rates.get(count).getText())) 
//			{
//				System.out.println("Test data and the website are have same value '"+Rates.get(count).getText()+"'");
//				count++;
//			}else 
//			{
//				System.out.println("Test Data '"+sh.getRow(1).getCell(1).getStringCellValue()+"' value mismatches with the Website value'"+Rates.get(count).getText()+"'");
//				count++;
//			}
			
			
			driver.findElement(By.xpath("//*[@id='visaNri_vpc_CardNum']")).sendKeys("4444555555555555");
			WebElement cExpiryMonth = driver.findElement(By.xpath("//*[@id='visaNri_cardExpiryMonth']"));
			WebElement cExpiryYear = driver.findElement(By.xpath("//*[@id='visaNri_cardExpiryYear']"));
			Select s = new Select(cExpiryMonth);
			s.selectByVisibleText("11  (Nov)");
			s = new Select(cExpiryYear);
			s.selectByVisibleText("2022");
			driver.findElement(By.xpath("//*[@id='visaNri_vpc_CardSecurityCode']")).sendKeys("123");
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[@tabindex='13'])[1]")).click();
			
			
			Thread.sleep(20000);
			WebElement PayOptionAmt = driver.findElement(By.xpath("//*[@class='disblk padb10 font12']"));
			
			System.out.println(PayOptionAmt.getText());
			
			if (PayOptionAmt.getText().contains(ClickedAmt)) 
			{
				System.out.println("both the amount are same");
			}else 
			{
				System.out.println("Both the amount are different");
			}
			
			
		
			
			
			
		
			
	

		}
	
}
