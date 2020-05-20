package Matrimony.matrimonyart;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConvertWebPtoJPG {
	public static void main(String[]args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\Window7\\First\\matrimonyart\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		EnterURL.sendKeys("https://imgs.iyermatrimony.com/membersphoto/iyer/2018/11/20/23/IYR337695_uzL814_TM_2.webp");
		driver.findElement(By.xpath("//*[@id='externalUrlDialogOkButton']")).click();
		Thread.sleep(2000);
		
		EnterURL.click();
		EnterURL.sendKeys("https://imgs.iyermatrimony.com/membersphoto/iyer/2018/11/20/23/IYR337695_czy08_TB_4.webp");
		driver.findElement(By.xpath("//*[@id='externalUrlDialogOkButton']")).click();
		Thread.sleep(2000);
		
		EnterURL.click();
		EnterURL.sendKeys("https://imgs.iyermatrimony.com/membersphoto/iyer/2018/11/20/23/IYR337695_DBz081_TB_3.webp");
		driver.findElement(By.xpath("//*[@id='externalUrlDialogOkButton']")).click();
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
		System.out.println("outside checkbox");
		List<WebElement> Download = driver.findElements(By.xpath("//*[text()='Download']"));
		for (WebElement webElement : Download) 
		{
			System.out.println("inside download");
			Thread.sleep(2000);
			webElement.click();
		}
		System.out.println("outside download");
		driver.findElement(By.xpath("//*[@class='zip-download zip-download-grey']")).click();
		
		
		//Search File in DIR
		      File dir = new File("C:\\Users\\admin\\Downloads");
		      FilenameFilter filter = new FilenameFilter() {
		         public boolean accept (File dir, String name) { 
		            return name.startsWith("IYR337695");
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
		
	}


}
