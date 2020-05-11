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

public class CompareProfileImages extends BaseTest
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
			js.executeScript("window.scrollBy(0,100)");
			
	
		///////////////////////////////Seleting the profile////////////////////////////
			
//		for (int nextPageCount = 0; nextPageCount < 2; nextPageCount++) 
//		{
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
				List<WebElement> profile = driver.findElements(By.xpath("//*[text()='Profile Created for ']"));
				profile.get(Total).click();
				String parentwindow = driver.getWindowHandle();
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
			
				List<WebElement> content = driver.findElements(By.xpath("//*[@class='fright width405 clr7 posrelative padr8 padt10 ']"));
			
				for (WebElement webElement : content) {
					System.out.println(webElement.getText());
				}
				
				List<WebElement> photoFrame = driver.findElements(By.xpath("//*[@class='fleft padl8 padr8']/img"));
			
				if (photoFrame.size()==1) 
				{
					System.out.println("ONLY ONE PHOTO IS AVAILABLE");
					Thread.sleep(5000);
					System.out.println(photoFrame.get(0).getAttribute("src"));
					Thread.sleep(2000);
					driver.close();
					driver.switchTo().window(parentwindow);
					Thread.sleep(2000);
				} else if(photoFrame.size()>1) 
				{
					
					System.out.println(photoFrame.size());
					for (int i = 0; i < photoFrame.size(); i++) 
					{
						System.out.println(photoFrame.get(i).getAttribute("src"));
						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_T);
						r.keyRelease(KeyEvent.VK_CONTROL);
						r.keyRelease(KeyEvent.VK_T);
						String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
						driver.findElement(By.linkText(photoFrame.get(i).getAttribute("src"))).sendKeys(selectLinkOpeninNewTab); 
						
						
					}
					 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
					 System.out.println("-----------3rd window handling------------- ");
					 driver.switchTo().window(tabs.get(0));
					 
	
				}else if(photoFrame.size()==0)
				{
					System.out.println("there is some error in the taking the photos");
				}else if(photoFrame.size()<0)
				{
					System.out.println("less that 0");
				}
			
			}	

		}
		
	//}
		 
		//////////////////////////
	
	
			
	
}
