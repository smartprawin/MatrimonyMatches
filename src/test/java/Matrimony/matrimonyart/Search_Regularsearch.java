package Matrimony.matrimonyart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.apache.poi.util.SystemOutLogger;
import org.hamcrest.core.IsEqual;
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

import com.thoughtworks.selenium.webdriven.commands.DoubleClick;


public class Search_Regularsearch extends BaseTest
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
		//Robot r = new Robot();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js  = (JavascriptExecutor)driver;

		//Open URL	
		Thread.sleep(3000);
		driver.get(BaseTest.getExcelsearchnep("Authenticate", 1, 3));
		driver.manage().window().maximize();
		
		//Enter Username and Password from Excel
		Thread.sleep(1000);
		BaseTest.click(g.getMatriID());
		BaseTest.typeData(g.getMatriID(), getExcelsearchnep("Authenticate", 1, 0));
		Thread.sleep(1000);
		BaseTest.click(g.getPasswordClear());
		BaseTest.typeData(g.getPassword(), getExcelsearchnep("Authenticate", 1, 1));
		
		//Click on the LoginButton
		Thread.sleep(3000);
		BaseTest.click(g.getLogin_btn());
		
		//Skip the intermediate page
		try {
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//a[@class='clr7']")));
			} catch (Exception e) {
				System.out.println("Exception");
			}
			
		//Handling the Notification

			Thread.sleep(5000);

		//click on the SEARCH in the tab	
			try {
				driver.findElement(By.xpath("//a[text()='Search']")).click();
				
			} catch (Exception e) 
			{
				System.out.println("The element search is not able to find and flag is raised");
			}
			
			Thread.sleep(5000);
			
		/*/////////////////////////////////////SCENARIO 1/////////////////////////////////////	
		//Select "Age to" in the DropDown 
			Thread.sleep(5000);
			BaseTest.select_text(driver.findElement(By.id("ageTo")),BaseTest.getExcelsearchnep("Sheet1", 1, 2));
			System.out.println("From Age is 31 and the to age is 29 ");
			
		//Check the visibility of the warning 
            WebElement agegrater = driver.findElement(By.id("ageerr"));
			Thread.sleep(5000);
            if (agegrater.isDisplayed()) 
            {
				System.out.println("'Age to' is not greater than 'Age from ='   : "+ agegrater.getText());
			}else 
			{
				System.out.println("'Age to' is greater than 'Age from' so no warning has been shown");
			}
            
         ////////////////////////////////////SCENARIO 2//////////////////////////////////////
        //Select "Height form" in the DropDown
            
            Thread.sleep(5000);
            BaseTest.select_text(driver.findElement(By.id("heightFrom")), BaseTest.getExcelsearchnep("Sheet1", 1, 3));
            
       
       //Check the visibility of the warning
            WebElement heighterr = driver.findElement(By.id("heighterr"));
            if (heighterr.isDisplayed()) 
            {
            	System.out.println("'Height to' is not greater than 'Height from ='   : "+ heighterr.getText());
			}else 
			{
				System.out.println("'Height to' is greater than 'Height from' so no warning has been shown");
			}
            
        ///////////////////////////////////////SCENARIO 3//////////////////////////////////
        // Check on Maratial Status in the checkbox
            
            Thread.sleep(5000);
            BaseTest.click(driver.findElement(By.xpath("//*[@id=\"maritalStatus2\"]")));
            BaseTest.click(driver.findElement(By.xpath("//*[@id=\"maritalStatus4\"]")));
            
        //Check the visibility of the Child Status
            WebElement childStatus = driver.findElement(By.xpath("//*[text()='Have Children']"));
            Thread.sleep(3000);
            if (childStatus.isDisplayed()) 
            {
				System.out.println(childStatus.getText()+"  status bar is displayed");
			}else
			{
				System.out.println("Child Status is not displayed");
			}
            */
			

	      //////////////////////////////////////SCENARIO 4/////////////////////////////////
	      // Select the Clan from the DropDown
			
			try {
				System.out.println();
				System.out.println("Select the Clan from the DropDown");
				WebElement casteTemp = driver.findElement(By.id("casteTemp"));
	            Thread.sleep(5000);
	            WebElement Gakhars = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 22)+"']"));
	            WebElement Rawns = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 22)+"']"));
	            acc.click(casteTemp);
	            acc.doubleClick(Gakhars).build().perform();
	            Thread.sleep(1000);
	            acc.doubleClick(Rawns).build().perform();
	            Thread.sleep(1000);
	            System.out.println("Get all selected options");
	            WebElement caste = driver.findElement(By.id("caste"));
	            Select castemp = new Select(casteTemp);
	            Select cas = new Select(caste);
	            int ctsize = castemp.getOptions().size();
	            int csize = cas.getOptions().size();
	            count = 0;
	            for (int i = 0; i < ctsize; i++) 
	            {
					for (int j = 0; j < csize; j++) 
					{
						if (castemp.getOptions().get(i).getText().equals(cas.getOptions().get(j).getText())) 
						{
							System.out.println(castemp.getOptions().get(i).getText()+"  is visible on both the sides.");
							count++;
						}
					}
				}
	            if (count==0) 
	            {
	            	System.out.println("Nothing is visible on both the sides.");
				}
			} catch (Exception e) {
				System.out.println("Exception");
			}
			
		      //////////////////////////////////////SCENARIO 5/////////////////////////////////
		      // Select the Branch from the DropDown
				try {
					System.out.println();
					System.out.println("Select the Branch from the DropDown");
					WebElement casteTemp = driver.findElement(By.id("casteTemp"));
		            Thread.sleep(5000);
		            WebElement Nichiren = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 23)+"']"));
		            WebElement Mahayana = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 23)+"']"));
		            acc.click(casteTemp);
		            acc.doubleClick(Nichiren).build().perform();
		            Thread.sleep(1000);
		            acc.doubleClick(Mahayana).build().perform();
		            Thread.sleep(1000);
		            System.out.println("Get all selected options");
		            WebElement caste = driver.findElement(By.id("caste"));
		            Select castemp = new Select(casteTemp);
		            Select cas = new Select(caste);
		            int ctsize = castemp.getOptions().size();
		            int csize = cas.getOptions().size();
		            count = 0;
		            for (int i = 0; i < ctsize; i++) 
		            {
						for (int j = 0; j < csize; j++) 
						{
							if (castemp.getOptions().get(i).getText().equals(cas.getOptions().get(j).getText())) 
							{
								System.out.println(castemp.getOptions().get(i).getText()+"  is visible on both the sides.");
								count++;
							}
						}
					}
		            if (count==0) 
		            {
		            	System.out.println("Nothing is visible on both the sides.");
					}
				} catch (Exception e) {
					System.out.println("Exception");
				}
	            
        //////////////////////////////////////SCENARIO 6/////////////////////////////////
        // Select the Mother Tongue from the DropDown
			try {
				System.out.println();
				System.out.println("Select the Mother Tongue from the DropDown");
	            WebElement motherTongueTemp = driver.findElement(By.id("motherTongueTemp"));
	            Thread.sleep(5000);
	            WebElement bengali = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 6)+"']"));
	            WebElement Miji = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 6)+"']"));
	            WebElement Tamil = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 4, 6)+"']"));
	            acc.click(motherTongueTemp);
	            acc.doubleClick(bengali).build().perform();
	            Thread.sleep(1000);
	            acc.doubleClick(Miji).build().perform();
	            Thread.sleep(1000);
	            acc.doubleClick(Tamil).build().perform();
	            Thread.sleep(1000);
	            System.out.println("Get all selected options");
	            WebElement motherTongue = driver.findElement(By.id("motherTongue"));
	            Select mtp = new Select(motherTongueTemp);
	            Select mt = new Select(motherTongue);
	            int mtpsize = mtp.getOptions().size();
	            int mtsize = mt.getOptions().size();
	            count = 0;
	            for (int i = 0; i < mtpsize; i++) 
	            {
					for (int j = 0; j < mtsize; j++) 
					{
						if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
						{
							System.out.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
							count++;
						}
					}
				}
	            if (count==0) 
	            {
	            	System.out.println("Nothing is visible on both the sides.");
				}
			} catch (Exception e) {
				System.out.println("Exception");
			}
                        
		//////////////////////////////////////SCENARIO 7/////////////////////////////////
		// Select the Country Living from the DropDown
		try {
			System.out.println();
			System.out.println("Select the Country Living from the DropDown");
            WebElement countryTemp = driver.findElement(By.id("countryTemp"));
            Thread.sleep(5000);
            WebElement Albania = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 10)+"']"));
            WebElement Bangladesh = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 10)+"']"));
            WebElement India = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 4, 10)+"']"));
            acc.click(countryTemp);
            acc.doubleClick(Albania).build().perform();
            Thread.sleep(1000);
            acc.doubleClick(Bangladesh).build().perform();
            Thread.sleep(1000);
            acc.doubleClick(India).build().perform();
            Thread.sleep(1000);
            System.out.println("Get all selected options");
            WebElement country = driver.findElement(By.id("country"));
            Select ctp = new Select(countryTemp);
            Select cntry = new Select(country);
            int ctpsize = ctp.getOptions().size();
            int cysize = cntry.getOptions().size();
            count = 0;
            for (int i = 0; i < ctpsize; i++) 
            {
				for (int j = 0; j < cysize; j++) 
				{
					if (ctp.getOptions().get(i).getText().equals(cntry.getOptions().get(j).getText())) 
					{
						System.out.println(ctp.getOptions().get(i).getText()+"  is visible on both the sides.");
						count++;
					}
				}
			}
            if (count==0) 
            {
            	System.out.println("Nothing is visible on both the sides.");
			}
		} catch (Exception e) {
			System.out.println("Exception");
		}
		
		
		//////////////////////////////////////SCENARIO 8/////////////////////////////////
		// Select the State from the DropDown
		try {
			System.out.println();
			System.out.println("Select the State from the DropDown");
			WebElement residingStateTemp = driver.findElement(By.id("residingStateTemp"));
			Thread.sleep(5000);
			WebElement Chhattisgarh = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 24)+"']"));
			WebElement Goa = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 24)+"']"));
			acc.click(residingStateTemp);
			acc.doubleClick(Chhattisgarh).build().perform();
			Thread.sleep(1000);
			acc.doubleClick(Goa).build().perform();
			Thread.sleep(1000);
			System.out.println("Get all selected options");
			WebElement residingState = driver.findElement(By.id("residingState"));
			Select mtp = new Select(residingStateTemp);
			Select mt = new Select(residingState);
			int mtpsize = mtp.getOptions().size();
			int mtsize = mt.getOptions().size();
			count = 0;
			for (int i = 0; i < mtpsize; i++) 
			{
				for (int j = 0; j < mtsize; j++) 
				{
				if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
				{
					System.out.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
					count++;
				}
				}
			}
			if (count==0) 
			{
			System.out.println("Nothing is visible on both the sides.");
			}
		} catch (Exception e) {
		System.out.println("Exception");
		}

		
		
		//////////////////////////////////////SCENARIO 9/////////////////////////////////
		// Select the City from the DropDown
		try {
			System.out.println();
			System.out.println("Select the City from the DropDown");
			WebElement residingCityTemp = driver.findElement(By.id("residingCityTemp"));
			Thread.sleep(5000);
			WebElement Durg = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 25)+"']"));
			WebElement Surguja = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 25)+"']"));
			acc.click(residingCityTemp);
			acc.doubleClick(Durg).build().perform();
			Thread.sleep(1000);
			acc.doubleClick(Surguja).build().perform();
			Thread.sleep(1000);
			System.out.println("Get all selected options");
			WebElement residingCity = driver.findElement(By.id("residingCity"));
			Select mtp = new Select(residingCityTemp);
			Select mt = new Select(residingCity);
			int mtpsize = mtp.getOptions().size();
			int mtsize = mt.getOptions().size();
			count = 0;
			for (int i = 0; i < mtpsize; i++) 
			{
				for (int j = 0; j < mtsize; j++) 
				{
				if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
				{
					System.out.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
					count++;
				}
				}
			}
			if (count==0) 
			{
			System.out.println("Nothing is visible on both the sides.");
			}
		} catch (Exception e) {
		System.out.println("Exception");
		}
		
		
		
		
		//////////////////////////////////////SCENARIO 10/////////////////////////////////
		// Select the Education from the DropDown
		try {
			System.out.println();
			System.out.println("Select the Education from the DropDown");
			WebElement educationTemp = driver.findElement(By.id("educationTemp"));
			Thread.sleep(5000);
			WebElement MFA = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 8)+"']"));
			WebElement BBA  = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 8)+"']"));
			acc.click(educationTemp);
			acc.doubleClick(MFA).build().perform();
			Thread.sleep(1000);
			acc.doubleClick(BBA).build().perform();
			Thread.sleep(1000);
			System.out.println("Get all selected options");
			WebElement education = driver.findElement(By.id("education"));
			Select edutemp = new Select(educationTemp);
			Select edu = new Select(education);
			int etsize = edutemp.getOptions().size();
			int edusize = edu.getOptions().size();
			count = 0;
			for (int i = 0; i < etsize; i++) 
			{
				for (int j = 0; j < edusize; j++) 
				{
					if (edutemp.getOptions().get(i).getText().equals(edu.getOptions().get(j).getText())) 
					{
						System.out.println(edutemp.getOptions().get(i).getText()+"  is visible on both the sides.");
						count++;
					}
				}
			}
			if (count==0) 
			{
				System.out.println("Nothing is visible on both the sides.");
			}
		} catch (Exception e) 
		{
			System.out.println("Exception");
		}	
            

            
      
	}		
}