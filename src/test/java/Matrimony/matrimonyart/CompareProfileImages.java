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
	String[] photoUrl = new String[10];
	public String[] children=null;
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
			if (nextPageCount != 0) 
			{
				Thread.sleep(8000);
			}
			List<WebElement> TotalAvaView = driver.findElements(By.xpath("(//div[@class='fleft padt4 mediumtxt clr5'])"));
			System.out.println(" Profile to viewed on this    = "+TotalAvaView.size());
			int totalCount=1;
			
			for (int Total = 0; Total < TotalAvaView.size()/2; Total++) 
			{
				System.out.println("--");
				System.out.println("--");
				System.out.println("--");
				System.out.println("--------------------New Profile Starts Here----------------");
				count=Total+1;
				System.out.println("Profile Count = "+totalCount);
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
				WebElement profileID = driver.findElement(By.xpath("//*[@id='oppositeMemberId']"));
				final String profileIDText = profileID.getText();
				System.out.println(profileIDText);
				
				for (WebElement webElement : content) 
				{
					System.out.println(webElement.getText());
				}
				
				photoFrame = driver.findElements(By.xpath("//*[@class='fleft padl8 padr8']/img"));
				for (int i = 0; i < photoFrame.size(); i++) {
					System.out.println(photoFrame.get(i).getAttribute("src"));
					photoUrl[i]=photoFrame.get(i).getAttribute("src");
					System.out.println(photoUrl[i]);
				}
				
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
//					for (int i = 0; i < photoFrame.size(); i++) 
//					{
//						String webLink = photoFrame.get(i).getAttribute("src");
//						System.out.println(webLink);
				
					/*		r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_T);
						Thread.sleep(2000);
						r.keyRelease(KeyEvent.VK_CONTROL);
						r.keyRelease(KeyEvent.VK_T);
						
						String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
						
						String secondWindow = driver.getWindowHandle();
						Set<String> thirdWindow = driver.getWindowHandles();
						int NoOfWindows = thirdWindow.size();
						System.out.println("Total no of windows available are "+NoOfWindows);
						for (String string : thirdWindow) 
						{
							System.out.println(string);
							if (!string.equals(parentwindow) && !string.equals(secondWindow)) 
							{
								driver.switchTo().window(string);
								System.out.println("Thrid Window is Handeled");
								Thread.sleep(5000);
							} 
							
						}  */
					
						driver.get("https://image.online-convert.com/convert/webp-to-jpg");
						Thread.sleep(2000);
//						WebElement profileImage = driver.findElement(By.tagName("img"));
//						acc.contextClick(profileImage).build().perform();
//						r.keyPress(KeyEvent.VK_DOWN);
//						r.keyRelease(KeyEvent.VK_DOWN);
//						r.keyPress(KeyEvent.VK_DOWN);
//						r.keyRelease(KeyEvent.VK_DOWN);
//						r.keyPress(KeyEvent.VK_ENTER);
//						r.keyRelease(KeyEvent.VK_ENTER);
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
							try {
								driver.findElement(By.xpath("//*[text()='Ok']")).click();
							} catch (Exception e2) {
								System.out.println("alert is not available");
							}
							
						}
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='uploadbutton']")).click();
						
						WebElement EnterURL = driver.findElement(By.xpath("//*[@id='externalUrlInput']"));
						EnterURL.click();
						
						for (int i = 0; i < photoUrl.length; i++) 
						{
							if (photoUrl[i]!=null) 
							{
								EnterURL.sendKeys(photoUrl[i]);
								driver.findElement(By.xpath("//*[@id='externalUrlDialogOkButton']")).click();
								Thread.sleep(2000);
							}
							
						}
						Thread.sleep(4000);
						driver.findElement(By.xpath("(//*[text()=' Start conversion    '])[1]")).click();
						Thread.sleep(6000);
						
						List<WebElement> checkBox = driver.findElements(By.xpath("//*[@class='output-file-select']"));
						for (WebElement webElement : checkBox) 
						{	
							System.out.println("inside checkbox");
							if (webElement.isSelected()) 
							{
								System.out.println("The checkbox is selected");
							} else {
								System.out.println("The checkbox is not selected");
								webElement.click();
							}
						}
//						List<WebElement> Download = driver.findElements(By.xpath("//*[text()='Download']"));
//						for (WebElement webElement : Download) 
//						{
//							Thread.sleep(2000);
//							webElement.click();
//						}
						driver.findElement(By.xpath("//*[@class='zip-download zip-download-grey']")).click();
						
						Thread.sleep(7000);
						String fileName = null;
						//Search File in DIR
				      File dir = new File("C:\\Users\\admin\\Downloads");
				      FilenameFilter filter = new FilenameFilter() {
				         public boolean accept (File dir, String name) { 
				            return name.startsWith(profileIDText);
				         } 
				      }; 
				      String[] children = dir.list(filter);
				      if (children == null) {
				         System.out.println("Either dir does not exist or is not a directory"); 
				      } else { 
				         for (int i = 0; i< children.length; i++) {
				            fileName = children[i];
				            System.out.println(fileName);
				         } 
				      } 
						
						      
						//UNZIP the File in the DIR
				      	String zipFilePath = "C:\\Users\\admin\\Downloads\\"+fileName;
				        String destDirectory = "E:\\ImagesToCompare";
				        
				        try {
				            unzip(zipFilePath, destDirectory);
				        } catch (Exception ex) {
				            // some errors occurred
				            ex.printStackTrace();
				        }
				        
				        
				        //Search File in DIR  'E:\\ImagesToCompare'
				          String fileName1 = null;
					      File dir1 = new File("E:\\ImagesToCompare");
					      FilenameFilter filter1 = new FilenameFilter() {
					         public boolean accept (File dir, String name) { 
					            return name.startsWith(profileIDText);
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
					      
					      for (int i = 0; i < children1.length; i++) 
						     {
					    	  System.out.println("      i  = "+i);
								for (int j = i+1; j < children1.length; j++) 
								{	
									System.out.println("      i  = "+i);
									if (i!=j) 
									{
										System.out.println("       "+i+"-------->"+j);
										  BufferedImage imgA = null; 
									      BufferedImage imgB = null; 
									      System.out.println("After buff Image");
									      try
									      { 
									          File fileA = new File("E:\\ImagesToCompare\\"+children1[i]); 
									          File fileB = new File("E:\\ImagesToCompare\\"+children1[j]); 
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
									}
									
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
						  
						  if (repeatFlag) 
						  {
							  System.out.println("The Profile Id "+profileIDText+" has repeated photos. Please check...");
						  }
						  
						Thread.sleep(2000);
						driver.close();
						driver.switchTo().window(parentwindow);
						Thread.sleep(2000);
						
						
					//}

				}else if(photoFrame.size()==0)
				{
					System.out.println("there is some error in the taking the photos");
					System.out.println("----------NO PHOTO IS AVAILABLE----------");
					Thread.sleep(5000);
					try {
						System.out.println(photoFrame.get(0).getAttribute("src"));
					} catch (Exception e) {
						System.out.println("Exception Handled no photo is available");
					}
					Thread.sleep(2000);
					driver.close();
					driver.switchTo().window(parentwindow);
					Thread.sleep(2000);
				}else if(photoFrame.size()<0)
				{
					System.out.println("less that 0");
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
		 
	
	
			
	
}
