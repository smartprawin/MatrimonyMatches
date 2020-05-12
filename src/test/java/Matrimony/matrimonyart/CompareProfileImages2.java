package Matrimony.matrimonyart;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompareProfileImages2 extends BaseTest
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
	
	
	@Test
	public void setup6() throws Throwable 
	{
		searchPOM g = new searchPOM(driver);
		 acc = new Actions(driver);
		Robot r = new Robot();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js  = (JavascriptExecutor)driver;

		//Open URL	
		Thread.sleep(3000);
		driver.get(BaseTest.getExcelsearchnep("Authenticate", 4, 3));
		driver.manage().window().maximize();
		
		//Enter Username and Password from Excel
		Thread.sleep(1000);
		BaseTest.click(g.getMatriID());
		BaseTest.typeData(g.getMatriID(), getExcelsearchnep("Authenticate", 4, 0));
		Thread.sleep(1000);
		BaseTest.click(g.getPasswordClear());
		BaseTest.typeData(g.getPassword(), getExcelsearchnep("Authenticate", 4, 1));
		
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
			try {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@alt='close']")).click();
				System.out.println("The popup is Handeled successfully	");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("the POPup is not available");
			}
			
			

		//click on the MATCHES in the tab	
			try {
				driver.findElement(By.xpath("//a[text()='Matches ']")).click();
				
			} catch (Exception e) 
			{
				System.out.println("Not entered into Matches");
			}
			
			Thread.sleep(5000);
		/////////////////////////////Cancel the Sent Mail////////////////////////////////
		//Click on the Sent Mail
			try {
				Thread.sleep(5000);
				System.out.println("----------------Cancel on the Sent Mail-----------------");
				driver.findElement(By.xpath("//*[@class='sent-mail-bx']/div/a")).click();
			} catch (Exception e) {
				System.err.println("There is no send mail popup");
			}
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,100)");
			
	
		///////////////////////////////Seleting the profile////////////////////////////
			
		for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
		{
			List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
			System.out.println("viewed Profile   = "+TotalAvaView.size());
			int totalCount=1;
			for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
			{
				System.out.println("--");
				System.out.println("--");
				System.out.println("--");
				System.out.println("--------------------New Profile Starts Here----------------");
				count=count+1;
				System.out.println("Profile Count = "+count);
				
				Thread.sleep(5000);
				String Name = driver.findElement(By.xpath("(//*[@class='clr9' and @target='_blank'])["+totalCount+"]")).getText();
				System.out.println("Name of the profile "+count+" :"+Name);
				List<WebElement> photoFrame = new ArrayList<WebElement>();
				//System.out.println("after null");
				int shownPages=0;
				WebElement profile = null;
				int photoFrameSize=0;
				
				try {
					photoFrame = driver.findElements(By.xpath("(//*[@class='clr7' and text()='Profile Created for '])["+totalCount+"]//parent::div//parent::div//following-sibling::div[@class='fleft padt10 ']//div[@class='fleft padr5']//img"));
					photoFrameSize = photoFrame.size();
				} catch (Exception e) {
					System.out.println("Not able to find any photos  -  Exception Handled");
				}
				try {
					profile = driver.findElement(By.xpath("(//*[@class='clr7' and text()='Profile Created for '])["+totalCount+"]//parent::div//parent::div/following-sibling::div[@class='fleft padt10 ']//div//div//div[@class='mediumtxt txt-center']//span"));
					String noOfPhotos = profile.getText();
					String[] split = noOfPhotos.split(" ");
					System.out.println("Total no. of splited words"+split.length);
					for (int i = 0; i < split.length; i++) 
					{
						System.out.println("Seperated text "+i+"  =  "+split[i]);
					}
					shownPages = Integer.parseInt(split[split.length-1]);
				} catch (Exception e) {
					System.out.println("The text '1 of' is not available  -  Exception Handled");
				}
				
				
				System.out.println("-");
				if(photoFrameSize==1 && shownPages==0)
				{
					System.out.println("Total images shown is not available due to only one images is available");
				}else if (photoFrameSize==0 && shownPages==0) 
				{
					System.out.println("No image is available");
				}else if (shownPages==photoFrameSize) 
				{
					System.out.println("Total images show in numbers and no of images available are equal");
				}
				
			totalCount++;
			}	
			try {
				WebElement Next = driver.findElement(By.xpath("//*[text()='Next ']//*[text()='»']"));
				js.executeScript("arguments[0].scrollIntoView();", Next);
				Thread.sleep(2000);
				Next.click();
				Thread.sleep(10000);
			} catch (Exception e) {
				Thread.sleep(3000);
				WebElement Next = driver.findElement(By.xpath("//*[text()='Next ']"));
				js.executeScript("arguments[0].scrollIntoView();", Next);
				Thread.sleep(1000);
				Next.click();
				System.out.println("Exception  in the next try");
				Thread.sleep(10000);
			}
		}
		
	}
		 
		//////////////////////////
	
	
			
	
}
