package Matrimony.matrimonyart;

import java.net.MalformedURLException;

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

public class Matches extends BaseTest
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
			
			
		/////////////////////////////REFINE SEARCH START FROM HERE///////////////////////
		//Select Age From
		try {
			System.out.println("------------Selecting the Options in Age From----------------");
			js.executeScript("window.scrollBy(0,100)");
			try {
				Thread.sleep(5000);
				WebElement AgeLabel = driver.findElement(By.id("facetAgelabel"));
				AgeLabel.click();
				Thread.sleep(5000);
				WebElement FMoreAge = driver.findElement(By.xpath("//*[@id='FMoreAge']/a"));
				FMoreAge.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("exception in age");
				Thread.sleep(5000);
				WebElement AgeLabel = driver.findElement(By.id("facetAgelabel"));
				AgeLabel.click();
				Thread.sleep(5000);
				WebElement FMoreAge = driver.findElement(By.xpath("//*[@id='FMoreAge']/a"));
				FMoreAge.click();
				Thread.sleep(5000);
				WebElement ageFrom = driver.findElement(By.id("ageFrom"));
				ageFrom.clear();
				Thread.sleep(5000);
				ageFrom.sendKeys("30");
				Thread.sleep(5000);
				WebElement ageTo = driver.findElement(By.id("ageTo"));
				ageTo.clear();
				Thread.sleep(5000);
				ageTo.sendKeys("29");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='Submit' and @class='send-active-btn big ']")).click();
				WebElement ageerr = driver.findElement(By.id("ageerr"));
				System.err.println(ageerr.getText());
			}
			Thread.sleep(5000);
			WebElement AgeLabel = driver.findElement(By.id("facetAgelabel"));
			AgeLabel.click();
			Thread.sleep(5000);
			WebElement FMoreAge = driver.findElement(By.xpath("//*[@id='FMoreAge']/a"));
			FMoreAge.click();
			Thread.sleep(5000);
			WebElement ageFrom = driver.findElement(By.id("ageFrom"));
			ageFrom.clear();
			Thread.sleep(5000);
			ageFrom.sendKeys("30");
			Thread.sleep(5000);
			WebElement ageTo = driver.findElement(By.id("ageTo"));
			ageTo.clear();
			Thread.sleep(5000);
			ageTo.sendKeys("29");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@value='Submit' and @class='send-active-btn big ']")).click();
			WebElement ageerr = driver.findElement(By.id("ageerr"));
			System.err.println(ageerr.getText());
			} catch (Exception e) {
				System.err.println("There is some Exception in the above Topic");
			}
		
		//Select Height From
		try {
			js.executeScript("window.scrollBy(0,150)");
			System.out.println("------------Selecting the Options in Height From----------------");
			Thread.sleep(5000);
			WebElement Heightlabel = driver.findElement(By.id("facetHeightlabel"));
			Heightlabel.click();
			Thread.sleep(5000);
			WebElement FMoreHeight = driver.findElement(By.xpath("//*[@id='FMoreHeight']/a"));
			FMoreHeight.click();
			Thread.sleep(5000);
			WebElement heightFrom = driver.findElement(By.id("heightFrom"));
			Select s = new Select(heightFrom);
			s.selectByVisibleText("4ft 8in - 142cm");
			WebElement heightTo = driver.findElement(By.id("heightTo"));
			Select s1 = new Select(heightTo);
			s1.selectByVisibleText("4ft 7in - 139cm");
			Thread.sleep(5000);
			WebElement submit = driver.findElement(By.xpath("//input[@value='Submit' and @class='send-active-btn big' ]"));
			submit.click();
			Thread.sleep(3000);
			WebElement heighterr = driver.findElement(By.id("heighterr"));
			System.err.println(heighterr.getText());
			
			} catch (Exception e) {
				System.err.println("There is some Exception in the above Topic");
			}
		
		//Select Marital Status From
		try {
			//Click on the Sent Mail
			js.executeScript("window.scrollBy(0,100)");
			System.out.println("------------Selecting the Options in Marital Status From----------------");
			Thread.sleep(5000);
			WebElement MaritalStatuslabel = driver.findElement(By.id("facetMaritalStatuslabel"));
			MaritalStatuslabel.click();
			Thread.sleep(5000);
			WebElement FMoreMaritalStatus = driver.findElement(By.xpath("//*[@id='FMoreMaritalStatus']/a"));
			FMoreMaritalStatus.click();
			Thread.sleep(5000);
			WebElement maritalStatus1 = driver.findElement(By.id("maritalStatus1"));
			if (maritalStatus1.isSelected()) 
			{
				maritalStatus1.click();
				Thread.sleep(2000);
				maritalStatus1.click();
				Thread.sleep(2000);
			} else 
			{
				maritalStatus1.click();
				Thread.sleep(2000);
			}
			
		} catch (Exception e) {
			System.err.println("There is some Exception in the above Topic");
		}
				
		//////////////////////ShowMore////////////////////////////////////////
		//Click on the ShowMore Option
		try {
			System.out.println("----------------Click on the ShowMore Option-----------------");
			WebElement showmore = driver.findElement(By.id("showmore"));
			Thread.sleep(3000);
			showmore.click();
			js.executeScript("window.scrollBy(0,100)");
			} catch (Exception e) {
					System.err.println("There is some Exception in the above Topic");
			}
				
			/*	
		//////////////////////Refine SEARCH START FROM HERE///////////////////////
		//Select Religionlabel From
		try {
			
			
			//js.executeScript("window.scrollBy(0,100)");
			System.out.println("------------Selecting the Options in Religion ----------------");
			Thread.sleep(5000);
			WebElement Religionlabel = driver.findElement(By.id("facetReligionlabel"));
			Religionlabel.click();
			Thread.sleep(5000);
			WebElement FMoreReligion = driver.findElement(By.xpath("//*[@id='FMoreReligion']/a"));
			FMoreReligion.click();
			Thread.sleep(5000);
			WebElement religion = driver.findElement(By.id("religion"));
			Select s = new Select(religion);
			s.selectByValue("11");
			} catch (Exception e) {
				System.err.println("There is some Exception in the above Topic");
			}

		
		
		
		//Select Mother Tongue From		
		try {
			//Click on the Sent Mail
			js.executeScript("window.scrollBy(0,150)");
			System.out.println("------------Selecting the Options in Mother Tongue From----------------");
			Thread.sleep(5000);
			WebElement MotherTonguelabel = driver.findElement(By.id("facetMotherTonguelabel"));
			MotherTonguelabel.click();
			Thread.sleep(5000);
			WebElement FMoreMotherTongue = driver.findElement(By.xpath("//*[@id='FMoreMotherTongue']/a"));
			FMoreMotherTongue.click();
			Thread.sleep(5000);
			
			// Select the Mother Tongue from the DropDown
			try {
				System.out.println();
				System.out.println("Select the Mother Tongue from the DropDown");
				WebElement motherTongueTemp = driver.findElement(By.id("motherTongueTemp"));
				Thread.sleep(5000);
				WebElement Any = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 1, 6)+"']"));
				acc.click(motherTongueTemp);
				acc.doubleClick(Any).build().perform();
				Thread.sleep(1000);
				
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
							System.err.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
							count++;
						}
					}
				}
				if (count==0) 
				{
					System.err.println("Nothing is visible on both the sides.");
				}
				} catch (Exception e) 
					{
						System.out.println("Inside Exception");
					}
			} catch (Exception e) 
			{
				System.err.println("There is some Exception in the above Topic");
			}
		
		
		//Select Mother Tongue From		
		try {
			//Click on the Sent Mail
			js.executeScript("window.scrollBy(0,150)");
			System.out.println("------------Selecting the Options in Mother Tongue From----------------");
			Thread.sleep(5000);
			WebElement facetCastelabel = driver.findElement(By.id("facetCastelabel"));
			facetCastelabel.click();
			Thread.sleep(5000);
			WebElement FMoreCaste = driver.findElement(By.xpath("//*[@id='FMoreCaste']/a"));
			FMoreCaste.click();
			Thread.sleep(5000);
			
			// Select the Mother Tongue from the DropDown
			try {
				System.out.println();
				System.out.println("Select the Mother Tongue from the DropDown");
				WebElement casteTemp = driver.findElement(By.id("casteTemp"));
				Thread.sleep(5000);
				WebElement Any = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 1, 6)+"']"));
				acc.click(casteTemp);
				acc.doubleClick(Any).build().perform();
				Thread.sleep(1000);
				
				WebElement caste = driver.findElement(By.id("caste"));
				Select mtp = new Select(casteTemp);
				Select mt = new Select(caste);
				int mtpsize = mtp.getOptions().size();
				int mtsize = mt.getOptions().size();
				count = 0;
				for (int i = 0; i < mtpsize; i++) 
				{
					for (int j = 0; j < mtsize; j++) 
					{
						if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
						{
							System.err.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
							count++;
						}
					}
				}
				if (count==0) 
				{
					System.err.println("Nothing is visible on both the sides.");
				}
				} catch (Exception e) 
					{
						System.out.println("Inside Exception");
					}
			} catch (Exception e) 
			{
				System.err.println("There is some Exception in the above Topic");
			}
		
		//Select Educational Details From		
		try {
			//Click on the Sent Mail
			js.executeScript("window.scrollBy(0,150)");
			System.out.println("------------Selecting the Options in Educational Details From----------------");
			Thread.sleep(5000);
			WebElement Educationlabel = driver.findElement(By.id("facetEducationlabel"));
			Educationlabel.click();
			Thread.sleep(5000);
			WebElement FMoreEducation = driver.findElement(By.xpath("//*[@id='FMoreEducation']/a"));
			FMoreEducation.click();
			Thread.sleep(5000);
					
			// Select the Educational Details from the DropDown
			try {
				System.out.println();
				System.out.println("Select the Educational Details from the DropDown");
				WebElement subeducationTemp = driver.findElement(By.id("subeducationTemp"));
				Thread.sleep(5000);
				WebElement Any = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 1, 8)+"']"));
				acc.click(subeducationTemp);
				acc.doubleClick(Any).build().perform();
				Thread.sleep(1000);
				
				WebElement subeducation = driver.findElement(By.id("subeducation"));
				Select mtp = new Select(subeducationTemp);
				Select mt = new Select(subeducation);
				int mtpsize = mtp.getOptions().size();
				int mtsize = mt.getOptions().size();
				count = 0;
				for (int i = 0; i < mtpsize; i++) 
				{
					for (int j = 0; j < mtsize; j++) 
					{
						if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
						{
							System.err.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
							count++;
						}
					}
				}
				if (count==0) 
				{
					System.err.println("Nothing is visible on both the sides.");
				}
				} catch (Exception e) 
					{
						System.out.println("Inside Exception");
					}
			} catch (Exception e) 
			{
				System.err.println("There is some Exception in the above Topic");
			}
		
			//Select Family Type From
			try {
				js.executeScript("window.scrollBy(0,150)");
				System.out.println("------------Selecting the Options in Family Type From----------------");
				Thread.sleep(5000);
				WebElement FamilyTypelabel = driver.findElement(By.id("facetFamilyTypelabel"));
				FamilyTypelabel.click();
				Thread.sleep(5000);
				WebElement FMoreFamilyType = driver.findElement(By.xpath("//*[@id='FMoreFamilyType']/a"));
				FMoreFamilyType.click();
				Thread.sleep(5000);
				WebElement FamilyType2 = driver.findElement(By.id("FamilyType2"));
				if (FamilyType2.isSelected()) 
				{
					FamilyType2.click();
					Thread.sleep(2000);
					FamilyType2.click();
					Thread.sleep(2000);
				} else 
				{
					FamilyType2.click();
					Thread.sleep(2000);
				}
				
			} catch (Exception e) {
				System.err.println("There is some Exception in the above Topic");
			}
			
			//Select Family Status From
			try {
				js.executeScript("window.scrollBy(0,150)");
				System.out.println("------------Selecting the Options in Family Status ----------------");
				Thread.sleep(5000);
				WebElement FamilyStatuslabel = driver.findElement(By.id("facetFamilyStatuslabel"));
				FamilyStatuslabel.click();
				Thread.sleep(5000);
				WebElement FMoreFamilyStatus = driver.findElement(By.xpath("//*[@id='FMoreFamilyStatus']/a"));
				FMoreFamilyStatus.click();
				Thread.sleep(5000);
				WebElement FamilyStatus1 = driver.findElement(By.id("FamilyStatus1"));
				if (FamilyStatus1.isSelected()) 
				{
					FamilyStatus1.click();
					Thread.sleep(2000);
					FamilyStatus1.click();
					Thread.sleep(2000);
				} else 
				{
					FamilyStatus1.click();
					Thread.sleep(2000);
				}
				
				} catch (Exception e) {
					System.err.println("There is some Exception in the above Topic");
				}		
			
			//Select EmployedIn 
			try {
				js.executeScript("window.scrollBy(0,150)");
				System.out.println("------------Selecting the Options in EmployedIn  ----------------");
				Thread.sleep(5000);
				WebElement EmployedInlabel = driver.findElement(By.id("facetEmployedInlabel"));
				EmployedInlabel.click();
				Thread.sleep(5000);
				WebElement FMoreEmployedIn = driver.findElement(By.xpath("//*[@id='FMoreEmployedIn']/a"));
				FMoreEmployedIn.click();
				Thread.sleep(5000);
				WebElement occupationCat7 = driver.findElement(By.id("occupationCat7"));
				if (occupationCat7.isSelected()) 
				{
					occupationCat7.click();
					Thread.sleep(2000);
					occupationCat7.click();
					Thread.sleep(2000);
				} else 
				{
					occupationCat7.click();
					Thread.sleep(2000);
				}
				
				} catch (Exception e) {
					System.err.println("There is some Exception in the above Topic");
				}	
			
			//Select Occupation		
			try {
				//Click on the Sent Mail
				js.executeScript("window.scrollBy(0,150)");
				System.out.println("------------Selecting the Options in Occupation ----------------");
				Thread.sleep(5000);
				WebElement Occupationlabel = driver.findElement(By.id("facetOccupationlabel"));
				Occupationlabel.click();
				Thread.sleep(5000);
				WebElement FMoreOccupation = driver.findElement(By.xpath("//*[@id='FMoreOccupation']/a"));
				FMoreOccupation.click();
				Thread.sleep(5000);
						
				// Select the Occupation from the DropDown
				try {
					System.out.println();
					System.out.println("Select the Occupation from the DropDown");
					WebElement occupationTemp = driver.findElement(By.id("occupationTemp"));
					Thread.sleep(5000);
					WebElement Any = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 1, 8)+"']"));
					acc.click(occupationTemp);
					acc.doubleClick(Any).build().perform();
					Thread.sleep(1000);
					
					WebElement occupation = driver.findElement(By.id("occupation"));
					Select mtp = new Select(occupationTemp);
					Select mt = new Select(occupation);
					int mtpsize = mtp.getOptions().size();
					int mtsize = mt.getOptions().size();
					count = 0;
					for (int i = 0; i < mtpsize; i++) 
					{
						for (int j = 0; j < mtsize; j++) 
						{
							if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
							{
								System.err.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
								count++;
							}
						}
					}
					if (count==0) 
					{
						System.err.println("Nothing is visible on both the sides.");
					}
					} catch (Exception e) 
						{
							System.out.println("Inside Exception");
						}
				} catch (Exception e) 
				{
					System.err.println("There is some Exception in the above Topic");
				}
			
			//Select Annual Income
			try {
				js.executeScript("window.scrollBy(0,100)");
				System.out.println("------------Selecting the Options in Annual Income From----------------");
				Thread.sleep(5000);
				WebElement AnnualIncomelabel = driver.findElement(By.id("facetAnnualIncomelabel"));
				AnnualIncomelabel.click();
				Thread.sleep(5000);
				WebElement FMoreAnnualIncome = driver.findElement(By.xpath("//*[@id='FMoreAnnualIncome']/a"));
				FMoreAnnualIncome.click();
				Thread.sleep(5000);
				WebElement annualIncome = driver.findElement(By.id("annualIncome"));
				Select s = new Select(annualIncome);
				s.selectByValue("9");
				Thread.sleep(5000);
				WebElement annualIncome1 = driver.findElement(By.id("annualIncome1"));
				Select s1 = new Select(annualIncome1);
				s1.selectByValue("8");
				Thread.sleep(5000);
				WebElement submit = driver.findElement(By.xpath("//input[@value='Submit' and @class='send-active-btn big' ]"));
				submit.click();
				Thread.sleep(3000);
				WebElement annualIncomeerr = driver.findElement(By.id("annualIncomeerr"));
				System.err.println(annualIncomeerr.getText());
				
				} catch (Exception e) {
					System.err.println("There is some Exception in the above Topic");
				}
			
			//Select Country		
			try {
				//Click on the Sent Mail
				js.executeScript("window.scrollBy(0,100)");
				System.out.println("------------Selecting the Options in Country ----------------");
				Thread.sleep(5000);
				WebElement facetCountrylabel = driver.findElement(By.id("facetCountrylabel"));
				facetCountrylabel.click();
				Thread.sleep(5000);
				WebElement FMoreCountry = driver.findElement(By.xpath("//*[@id='FMoreCountry']/a"));
				FMoreCountry.click();
				Thread.sleep(5000);
						
		// Select the facetCountrylabel from the DropDown
		try {
			System.out.println();
			System.out.println("Select the Countrylabel from the DropDown");
			WebElement countryTemp = driver.findElement(By.id("countryTemp"));
			Thread.sleep(5000);
			WebElement Any = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 1, 8)+"']"));
			acc.click(countryTemp);
			acc.doubleClick(Any).build().perform();
			Thread.sleep(1000);
			
			WebElement country = driver.findElement(By.id("country"));
			Select mtp = new Select(countryTemp);
			Select mt = new Select(country);
			int mtpsize = mtp.getOptions().size();
			int mtsize = mt.getOptions().size();
			count = 0;
			for (int i = 0; i < mtpsize; i++) 
			{
				for (int j = 0; j < mtsize; j++) 
				{
					if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
					{
						System.err.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
						count++;
					}
				}
			}
			if (count==0) 
			{
				System.err.println("Nothing is visible on both the sides.");
			}
			} catch (Exception e) 
				{
					System.out.println("Inside Exception");
				}
		} catch (Exception e) 
		{
			System.err.println("There is some Exception in the above Topic");
		}
			
			
			
			//Select ResidentStatuslabel
			try {
				js.executeScript("window.scrollBy(0,100)");
				System.out.println("------------Selecting the Options in ResidentStatuslabel----------------");
				Thread.sleep(5000);
				WebElement ResidentStatuslabel = driver.findElement(By.id("facetResidentStatuslabel"));
				ResidentStatuslabel.click();
				Thread.sleep(5000);
				WebElement FMoreResidentStatus = driver.findElement(By.xpath("//*[@id='FMoreResidentStatus']/a"));
				FMoreResidentStatus.click();
				Thread.sleep(5000);
				WebElement residentStatus1 = driver.findElement(By.id("residentStatus1"));
				if (residentStatus1.isSelected()) 
				{
					residentStatus1.click();
					Thread.sleep(2000);
					residentStatus1.click();
					Thread.sleep(2000);
				} else 
				{
					residentStatus1.click();
					Thread.sleep(2000);
				}
				
			} catch (Exception e) {
				System.err.println("There is some Exception in the above Topic");
			}
			
			
		//Select Citizenship		
		try {
			//Click on the Sent Mail
			js.executeScript("window.scrollBy(0,100)");
			System.out.println("------------Selecting the Options in Citizenship ----------------");
			Thread.sleep(5000);
			WebElement facetCitizenshiplabel = driver.findElement(By.id("facetCitizenshiplabel"));
			facetCitizenshiplabel.click();
			Thread.sleep(5000);
			WebElement FMoreCitizenship = driver.findElement(By.xpath("//*[@id='FMoreCitizenship']/a"));
			FMoreCitizenship.click();
			Thread.sleep(5000);
						
		// Select the Citizenship from the DropDown
		try {
			System.out.println();
			System.out.println("Select the Citizenship from the DropDown");
			WebElement citizenshipTemp = driver.findElement(By.id("citizenshipTemp"));
			Thread.sleep(5000);
			WebElement Any = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 1, 8)+"']"));
			acc.click(citizenshipTemp);
			acc.doubleClick(Any).build().perform();
			Thread.sleep(1000);
			
			WebElement citizenship = driver.findElement(By.id("citizenship"));
			Select mtp = new Select(citizenshipTemp);
			Select mt = new Select(citizenship);
			int mtpsize = mtp.getOptions().size();
			int mtsize = mt.getOptions().size();
			count = 0;
			for (int i = 0; i < mtpsize; i++) 
			{
				for (int j = 0; j < mtsize; j++) 
				{
					if (mtp.getOptions().get(i).getText().equals(mt.getOptions().get(j).getText())) 
					{
						System.err.println(mtp.getOptions().get(i).getText()+"  is visible on both the sides.");
						count++;
					}
				}
			}
			if (count==0) 
			{
				System.err.println("Nothing is visible on both the sides.");
			}
			} catch (Exception e) 
				{
					System.out.println("Inside Exception");
				}
		} catch (Exception e) 
		{
			System.err.println("There is some Exception in the above Topic");
		}
		
		
		//Select PhysicalStatus
		try {
			js.executeScript("window.scrollBy(0,100)");
			System.out.println("------------Selecting the Options in PhysicalStatus----------------");
			Thread.sleep(5000);
			WebElement facetPhysicalStatuslabel = driver.findElement(By.id("facetPhysicalStatuslabel"));
			facetPhysicalStatuslabel.click();
			Thread.sleep(5000);
			WebElement FMorePhysicalStatus = driver.findElement(By.xpath("//*[@id='FMorePhysicalStatus']/a"));
			FMorePhysicalStatus.click();
			Thread.sleep(5000);
			WebElement physicalStatus0 = driver.findElement(By.id("physicalStatus0"));
			if (physicalStatus0.isSelected()) 
			{
				physicalStatus0.click();
				Thread.sleep(2000);
				physicalStatus0.click();
				Thread.sleep(2000);
			} else 
			{
				physicalStatus0.click();
				Thread.sleep(2000);
			}
			
		} catch (Exception e) {
			System.err.println("There is some Exception in the above Topic");
		}
		
		//Select Complexion
		try {
			js.executeScript("window.scrollBy(0,100)");
			System.out.println("------------Selecting the Options in Complexion----------------");
			Thread.sleep(5000);
			WebElement facetComplexionlabel = driver.findElement(By.id("facetComplexionlabel"));
			facetComplexionlabel.click();
			Thread.sleep(5000);
			WebElement FMoreComplexion = driver.findElement(By.xpath("//*[@id='FMoreComplexion']/a"));
			FMoreComplexion.click();
			Thread.sleep(5000);
			WebElement complexion2 = driver.findElement(By.id("complexion2"));
			if (complexion2.isSelected()) 
			{
				complexion2.click();
				Thread.sleep(2000);
				complexion2.click();
				Thread.sleep(2000);
			} else 
			{
				complexion2.click();
				Thread.sleep(2000);
			}
			
		} catch (Exception e) {
			System.err.println("There is some Exception in the above Topic");
		}*/
		
		
		///////////////////////////////////vijay/////////////////////////////////
		///body type///
		try {
			js.executeScript("window.scrollBy(0,100)");
			System.out.println("------------Selecting the Options in BodyType----------------");
			Thread.sleep(5000);
			WebElement facetComplexionlabel = driver.findElement(By.id("facetBodytypelabel"));
			facetComplexionlabel.click();
			Thread.sleep(5000);
			WebElement FMoreComplexion = driver.findElement(By.xpath("//*[@id='FMoreBodytype']/a"));
			FMoreComplexion.click();
			Thread.sleep(5000);
			WebElement complexion2 = driver.findElement(By.id("bodyType1"));
			if (complexion2.isSelected()) 
			{
				complexion2.click();
				Thread.sleep(2000);
				complexion2.click();
				Thread.sleep(2000);
			} else 
			{
				complexion2.click();
				Thread.sleep(2000);
			}
			
		} catch (Exception e) {
			System.err.println("There is some Exception in the above Topic");
		}
		
	
		     
		//eating habit//
		System.out.println("-------------------Selecting the Options in Eating Habits---------------");
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.id("facetEatinglabel")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='FMoreEating']/a")).click();

		Thread.sleep(5000);

		WebElement eating = driver.findElement(By.id("eating1"));

		try {
		if (eating.isSelected()) {
		Thread.sleep(5000);

		eating.click();
		Thread.sleep(5000);

		eating.click();
		}else if (!eating.isSelected()) {
		eating.click();


		}{

		}
		} catch (Exception e) {
			System.err.println("There is some Exception in the above Topic");
		}


		//smoke//
		System.out.println("-------------------Selecting the Options in Smoking ---------------");
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.id("facetSmokelabel")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='FMoreSmoke']/a")).click();

		Thread.sleep(5000);

		WebElement smoke = driver.findElement(By.id("smoking2"));
		try {
		if (smoke.isSelected()) {
		Thread.sleep(5000);

		smoke.click();
		Thread.sleep(5000);

		smoke.click();
		}else if (!smoke.isSelected()) {
		smoke.click();


		}{

		}
		} catch (Exception e) {
		System.err.println("There is some Exception in the above Topic");
		}

		///drink//
		System.out.println("-------------------Selecting the Options in  Drinking---------------");
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.id("facetDrinklabel")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='FMoreDrink']/a")).click();

		Thread.sleep(5000);

		WebElement drink = driver.findElement(By.id("drinking1"));
		try {
		if (drink.isSelected()) {
		Thread.sleep(5000);

		drink.click();
		Thread.sleep(5000);

		drink.click();
		}else if (!drink.isSelected()) {
		drink.click();


		}{

		}
		} catch (Exception e) {
			System.err.println("There is some Exception in the above Topic");
		}

		//profile creted for//
		System.out.println("-------------------Selecting the Options in Profile Created---------------");
		js.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.id("facetProfileCreatedBylabel")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='FMoreProfileCreatedBy']/a")).click();

		Thread.sleep(5000);

		WebElement pcb = driver.findElement(By.id("createdBy1"));
		try {
		if (pcb.isSelected()) {
		Thread.sleep(5000);

		pcb.click();
		Thread.sleep(5000);

		pcb.click();
		}else if (!pcb.isSelected()) {
		pcb.click();


		}{

		}
		} catch (Exception e) {
			System.err.println("There is some Exception in the above Topic");
		}
			
			
		//////////////////////////////////vijay/////////////////////////////////		
	}		
			

}



