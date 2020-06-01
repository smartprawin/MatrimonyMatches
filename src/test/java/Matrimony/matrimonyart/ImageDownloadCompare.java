package Matrimony.matrimonyart;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

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

public class ImageDownloadCompare extends BaseTest
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
	String[] photoUrl = new String[10];
	
	Boolean repeatFlag=false;
	
	int count = 0;
	public static List<WebElement> photoFrame = null;
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

			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath("//*[@alt='close']")).click();
			} catch (Exception e) {
				//driver.findElement(By.xpath("//*[@alt='close']")).click();
				System.out.println("popup is not available");
				Thread.sleep(2000);	
			}
			Thread.sleep(2000);
			

	
		///////////////////////////////Seleting the profile////////////////////////////
			
		String parent = driver.getWindowHandle();
		WebElement profilePic = null;	
		try 
		{
			profilePic = driver.findElement(By.xpath("//*[@class='prfile_icon']"));
		} 
		catch (Exception e) 
		{
			System.out.println("no profile photo is available");
			profilePic = driver.findElement(By.xpath("//*[@class='addphoto prfile_icon']"));
		}
		
		profilePic.click();
		
		Thread.sleep(3000);
		
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
		
		List<WebElement> countofImages = driver.findElements(By.xpath("(//*[@class='adfotolistitem'])"));
		try {
		
		for (int i = 0; i < countofImages.size(); i++) 
		{
			WebElement editButton = driver.findElement(By.xpath("(//*[@class='adfotolistitem'])[1]//div//span[@class='edit-photo-icon']"));
			if (editButton.isDisplayed()) 
			{
			editButton.click();
			WebElement deleteButton = driver.findElement(By.xpath("(//*[@class='adfotolistitem'])[1]//div[@class='editphoto-tip']//a[text()='Delete']"));
			acc.moveToElement(deleteButton).build().perform();
			acc.click(deleteButton).build().perform();
			driver.findElement(By.xpath("//input[@id='yesbut']")).click();
			driver.findElement(By.xpath("//*[@class='popup-close-off']")).click();
			}
		
		}
		
		} catch (Exception e) {
			System.out.println("exception in profile images");
		}
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@class='adfotolistitem'])[1]//div")).click();
		} catch (Exception e) {
			System.out.println("not able to find image path");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='clr3 clrbg_green font18 pad10 curve5']")).click();
		Thread.sleep(3000);
		//d:\growup\logo\test.jpg
		Runtime.getRuntime().exec("D:\\Java\\Window7\\First\\matrimonyart\\Exe\\FileUpload.exe");
		
			
			
		
	}
		 
	
	
			
	
}
