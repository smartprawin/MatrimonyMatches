package Matrimony.matrimonyart;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.openqa.selenium.interactions.Actions;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

 



public class BaseTest {
	/*public static ExtentReports reports;
    public static ExtentTest test;*/
   // ExtentHtmlReporter reporter;
    String html = "DivorceeReport.html";
    public static WebDriver driver;
    static String currentUrl,Clasfiation,a,b,c,d,e1,f;
    public static String Profile_Created,Name,Age,Height,Gender,Marital_status,Mother_Tongue,
    Physical_Status,Body_Type,Complexion,Language__Known,Star,Rasi,SubCaste,
    Gothram,Dosham,Education,Education_Detail,Occupation,Occupation_Detail,
    Employeed_In,Annual_Income,City,State,Country,Citizenship, Religion;
	
    public static WebDriver driverInit(String BrowserName) {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\lib\\chromedriver.exe");
		if (BrowserName.equals("Chrome")) {
			driver = new ChromeDriver();
			driver.get("https://www.khanacademy.org/");
			driver.manage().window().maximize();
		}

		else if (BrowserName.equals("ie")) {
			driver = new InternetExplorerDriver();
		}

		else if (BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
    
    
    public static void click(WebElement element) {	
		element.click();

	}
	 
	 public static void clear(WebElement element) {	
			element.clear();
	 }
			
	 public static void typeData(WebElement element, String Value) {
		element.sendKeys(Value);

	}
	 public static void Refine_Submit() 
	 {
		 driver.findElement(By.xpath("//*[@value='Submit']")).submit();
	 }
	 ////////////////////////////
	 
////////////////Drop Down Base//////////////////
		
public static void select_string(WebElement element, String Value) {
Select s = new Select(element);
s.selectByValue(Value);
}


public static void select_index(WebElement element, int Value) {
Select s = new Select(element);
s.selectByIndex(Value);	
}




public static void select_text(WebElement element, String text) {
Select s = new Select(element);
s.selectByVisibleText(text);
}


public static void select_deselectAll(WebElement element) {
	Select s = new Select(element);
	s.deselectAll();
}


//////////    Excel    COde   ///////////////////////
public static String getExcelDataUrl(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\excel.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}



public static String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\excel.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}

public static String getExcelDatappnegative(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\excelPPnegativenep.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}



public static String getExcelDatachangepassword(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\changepassword.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}

public static String getExcelDatasearch(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\searchnep.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}

public static String getExcelDatarefine(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\refine.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}

public static String getExcelDatanegativeditpi(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\editpinegative.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}

public static String getExcelsearchnep(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\Java\\Window7\\First\\matrimonyart\\Excel\\searchnep.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}

public static String getExcelUpgrade(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\Java\\Window7\\First\\matrimonyart\\Excel\\searchnep.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 String data = row.getCell(colNum).getStringCellValue();
	return data;
}

public static int getExcelRandomRowNum(String sheetName) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBS\\Excel\\SMSTEST.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Random rand = new Random();
 int rowNum = rand.nextInt(sh.getLastRowNum());
 return rowNum;
}
public static void setExcelData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\excel.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 Cell cel = row.createCell(colNum);
 cel.setCellValue(data);
 FileOutputStream fos = new FileOutputStream("C:\\Users\\vijay\\Desktop\\office\\matrimony.com\\Excel\\excel.xlsx");
	wb.write(fos);
}



public static void setExcelDataUrl(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBS\\Excel\\LoginTestData_Mohan2222.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 Cell cel = row.createCell(colNum);
 cel.setCellValue(data);
 FileOutputStream fos = new FileOutputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBS\\Excel\\LoginTestData_Mohan2222.xlsx");
	wb.write(fos);
}



public static int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBS\\Excel\\SMSTEST.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 int rowIndex = wb.getSheet(sheetName).getLastRowNum();
 return rowIndex;
}

public static void setExcelDataInteg(String sheetName, int rowNum, int colNum,int data) throws Throwable{
	FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBS\\Excel\\SMSTEST.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet(sheetName);
 Row row = sh.getRow(rowNum);
 Cell cel = row.createCell(colNum);
 cel.setCellValue(data);
 FileOutputStream fos = new FileOutputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBS\\Excel\\SMSTEST.xlsx");
	wb.write(fos);
	//.close();

}


public static int getCellCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\amuthan\\eclipse-workspace\\CBS\\Excel\\SMSTEST.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(0);
int cell = row.getLastCellNum();
return cell;
}

public static void dubClick(WebElement element) throws InterruptedException 
{
	driver = new ChromeDriver();
	Actions acc = new Actions(driver);
	acc.doubleClick(element).build().perform();
	Thread.sleep(1000);
}

public static void mouseOver(WebElement element) throws InterruptedException {
	driver = new ChromeDriver();
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	System.out.println("-----------------mouse over----------------");
	Thread.sleep(2000);
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public static void verifyDropdown(WebElement Temp, WebElement Needed, WebElement para1, WebElement para2, WebElement para3) throws InterruptedException
{
	//WebElement Temp = driver.findElement(By.id("countryTemp"));
    Thread.sleep(5000);
//    WebElement Albania = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 2, 10)+"']"));
//    WebElement Bangladesh = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 3, 10)+"']"));
//    WebElement India = driver.findElement(By.xpath("//*[text()='"+BaseTest.getExcelsearchnep("Sheet1", 4, 10)+"']"));
    Temp.click();
    System.out.println("temp is clicked");
    mouseOver(para1);
    dubClick(para1);
    dubClick(para2);
    dubClick(para3);
    System.out.println("Get all selected options");
    //WebElement Needed = driver.findElement(By.id("country"));
    Select ctp = new Select(Temp);
    Select c = new Select(Needed);
    int ctpsize = ctp.getOptions().size();
    int csize = c.getOptions().size();
    int count = 0;
    for (int i = 0; i < ctpsize; i++) 
    {
		for (int j = 0; j < csize; j++) 
		{
			if (ctp.getOptions().get(i).getText().equals(c.getOptions().get(j).getText())) 
			{
				System.out.println(ctp.getOptions().get(i).getText()+"  is visible on both the sides.");
				count++;
			}
		}
	}
    if (count!=1) 
    {
    	System.out.println("Nothing is visible on both the sides.");
	}
    
}

/////////////////////////////////////////////////////////////////////////////////////////////////

public static int ImageCompare(String a, String b) 
{ 
    BufferedImage imgA = null; 
    BufferedImage imgB = null; 
    int ret = 0;
    try
    { 
        File fileA = new File(a); 
        File fileB = new File(b); 

        imgA = ImageIO.read(fileA); 
        imgB = ImageIO.read(fileB); 
    } 
    catch (IOException e) 
    { 
        System.out.println(e); 
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
        if (percentage!=0) 
        {
        	ret=1;
		}
    }
	
	return ret ; 
} 

/**
 * Size of the buffer to read/write data
 */
private static final int BUFFER_SIZE = 4096;
/**
 * Extracts a zip file specified by the zipFilePath to a directory specified by
 * destDirectory (will be created if does not exists)
 * @param zipFilePath
 * @param destDirectory
 * @throws IOException
 */
public String[] children=null;
public static void unzip(String zipFilePath, String destDirectory) throws IOException {
    File destDir = new File(destDirectory);
    if (!destDir.exists()) {
        destDir.mkdir();
    }
    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
    ZipEntry entry = zipIn.getNextEntry();
    // iterates over entries in the zip file
    while (entry != null) {
        String filePath = destDirectory + File.separator + entry.getName();
        if (!entry.isDirectory()) {
            // if the entry is a file, extracts it
            extractFile(zipIn, filePath);
        } else {
            // if the entry is a directory, make the directory
            File dir = new File(filePath);
            dir.mkdir();
        }
        zipIn.closeEntry();
        entry = zipIn.getNextEntry();
    }
    zipIn.close();
}
/**
 * Extracts a zip entry (file entry)
 * @param zipIn
 * @param filePath
 * @throws IOException
 */
private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] bytesIn = new byte[BUFFER_SIZE];
    int read = 0;
    while ((read = zipIn.read(bytesIn)) != -1) {
        bos.write(bytesIn, 0, read);
    }
    bos.close();
}












	
}
	


