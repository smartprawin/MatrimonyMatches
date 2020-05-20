package Matrimony.matrimonyart;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

public class UnzipFiles extends BaseTest {

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
        System.out.println("inside zip");
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
            	 System.out.println("inside if");
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
        	System.out.println("Inside extract");
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
    
    public static void main(String[] args) {
        String zipFilePath = "C:\\Users\\admin\\Downloads\\IYR337695_uzL814_TM_2 (4).zip";
        String destDirectory = "E:\\ImagesToCompare";
        
        try {
            unzip(zipFilePath, destDirectory);
            System.out.println("passed");
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
        
      //Search File in DIR
	      File dir = new File("E:\\ImagesToCompare");
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
	      //System.out.println(ImageCompare("E:\\ImagesToCompare\\"+children[0], "E:\\ImagesToCompare\\"+children[1]));
	     for (int i = 0; i < children.length; i++) 
	     {
	    	 System.out.println(children[i]);
	    	 
			for (int j = i+1; j < children.length; j++) 
			{	
				System.out.println(children[j]);
				if (i!=j) 
				{
					System.out.println("       "+i+"-------->"+j);
					  BufferedImage imgA = null; 
				      BufferedImage imgB = null; 

				      try
				      { 
				          File fileA = new File("E:\\ImagesToCompare\\"+children[i]); 
				          File fileB = new File("E:\\ImagesToCompare\\"+children[j]); 

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
				          
				          if (percentage==0) 
				          {
							System.out.println(" Same image is repeated");
				          }
				          
				          
				      } 	
				}
				
			}
		}
	     
	   //////////////Delete List of files//////////////////////////
	     File directory = new File("E:\\ImagesToCompare");

	  // Get all files in directory

	  File[] files = directory.listFiles();
	  for (File file : files)
	  {
	     // Delete each file

	     if (!file.delete())
	     {
	         // Failed to delete file

	         System.out.println("Failed to delete "+file);
	     }
	  } 
	      
	      
	  } 
	      
	      
    
    
    

}
