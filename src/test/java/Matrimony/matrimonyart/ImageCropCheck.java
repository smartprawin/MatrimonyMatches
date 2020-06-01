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

public class ImageCropCheck extends BaseTest
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
		Thread.sleep(4000);
		Runtime.getRuntime().exec("D:\\Java\\Window7\\First\\matrimonyart\\Exe\\ClickNotification.exe");
		
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
		System.out.println(countofImages.size());
		
		driver.findElement(By.xpath("//*[@class='v-profile-link mediumtxt']")).click();
		
		Set<String> child2 = driver.getWindowHandles();
		
		for (String string : child2) 
		{
			if (!parent.equals(string) && !child.equals(string)) 
			{
				driver.switchTo().window(string);
				System.out.println("New Window is Handeled");
				Thread.sleep(5000);
			}
			
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='imgdiv1']")).click();
		Thread.sleep(5000); 
		String imagepath = driver.findElement(By.xpath("(//*[@class='wraptocenter'])[1]//img")).getAttribute("src");
		driver.get("https://image.online-convert.com/convert/webp-to-jpg");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
			driver.findElement(By.className("btn-extension-cancel")).click();
		} catch (Exception e) {
			System.out.println("Exception Handled - 'btn-extension-cancel'");
		}
		try {
			Thread.sleep(2000);
			driver.findElement(By.className("btn btn-info btn-lg qg-consent-ok")).click();
		} catch (Exception e) {
			System.out.println("Exception Handled - 'btn btn-info btn-lg qg-consent-ok'");
			driver.findElement(By.xpath("//*[text()='Ok']")).click();
			
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='uploadbutton']")).click();
		
		WebElement EnterURL = driver.findElement(By.xpath("//*[@id='externalUrlInput']"));
		EnterURL.click();
		EnterURL.sendKeys(imagepath);
		driver.findElement(By.xpath("//*[@id='externalUrlDialogOkButton']")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("(//*[text()=' Start conversion    '])[1]")).click();
		Thread.sleep(6000);
		
		
		System.out.println("outside checkbox");
		driver.findElement(By.xpath("//*[text()='Download']")).click();
		
		System.out.println("outside download");
		
		
		
		//Search File in DIR
		      File dir = new File("C:\\Users\\admin\\Downloads");
		      FilenameFilter filter = new FilenameFilter() {
		         public boolean accept (File dir, String name) { 
		            return name.startsWith("IYR242926");
		         } 
		      }; 
		      String[] children = dir.list(filter);
		      if (children == null) {
		         System.out.println("Either dir does not exist or is not a directory"); 
		      } else { 
		         for (int i = 0; i< children.length; i++) {
		            String filename = children[i];
		            System.out.println(filename);
		         } 
		      } 
		
		     
		      
///////////////////////////////////////////////////////////////////////////////////////
		      String fileName1 = null;
		      File dir1 = new File("C:\\Users\\admin\\Downloads");
		      FilenameFilter filter1 = new FilenameFilter() {
		         public boolean accept (File dir, String name) { 
		            return name.startsWith("IYR242926");
		         } 
		      }; 
		      String[] children1 = dir1.list(filter1);
		      if (children1 == null) {
		         System.out.println("Either dir does not exist or is not a directory"); 
		      } else { 
		         for (int i = 0; i< children1.length; i++) {
		            fileName1 = children1[i];
		            System.out.println(fileName1);
		         } 
		      } 
		      System.out.println("Extracted successfully- total no of length :"+children1.length);
		      
		      
						
							
							  BufferedImage imgA = null; 
						      BufferedImage imgB = null; 
						      System.out.println("After buff Image");
						      try
						      { 
						          File fileA = new File("D:\\Growup\\LOGO\\Test.jpg"); 
						          File fileB = new File("C:\\Users\\admin\\Downloads\\"+children1[1]); 
						          System.out.println("file created");
						          imgA = ImageIO.read(fileA); 
						          imgB = ImageIO.read(fileB); 
						          System.out.println("successfully try block passed");
						      } 
						      catch (IOException e) 
						      { 
						          System.out.println(e); 
						          System.out.println("inside catch ");
						      } 
						      int width1 = imgA.getWidth(); 
						      int width2 = imgB.getWidth(); 
						      int height1 = imgA.getHeight(); 
						      int height2 = imgB.getHeight(); 

						      if ((width1 != width2) || (height1 != height2)) 
						          System.err.println("Error: Images dimensions"+" mismatch"); 
						      else
						      { 
						          long difference = 0; 
						          for (int y = 0; y < height1; y++) 
						          { 
						              for (int x = 0; x < width1; x++) 
						              { 
						                  int rgbA = imgA.getRGB(x, y); 
						                  int rgbB = imgB.getRGB(x, y); 
						                  int redA = (rgbA >> 16) & 0xff; 
						                  int greenA = (rgbA >> 8) & 0xff; 
						                  int blueA = (rgbA) & 0xff; 
						                  int redB = (rgbB >> 16) & 0xff; 
						                  int greenB = (rgbB >> 8) & 0xff; 
						                  int blueB = (rgbB) & 0xff; 
						                  difference += Math.abs(redA - redB);              
						                  difference += Math.abs(greenA - greenB); 			
						                  difference += Math.abs(blueA - blueB);              
						              } 
						          } 

						          // Total number of red pixels = width * height 
						          // Total number of blue pixels = width * height 
						          // Total number of green pixels = width * height 
						          // So total number of pixels = width * height * 3 
						          double total_pixels = width1 * height1 * 3; 

						          // Normalizing the value of different pixels 
						          // for accuracy(average pixels per color 
						          // component) 
						          double avg_different_pixels = difference /  total_pixels; 

						          // There are 255 values of pixels in total 
						          double percentage = (avg_different_pixels / 255) * 100; 

						          System.out.println("Difference Percentage-->" +percentage); 
						          
						          if (percentage==0) 
						          {
									System.out.println(" Same image is repeated");
									repeatFlag=true;
						          }else {
									System.out.println("Not repeated ");
								}
						          
				}
			     Thread.sleep(5000);
			   //////////////Delete List of files//////////////////////////
			     File directory = new File("E:\\ImagesToCompare");

			  // Get all files in directory

			  File[] files = directory.listFiles();
			  for (File file : files)
			  {
			     // Delete each file
				  System.out.println("deleted");
			     if (!file.delete())
			     {
			         // Failed to delete file

			         System.out.println("Failed to delete "+file);
			     }
			  } 
			  
			  
			  
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(parent);
			Thread.sleep(2000);
			
		      
		      
		      
		      
		      
		      
		      
	}
		 
	
	
			
	
}
