package Matrimony.matrimonyart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RequestFor extends BaseTest{


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
	@Test(enabled = false)
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
			//js.executeScript("window.scrollBy(0,100)");
			
	

		///////////////////////////Starting the Profile Details///////////////////////	
		Thread.sleep(5000);
		String ytvp = driver.findElement(By.id("total_div")).getText();
		String parentwindow = driver.getWindowHandle();
		System.out.println("yet to viewed profile count = " + ytvp);
		Thread.sleep(10000);
	
		///////////////////////////////////////Entering into the profile//////////////////////////////////
		for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
		{
			List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
			System.out.println("Total Yet to viewed Profile   = "+TotalAvaView.size());
			for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
			{
				System.out.println("--");
				System.out.println("--");
				System.out.println("--");
				System.out.println("--------------------New Profile Starts Here----------------");
				count=Total+1;
				System.out.println("Profile Count = "+count);
				Thread.sleep(5000);
				try {
					TotalAvaView.get(Total).click();
					Thread.sleep(5000);
					System.out.println("Profile clicked Normally");
				} catch (Exception e) {
					
					System.out.println("Inside Catch Profile clicked ");
					break;
				}
				//////////////////////////////////Window Handling//////////////////////////////////
				try {
				Set<String> childwindow = driver.getWindowHandles();
				for(String wh : childwindow) 
				{
					if (!parentwindow.equals(wh)) 
					{
						driver.switchTo().window(wh);
						System.out.println("New Window is Handeled");
						Thread.sleep(5000);
					}
				}
				} catch (Exception e) {
				System.out.println("Exception coz of Handling");
				}
				Thread.sleep(20000);
				List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
				
				
				/////////////////////////////clicking the request for ///////////////////////////////
				for (int i = 0; i < reqFor.size(); i++) 
				{	
					try {
					
					System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
					js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
					Thread.sleep(4000);
					reqFor.get(i).click();
					Thread.sleep(3000);
					try {
						reqFor.get(i).click();
						Thread.sleep(5000);
						System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
					} catch (Exception e) {
						acc.doubleClick(reqFor.get(i));
						Thread.sleep(5000);
						System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
					}
					
					////////////////////////////////Handling the POPup/////////////////////////
					try {
						WebElement popClose = driver.findElement(By.id("accept_close"));
						Thread.sleep(4000);
						popClose.click();
						System.out.println("POPup is clicked Successfully");
						Thread.sleep(3000);
						r.keyPress(KeyEvent.VK_ESCAPE);
						Thread.sleep(1000);
						r.keyRelease(KeyEvent.VK_ESCAPE);
						//System.out.println("Successfully ESC key is clicked");
					} catch (Exception e) 
					{
						System.out.println("POP up is not properly found");
						r.keyPress(KeyEvent.VK_ESCAPE);
						Thread.sleep(1000);
						r.keyRelease(KeyEvent.VK_ESCAPE);
						System.out.println("Successfully ESC key is clicked");
					}
					
					} catch (Exception e) {
						try {
							System.out.println("/////////  Exception happended coz of popup standby  ////////");
							WebElement popClose = driver.findElement(By.id("accept_close"));
							Thread.sleep(4000);
							popClose.click();
							System.out.println("POPup is clicked Successfully");
							Thread.sleep(3000);
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							//System.out.println("Successfully ESC key is clicked");
						} catch (Exception a) 
						{
							System.out.println("POP up is not properly found");
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							System.out.println("Successfully ESC key is clicked");
						}
					}
					
				}
				driver.close();
				System.out.println("---------------------Profile Ends Here--------------------");
				Thread.sleep(5000);
				driver.switchTo().window(parentwindow);
			}
		///////////////////////////Go to Next Page///////////////////////////////////
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
	
	
	@Test(enabled = true)
	public void setup7() throws Throwable 
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

			Thread.sleep(10000);

		//click on the MyHome in the tab	
			try 
			{
				//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
				WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
				acc.moveToElement(MyHome).build().perform();
				Thread.sleep(3000);
				WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Profiles viewed & not contacted')]"));
				acc.moveToElement(subTextHome).build().perform();
				Thread.sleep(2000);
				subTextHome.click();
				
			} catch (Exception e) 
			{
				System.out.println("Not entered into Home");
				WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
				acc.moveToElement(MyHome).build().perform();
				Thread.sleep(3000);
				WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Profiles viewed & not contacted')]"));
				acc.moveToElement(subTextHome).build().perform();
				Thread.sleep(2000);
				subTextHome.click();
				
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
			//js.executeScript("window.scrollBy(0,100)");
			
	

		///////////////////////////Starting the Profile Details///////////////////////	
		Thread.sleep(5000);
		String ytvp = driver.findElement(By.id("total_div")).getText();
		String parentwindow = driver.getWindowHandle();
		System.out.println("yet to viewed profile count = " + ytvp);
		Thread.sleep(10000);
	
		///////////////////////////////////////Entering into the profile//////////////////////////////////
		for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
		{
			List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
			System.out.println("Total Yet to viewed Profile   = "+TotalAvaView.size());
			for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
			{
				System.out.println("--");
				System.out.println("--");
				System.out.println("--");
				System.out.println("--------------------New Profile Starts Here----------------");
				count=Total+1;
				System.out.println("Profile Count = "+count);
				Thread.sleep(5000);
				try {
					TotalAvaView.get(Total).click();
					Thread.sleep(5000);
					System.out.println("Profile clicked Normally");
				} catch (Exception e) {
					
					System.out.println("Inside Catch Profile clicked ");
					break;
				}
				//////////////////////////////////Window Handling//////////////////////////////////
				try {
				Set<String> childwindow = driver.getWindowHandles();
				for(String wh : childwindow) 
				{
					if (!parentwindow.equals(wh)) 
					{
						driver.switchTo().window(wh);
						System.out.println("New Window is Handeled");
						Thread.sleep(5000);
					}
				}
				} catch (Exception e) {
				System.out.println("Exception coz of Handling");
				}
				Thread.sleep(20000);
				List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
				
				
				/////////////////////////////clicking the request for ///////////////////////////////
				for (int i = 0; i < reqFor.size(); i++) 
				{	
					try {
					
					System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
					js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
					Thread.sleep(4000);
					reqFor.get(i).click();
					Thread.sleep(3000);
					try {
						reqFor.get(i).click();
						Thread.sleep(5000);
						System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
					} catch (Exception e) {
						acc.doubleClick(reqFor.get(i));
						Thread.sleep(5000);
						System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
					}
					
					////////////////////////////////Handling the POPup/////////////////////////
					try {
						WebElement popClose = driver.findElement(By.id("accept_close"));
						Thread.sleep(4000);
						popClose.click();
						System.out.println("POPup is clicked Successfully");
						Thread.sleep(3000);
						r.keyPress(KeyEvent.VK_ESCAPE);
						Thread.sleep(1000);
						r.keyRelease(KeyEvent.VK_ESCAPE);
						//System.out.println("Successfully ESC key is clicked");
					} catch (Exception e) 
					{
						System.out.println("POP up is not properly found");
						r.keyPress(KeyEvent.VK_ESCAPE);
						Thread.sleep(1000);
						r.keyRelease(KeyEvent.VK_ESCAPE);
						System.out.println("Successfully ESC key is clicked");
					}
					
					} catch (Exception e) {
						try {
							System.out.println("/////////  Exception happended coz of popup standby  ////////");
							WebElement popClose = driver.findElement(By.id("accept_close"));
							Thread.sleep(4000);
							popClose.click();
							System.out.println("POPup is clicked Successfully");
							Thread.sleep(3000);
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							//System.out.println("Successfully ESC key is clicked");
						} catch (Exception a) 
						{
							System.out.println("POP up is not properly found");
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							System.out.println("Successfully ESC key is clicked");
						}
					}
					
				}
				driver.close();
				System.out.println("---------------------Profile Ends Here--------------------");
				Thread.sleep(5000);
				driver.switchTo().window(parentwindow);
			}
		///////////////////////////Go to Next Page///////////////////////////////////
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
	
	//==========================================================================================//
	
	@Test(enabled = false)
	public void setup8() throws Throwable 
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

			Thread.sleep(10000);

		//click on the MyHome in the tab	
			try 
			{
				//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
				WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
				acc.moveToElement(MyHome).build().perform();
				Thread.sleep(3000);
				WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Profiles shortlisted by me')]"));
				acc.moveToElement(subTextHome).build().perform();
				Thread.sleep(2000);
				subTextHome.click();
				
			} catch (Exception e) 
			{
				System.out.println("Not entered into Profiles shortlisted by me");
				WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
				acc.moveToElement(MyHome).build().perform();
				Thread.sleep(3000);
				WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Profiles shortlisted by me')]"));
				acc.moveToElement(subTextHome).build().perform();
				Thread.sleep(2000);
				subTextHome.click();
				
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
			//js.executeScript("window.scrollBy(0,100)");
			
	

		///////////////////////////Starting the Profile Details///////////////////////	
		Thread.sleep(5000);
		String ytvp = driver.findElement(By.id("total_div")).getText();
		String parentwindow = driver.getWindowHandle();
		System.out.println("yet to viewed profile count = " + ytvp);
		Thread.sleep(10000);
	
		///////////////////////////////////////Entering into the profile//////////////////////////////////
		for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
		{
			List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
			System.out.println("Total Yet to viewed Profile   = "+TotalAvaView.size());
			for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
			{
				System.out.println("--");
				System.out.println("--");
				System.out.println("--");
				System.out.println("--------------------New Profile Starts Here----------------");
				count=Total+1;
				System.out.println("Profile Count = "+count);
				Thread.sleep(5000);
				try {
					TotalAvaView.get(Total).click();
					Thread.sleep(5000);
					System.out.println("Profile clicked Normally");
				} catch (Exception e) {
					
					System.out.println("Inside Catch Profile clicked ");
					break;
				}
				//////////////////////////////////Window Handling//////////////////////////////////
				try {
				Set<String> childwindow = driver.getWindowHandles();
				for(String wh : childwindow) 
				{
					if (!parentwindow.equals(wh)) 
					{
						driver.switchTo().window(wh);
						System.out.println("New Window is Handeled");
						Thread.sleep(5000);
					}
				}
				} catch (Exception e) {
				System.out.println("Exception coz of Handling");
				}
				Thread.sleep(20000);
				List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
				
				
				/////////////////////////////clicking the request for ///////////////////////////////
				for (int i = 0; i < reqFor.size(); i++) 
				{	
					try {
					
					System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
					js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
					Thread.sleep(4000);
					reqFor.get(i).click();
					Thread.sleep(3000);
					try {
						reqFor.get(i).click();
						Thread.sleep(5000);
						System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
					} catch (Exception e) {
						acc.doubleClick(reqFor.get(i));
						Thread.sleep(5000);
						System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
					}
					
					////////////////////////////////Handling the POPup/////////////////////////
					try {
						WebElement popClose = driver.findElement(By.id("accept_close"));
						Thread.sleep(4000);
						popClose.click();
						System.out.println("POPup is clicked Successfully");
						Thread.sleep(3000);
						r.keyPress(KeyEvent.VK_ESCAPE);
						Thread.sleep(1000);
						r.keyRelease(KeyEvent.VK_ESCAPE);
						//System.out.println("Successfully ESC key is clicked");
					} catch (Exception e) 
					{
						System.out.println("POP up is not properly found");
						r.keyPress(KeyEvent.VK_ESCAPE);
						Thread.sleep(1000);
						r.keyRelease(KeyEvent.VK_ESCAPE);
						System.out.println("Successfully ESC key is clicked");
					}
					
					} catch (Exception e) {
						try {
							System.out.println("/////////  Exception happended coz of popup standby  ////////");
							WebElement popClose = driver.findElement(By.id("accept_close"));
							Thread.sleep(4000);
							popClose.click();
							System.out.println("POPup is clicked Successfully");
							Thread.sleep(3000);
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							//System.out.println("Successfully ESC key is clicked");
						} catch (Exception a) 
						{
							System.out.println("POP up is not properly found");
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							System.out.println("Successfully ESC key is clicked");
						}
					}
					
				}
				driver.close();
				System.out.println("---------------------Profile Ends Here--------------------");
				Thread.sleep(5000);
				driver.switchTo().window(parentwindow);
			}
		///////////////////////////Go to Next Page///////////////////////////////////
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
	
	//==========================================================================================//
	
		@Test(enabled = false)
		public void setup9() throws Throwable 
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

				Thread.sleep(10000);

			//click on the MyHome in the tab	
				try 
				{
					//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
					WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
					acc.moveToElement(MyHome).build().perform();
					Thread.sleep(3000);
					WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Mobile nos.viewed by me')]"));
					acc.moveToElement(subTextHome).build().perform();
					Thread.sleep(2000);
					subTextHome.click();
					
				} catch (Exception e) 
				{
					System.out.println("Not entered into Mobile nos.viewed by me");
					WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
					acc.moveToElement(MyHome).build().perform();
					Thread.sleep(3000);
					WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Mobile nos.viewed by me')]"));
					acc.moveToElement(subTextHome).build().perform();
					Thread.sleep(2000);
					subTextHome.click();
					
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
				//js.executeScript("window.scrollBy(0,100)");
				
		
			try {
			///////////////////////////Starting the Profile Details///////////////////////	
			Thread.sleep(5000);
			String ytvp = driver.findElement(By.id("total_div")).getText();
			String parentwindow = driver.getWindowHandle();
			System.out.println("yet to viewed profile count = " + ytvp);
			Thread.sleep(10000);
		
			///////////////////////////////////////Entering into the profile//////////////////////////////////
			for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
			{
				List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
				System.out.println("Total Yet to viewed Profile   = "+TotalAvaView.size());
				for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
				{
					System.out.println("--");
					System.out.println("--");
					System.out.println("--");
					System.out.println("--------------------New Profile Starts Here----------------");
					count=Total+1;
					System.out.println("Profile Count = "+count);
					Thread.sleep(5000);
					try {
						TotalAvaView.get(Total).click();
						Thread.sleep(5000);
						System.out.println("Profile clicked Normally");
					} catch (Exception e) {
						
						System.out.println("Inside Catch Profile clicked ");
						break;
					}
					//////////////////////////////////Window Handling//////////////////////////////////
					try {
					Set<String> childwindow = driver.getWindowHandles();
					for(String wh : childwindow) 
					{
						if (!parentwindow.equals(wh)) 
						{
							driver.switchTo().window(wh);
							System.out.println("New Window is Handeled");
							Thread.sleep(5000);
						}
					}
					} catch (Exception e) {
					System.out.println("Exception coz of Handling");
					}
					Thread.sleep(20000);
					List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
					
					
					/////////////////////////////clicking the request for ///////////////////////////////
					for (int i = 0; i < reqFor.size(); i++) 
					{	
						try {
						
						System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
						js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
						Thread.sleep(4000);
						reqFor.get(i).click();
						Thread.sleep(3000);
						try {
							reqFor.get(i).click();
							Thread.sleep(5000);
							System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
						} catch (Exception e) {
							acc.doubleClick(reqFor.get(i));
							Thread.sleep(5000);
							System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
						}
						
						////////////////////////////////Handling the POPup/////////////////////////
						try {
							WebElement popClose = driver.findElement(By.id("accept_close"));
							Thread.sleep(4000);
							popClose.click();
							System.out.println("POPup is clicked Successfully");
							Thread.sleep(3000);
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							//System.out.println("Successfully ESC key is clicked");
						} catch (Exception e) 
						{
							System.out.println("POP up is not properly found");
							r.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(1000);
							r.keyRelease(KeyEvent.VK_ESCAPE);
							System.out.println("Successfully ESC key is clicked");
						}
						
						} catch (Exception e) {
							try {
								System.out.println("/////////  Exception happended coz of popup standby  ////////");
								WebElement popClose = driver.findElement(By.id("accept_close"));
								Thread.sleep(4000);
								popClose.click();
								System.out.println("POPup is clicked Successfully");
								Thread.sleep(3000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								//System.out.println("Successfully ESC key is clicked");
							} catch (Exception a) 
							{
								System.out.println("POP up is not properly found");
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								System.out.println("Successfully ESC key is clicked");
							}
						}
						
					}
					driver.close();
					System.out.println("---------------------Profile Ends Here--------------------");
					Thread.sleep(5000);
					driver.switchTo().window(parentwindow);
				}
			///////////////////////////Go to Next Page///////////////////////////////////
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

			} catch (Exception e) 
			{
				System.out.println("No profile is found");
			}
		}
		
		//==========================================================================================//
		
			@Test(enabled = false)
			public void setup10() throws Throwable 
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

					Thread.sleep(10000);

				//click on the MyHome in the tab	
					try 
					{
						//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Profiles I have ignored')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						System.out.println("Entered into Profiles I have ignored ");
					} catch (Exception e) 
					{
						System.out.println("Not entered into Profiles I have ignored ");
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Profiles I have ignored')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						
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
					//js.executeScript("window.scrollBy(0,100)");
					
			
				try {
				///////////////////////////Starting the Profile Details///////////////////////	
				Thread.sleep(5000);
				String ytvp = driver.findElement(By.id("total_div")).getText();
				String parentwindow = driver.getWindowHandle();
				System.out.println("yet to viewed profile count = " + ytvp);
				Thread.sleep(10000);
			
				///////////////////////////////////////Entering into the profile//////////////////////////////////
				for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
				{
					List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
					System.out.println("Total Yet to viewed Profile   = "+TotalAvaView.size());
					for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
					{
						System.out.println("--");
						System.out.println("--");
						System.out.println("--");
						System.out.println("--------------------New Profile Starts Here----------------");
						count=Total+1;
						System.out.println("Profile Count = "+count);
						Thread.sleep(5000);
						try {
							TotalAvaView.get(Total).click();
							Thread.sleep(5000);
							System.out.println("Profile clicked Normally");
						} catch (Exception e) {
							
							System.out.println("Inside Catch Profile clicked ");
							break;
						}
						//////////////////////////////////Window Handling//////////////////////////////////
						try {
						Set<String> childwindow = driver.getWindowHandles();
						for(String wh : childwindow) 
						{
							if (!parentwindow.equals(wh)) 
							{
								driver.switchTo().window(wh);
								System.out.println("New Window is Handeled");
								Thread.sleep(5000);
							}
						}
						} catch (Exception e) {
						System.out.println("Exception coz of Handling");
						}
						Thread.sleep(20000);
						List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
						
						
						/////////////////////////////clicking the request for ///////////////////////////////
						for (int i = 0; i < reqFor.size(); i++) 
						{	
							try {
							
							System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
							js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
							Thread.sleep(4000);
							reqFor.get(i).click();
							Thread.sleep(3000);
							try {
								reqFor.get(i).click();
								Thread.sleep(5000);
								System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
							} catch (Exception e) {
								acc.doubleClick(reqFor.get(i));
								Thread.sleep(5000);
								System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
							}
							
							////////////////////////////////Handling the POPup/////////////////////////
							try {
								WebElement popClose = driver.findElement(By.id("accept_close"));
								Thread.sleep(4000);
								popClose.click();
								System.out.println("POPup is clicked Successfully");
								Thread.sleep(3000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								//System.out.println("Successfully ESC key is clicked");
							} catch (Exception e) 
							{
								System.out.println("POP up is not properly found");
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								System.out.println("Successfully ESC key is clicked");
							}
							
							} catch (Exception e) {
								try {
									System.out.println("/////////  Exception happended coz of popup standby  ////////");
									WebElement popClose = driver.findElement(By.id("accept_close"));
									Thread.sleep(4000);
									popClose.click();
									System.out.println("POPup is clicked Successfully");
									Thread.sleep(3000);
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									//System.out.println("Successfully ESC key is clicked");
								} catch (Exception a) 
								{
									System.out.println("POP up is not properly found");
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									System.out.println("Successfully ESC key is clicked");
								}
							}
							
						}
						driver.close();
						System.out.println("---------------------Profile Ends Here--------------------");
						Thread.sleep(5000);
						driver.switchTo().window(parentwindow);
					}
				///////////////////////////Go to Next Page///////////////////////////////////
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

				} catch (Exception e) 
				{
					System.out.println("No profile found");
				}
			}
	
	//==========================================================================================//
			
			@Test(enabled = false)
			public void setup11() throws Throwable 
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

					Thread.sleep(10000);

				//click on the MyHome in the tab	
					try 
					{
						//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Who viewed my profile')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						System.out.println("Entered into Who viewed my profile  ");
					} catch (Exception e) 
					{
						System.out.println("Not entered into Who viewed my profile  ");
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Who viewed my profile')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						
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
					//js.executeScript("window.scrollBy(0,100)");
					
			
				try {
				///////////////////////////Starting the Profile Details///////////////////////	
				Thread.sleep(5000);
				String ytvp = driver.findElement(By.id("total_div")).getText();
				String parentwindow = driver.getWindowHandle();
				System.out.println("yet to viewed profile count = " + ytvp);
				Thread.sleep(10000);
			
				///////////////////////////////////////Entering into the profile//////////////////////////////////
				for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
				{
					List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
					System.out.println("Total Yet to viewed Profile   = "+TotalAvaView.size());
					for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
					{
						System.out.println("--");
						System.out.println("--");
						System.out.println("--");
						System.out.println("--------------------New Profile Starts Here----------------");
						count=Total+1;
						System.out.println("Profile Count = "+count);
						Thread.sleep(5000);
						try {
							TotalAvaView.get(Total).click();
							Thread.sleep(5000);
							System.out.println("Profile clicked Normally");
						} catch (Exception e) {
							
							System.out.println("Inside Catch Profile clicked ");
							break;
						}
						//////////////////////////////////Window Handling//////////////////////////////////
						try {
						Set<String> childwindow = driver.getWindowHandles();
						for(String wh : childwindow) 
						{
							if (!parentwindow.equals(wh)) 
							{
								driver.switchTo().window(wh);
								System.out.println("New Window is Handeled");
								Thread.sleep(5000);
							}
						}
						} catch (Exception e) {
						System.out.println("Exception coz of Handling");
						}
						Thread.sleep(20000);
						List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
						
						
						/////////////////////////////clicking the request for ///////////////////////////////
						for (int i = 0; i < reqFor.size(); i++) 
						{	
							try {
							
							System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
							js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
							Thread.sleep(4000);
							reqFor.get(i).click();
							Thread.sleep(3000);
							try {
								reqFor.get(i).click();
								Thread.sleep(5000);
								System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
							} catch (Exception e) {
								acc.doubleClick(reqFor.get(i));
								Thread.sleep(5000);
								System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
							}
							
							////////////////////////////////Handling the POPup/////////////////////////
							try {
								WebElement popClose = driver.findElement(By.id("accept_close"));
								Thread.sleep(4000);
								popClose.click();
								System.out.println("POPup is clicked Successfully");
								Thread.sleep(3000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								//System.out.println("Successfully ESC key is clicked");
							} catch (Exception e) 
							{
								System.out.println("POP up is not properly found");
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								System.out.println("Successfully ESC key is clicked");
							}
							
							} catch (Exception e) {
								try {
									System.out.println("/////////  Exception happended coz of popup standby  ////////");
									WebElement popClose = driver.findElement(By.id("accept_close"));
									Thread.sleep(4000);
									popClose.click();
									System.out.println("POPup is clicked Successfully");
									Thread.sleep(3000);
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									//System.out.println("Successfully ESC key is clicked");
								} catch (Exception a) 
								{
									System.out.println("POP up is not properly found");
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									System.out.println("Successfully ESC key is clicked");
								}
							}
							
						}
						driver.close();
						System.out.println("---------------------Profile Ends Here--------------------");
						Thread.sleep(5000);
						driver.switchTo().window(parentwindow);
					}
				///////////////////////////Go to Next Page///////////////////////////////////
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

				} catch (Exception e) 
				{
					System.out.println("No profile found");
				}
			}
	
//==========================================================================================//
			
			@Test(enabled = false)
			public void setup12() throws Throwable 
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

					Thread.sleep(10000);

				//click on the MyHome in the tab	
					try 
					{
						//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Who shortlisted me')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						System.out.println("Entered into Who shortlisted me ");
					} catch (Exception e) 
					{
						System.out.println("Not entered into Who shortlisted me ");
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Who shortlisted me')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						
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
					//js.executeScript("window.scrollBy(0,100)");
					
			
				try {
				///////////////////////////Starting the Profile Details///////////////////////	
				Thread.sleep(5000);
				//String ytvp = driver.findElement(By.id("total_div")).getText();
				String parentwindow = driver.getWindowHandle();
				//System.out.println("yet to viewed profile count = " + ytvp);
				Thread.sleep(10000);
			
				///////////////////////////////////////Entering into the profile//////////////////////////////////
				for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
				{
					List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
					System.out.println("Total Profile   = "+TotalAvaView.size());
					for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
					{
						System.out.println("--");
						System.out.println("--");
						System.out.println("--");
						System.out.println("--------------------New Profile Starts Here----------------");
						count=Total+1;
						System.out.println("Profile Count = "+count);
						Thread.sleep(5000);
						try {
							TotalAvaView.get(Total).click();
							Thread.sleep(5000);
							System.out.println("Profile clicked Normally");
						} catch (Exception e) {
							
							System.out.println("Inside Catch Profile clicked ");
							break;
						}
						//////////////////////////////////Window Handling//////////////////////////////////
						try {
						Set<String> childwindow = driver.getWindowHandles();
						for(String wh : childwindow) 
						{
							if (!parentwindow.equals(wh)) 
							{
								driver.switchTo().window(wh);
								System.out.println("New Window is Handeled");
								Thread.sleep(5000);
							}
						}
						} catch (Exception e) {
						System.out.println("Exception coz of Handling");
						}
						Thread.sleep(20000);
						List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
						
						
						/////////////////////////////clicking the request for ///////////////////////////////
						for (int i = 0; i < reqFor.size(); i++) 
						{	
							try {
							
							System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
							js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
							Thread.sleep(4000);
							reqFor.get(i).click();
							Thread.sleep(3000);
							try {
								reqFor.get(i).click();
								Thread.sleep(5000);
								System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
							} catch (Exception e) {
								acc.doubleClick(reqFor.get(i));
								Thread.sleep(5000);
								System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
							}
							
							////////////////////////////////Handling the POPup/////////////////////////
							try {
								WebElement popClose = driver.findElement(By.id("accept_close"));
								Thread.sleep(4000);
								popClose.click();
								System.out.println("POPup is clicked Successfully");
								Thread.sleep(3000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								//System.out.println("Successfully ESC key is clicked");
							} catch (Exception e) 
							{
								System.out.println("POP up is not properly found");
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								System.out.println("Successfully ESC key is clicked");
							}
							
							} catch (Exception e) {
								try {
									System.out.println("/////////  Exception happended coz of popup standby  ////////");
									WebElement popClose = driver.findElement(By.id("accept_close"));
									Thread.sleep(4000);
									popClose.click();
									System.out.println("POPup is clicked Successfully");
									Thread.sleep(3000);
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									//System.out.println("Successfully ESC key is clicked");
								} catch (Exception a) 
								{
									System.out.println("POP up is not properly found");
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									System.out.println("Successfully ESC key is clicked");
								}
							}
							
						}
						driver.close();
						System.out.println("---------------------Profile Ends Here--------------------");
						Thread.sleep(5000);
						driver.switchTo().window(parentwindow);
					}
				///////////////////////////Go to Next Page///////////////////////////////////
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

				} catch (Exception e) 
				{
					System.out.println("No profile found");
				}
			}

	 
//==========================================================================================//
			
			@Test(enabled = false)
			public void setup13() throws Throwable 
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

					Thread.sleep(10000);

				//click on the MyHome in the tab	
					try 
					{
						//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Who viewed my mobile no')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						System.out.println("Entered into Who viewed my mobile no ");
					} catch (Exception e) 
					{
						System.out.println("Not entered into Who viewed my mobile no");
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Who viewed my mobile no')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						
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
					//js.executeScript("window.scrollBy(0,100)");
					
			
				try {
				///////////////////////////Starting the Profile Details///////////////////////	
				Thread.sleep(5000);
				//String ytvp = driver.findElement(By.id("total_div")).getText();
				String parentwindow = driver.getWindowHandle();
				//System.out.println("yet to viewed profile count = " + ytvp);
				Thread.sleep(10000);
			
				///////////////////////////////////////Entering into the profile//////////////////////////////////
				for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
				{
					List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
					System.out.println("Total Profile   = "+TotalAvaView.size());
					for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
					{
						System.out.println("--");
						System.out.println("--");
						System.out.println("--");
						System.out.println("--------------------New Profile Starts Here----------------");
						count=Total+1;
						System.out.println("Profile Count = "+count);
						Thread.sleep(5000);
						try {
							TotalAvaView.get(Total).click();
							Thread.sleep(5000);
							System.out.println("Profile clicked Normally");
						} catch (Exception e) {
							
							System.out.println("Inside Catch Profile clicked ");
							break;
						}
						//////////////////////////////////Window Handling//////////////////////////////////
						try {
						Set<String> childwindow = driver.getWindowHandles();
						for(String wh : childwindow) 
						{
							if (!parentwindow.equals(wh)) 
							{
								driver.switchTo().window(wh);
								System.out.println("New Window is Handeled");
								Thread.sleep(5000);
							}
						}
						} catch (Exception e) {
						System.out.println("Exception coz of Handling");
						}
						Thread.sleep(20000);
						List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
						
						
						/////////////////////////////clicking the request for ///////////////////////////////
						for (int i = 0; i < reqFor.size(); i++) 
						{	
							try {
							
							System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
							js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
							Thread.sleep(4000);
							reqFor.get(i).click();
							Thread.sleep(3000);
							try {
								reqFor.get(i).click();
								Thread.sleep(5000);
								System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
							} catch (Exception e) {
								acc.doubleClick(reqFor.get(i));
								Thread.sleep(5000);
								System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
							}
							
							////////////////////////////////Handling the POPup/////////////////////////
							try {
								WebElement popClose = driver.findElement(By.id("accept_close"));
								Thread.sleep(4000);
								popClose.click();
								System.out.println("POPup is clicked Successfully");
								Thread.sleep(3000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								//System.out.println("Successfully ESC key is clicked");
							} catch (Exception e) 
							{
								System.out.println("POP up is not properly found");
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								System.out.println("Successfully ESC key is clicked");
							}
							
							} catch (Exception e) {
								try {
									System.out.println("/////////  Exception happended coz of popup standby  ////////");
									WebElement popClose = driver.findElement(By.id("accept_close"));
									Thread.sleep(4000);
									popClose.click();
									System.out.println("POPup is clicked Successfully");
									Thread.sleep(3000);
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									//System.out.println("Successfully ESC key is clicked");
								} catch (Exception a) 
								{
									System.out.println("POP up is not properly found");
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									System.out.println("Successfully ESC key is clicked");
								}
							}
							
						}
						driver.close();
						System.out.println("---------------------Profile Ends Here--------------------");
						Thread.sleep(5000);
						driver.switchTo().window(parentwindow);
					}
				///////////////////////////Go to Next Page///////////////////////////////////
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

				} catch (Exception e) 
				{
					System.out.println("No profile found");
				}
			}
			
//==========================================================================================//
			
			@Test(enabled = false)
			public void setup14() throws Throwable 
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

					Thread.sleep(10000);

				//click on the MyHome in the tab	
					try 
					{
						//driver.findElement(By.xpath("//a[text()='Matches ']")).click();
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Interests I received')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						System.out.println("Entered into Interests I received  ");
					} catch (Exception e) 
					{
						System.out.println("Not entered into Interests I received ");
						WebElement MyHome = driver.findElement(By.xpath("//*[text()='My Home']"));
						acc.moveToElement(MyHome).build().perform();
						Thread.sleep(3000);
						WebElement subTextHome = driver.findElement(By.xpath("//*[contains(text(),'Interests I received')]"));
						acc.moveToElement(subTextHome).build().perform();
						Thread.sleep(2000);
						subTextHome.click();
						
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
					//js.executeScript("window.scrollBy(0,100)");
					
			
				try {
				///////////////////////////Starting the Profile Details///////////////////////	
				Thread.sleep(5000);
				//String ytvp = driver.findElement(By.id("total_div")).getText();
				String parentwindow = driver.getWindowHandle();
				//System.out.println("yet to viewed profile count = " + ytvp);
				Thread.sleep(10000);
			
				///////////////////////////////////////Entering into the profile//////////////////////////////////
				for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
				{
					List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
					System.out.println("Total Profile   = "+TotalAvaView.size());
					for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
					{
						System.out.println("--");
						System.out.println("--");
						System.out.println("--");
						System.out.println("--------------------New Profile Starts Here----------------");
						count=Total+1;
						System.out.println("Profile Count = "+count);
						Thread.sleep(5000);
						try {
							TotalAvaView.get(Total).click();
							Thread.sleep(5000);
							System.out.println("Profile clicked Normally");
						} catch (Exception e) {
							
							System.out.println("Inside Catch Profile clicked ");
							break;
						}
						//////////////////////////////////Window Handling//////////////////////////////////
						try {
						Set<String> childwindow = driver.getWindowHandles();
						for(String wh : childwindow) 
						{
							if (!parentwindow.equals(wh)) 
							{
								driver.switchTo().window(wh);
								System.out.println("New Window is Handeled");
								Thread.sleep(5000);
							}
						}
						} catch (Exception e) {
						System.out.println("Exception coz of Handling");
						}
						Thread.sleep(20000);
						List<WebElement> reqFor = driver.findElements(By.xpath("//*[@ng-click='requestfor($event)']"));
						
						
						/////////////////////////////clicking the request for ///////////////////////////////
						for (int i = 0; i < reqFor.size(); i++) 
						{	
							try {
							
							System.out.println("Inside For Loop   "+i+ "   Total No. of Requests = "+reqFor.size());
							js.executeScript("arguments[0].scrollIntoView();", reqFor.get(i));
							Thread.sleep(4000);
							reqFor.get(i).click();
							Thread.sleep(3000);
							try {
								reqFor.get(i).click();
								Thread.sleep(5000);
								System.out.println("Successfully Clicked  "+ reqFor.get(i).getText());
							} catch (Exception e) {
								acc.doubleClick(reqFor.get(i));
								Thread.sleep(5000);
								System.out.println("Clicked '"+reqFor.get(i).getText()+"' inside the catch");
							}
							
							////////////////////////////////Handling the POPup/////////////////////////
							try {
								WebElement popClose = driver.findElement(By.id("accept_close"));
								Thread.sleep(4000);
								popClose.click();
								System.out.println("POPup is clicked Successfully");
								Thread.sleep(3000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								//System.out.println("Successfully ESC key is clicked");
							} catch (Exception e) 
							{
								System.out.println("POP up is not properly found");
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(1000);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								System.out.println("Successfully ESC key is clicked");
							}
							
							} catch (Exception e) {
								try {
									System.out.println("/////////  Exception happended coz of popup standby  ////////");
									WebElement popClose = driver.findElement(By.id("accept_close"));
									Thread.sleep(4000);
									popClose.click();
									System.out.println("POPup is clicked Successfully");
									Thread.sleep(3000);
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									//System.out.println("Successfully ESC key is clicked");
								} catch (Exception a) 
								{
									System.out.println("POP up is not properly found");
									r.keyPress(KeyEvent.VK_ESCAPE);
									Thread.sleep(1000);
									r.keyRelease(KeyEvent.VK_ESCAPE);
									System.out.println("Successfully ESC key is clicked");
								}
							}
							
						}
						driver.close();
						System.out.println("---------------------Profile Ends Here--------------------");
						Thread.sleep(5000);
						driver.switchTo().window(parentwindow);
					}
				///////////////////////////Go to Next Page///////////////////////////////////
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

				} catch (Exception e) 
				{
					System.out.println("No profile found");
				}
			}
			
}
