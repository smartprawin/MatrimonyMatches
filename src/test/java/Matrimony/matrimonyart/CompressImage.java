package Matrimony.matrimonyart;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CompressImage {
	public static void main(String[]args) throws IOException, InterruptedException
	{

	        File input = new File("D:\\Growup\\LOGO\\Test.jpg");
	        BufferedImage image = ImageIO.read(input);

	        File output = new File("D:\\Growup\\LOGO\\TestCompress.jpg");
	        OutputStream out = new FileOutputStream(output);

	        ImageWriter writer =  ImageIO.getImageWritersByFormatName("jpg").next();
	        ImageOutputStream ios = ImageIO.createImageOutputStream(out);
	        writer.setOutput(ios);

	        ImageWriteParam param = writer.getDefaultWriteParam();
	        if (param.canWriteCompressed()){
	            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	            param.setCompressionQuality(0.05f);
	        }

	        writer.write(null, new IIOImage(image, null, null), param);

	        out.close();
	        ios.close();
	        writer.dispose();

		//Search File in DIR
		      File dir = new File("D:\\Growup\\LOGO\\");
		      FilenameFilter filter = new FilenameFilter() {
		         public boolean accept (File dir, String name) { 
		            return name.startsWith("Test");
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
