package Matrimony.matrimonyart;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage 
{

	public static void main(String args[])throws IOException 
    { 
        int width = 963;    //width of the image 
        int height = 640;   //height of the image 
  
        // For storing image in RAM 
        BufferedImage image1 = null, image2 = null; 
  
        // READ IMAGE 1
        try
        { 
            File input_file = new File("D:\\vino\\IMG_20190406_223417.jpg"); //image file path 
  
            /* create an object of BufferedImage type and pass 
               as parameter the width,  height and image int 
               type.TYPE_INT_ARGB means that we are representing 
               the Alpha, Red, Green and Blue component of the 
               image pixel using 8 bit integer value. */
            image1 = new BufferedImage(width, height, 
                                    BufferedImage.TYPE_INT_ARGB); 
  
             // Reading input file 
            image1 = ImageIO.read(input_file); 
  
            System.out.println("Reading first image complete."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Error: "+e); 
        } 
        
        // READ IMAGE 2
        try
        { 
            File input_file = new File("D:\\vino\\IMG_20190406_223417.jpg"); //image file path 
  
            /* create an object of BufferedImage type and pass 
               as parameter the width,  height and image int 
               type.TYPE_INT_ARGB means that we are representing 
               the Alpha, Red, Green and Blue component of the 
               image pixel using 8 bit integer value. */
            image2 = new BufferedImage(width, height, 
                                    BufferedImage.TYPE_INT_ARGB); 
  
             // Reading input file 
            image2 = ImageIO.read(input_file); 
  
            System.out.println("Reading first image complete."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Error: "+e); 
        } 
        
        System.out.println(image1);
        System.out.println(image2);
        
        
        
  
        // WRITE IMAGE 
        try
        { 
            // Output file path 
            File output_file = new File("D:\\vino\\IMG_20190406_223417.jpg"); 
  
            // Writing to file taking type and path as 
            ImageIO.write(image1, "jpg", output_file); 
  
            System.out.println("Writing complete."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Error: "+e); 
        } 
    }//main() ends here 
}//class ends here 
	
	
	

