package irs.ocr;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;

public class TesserOCR {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File imageFile = new File("C:\\Users\\akumar23\\Desktop\\Tesseract-OCR\\barclays_maintenance.jpg");
		//URL url = new URL("https://pbs.twimg.com/amplify_video_thumb/898526574861070336/img/BBnYe1q9JAVYaOVJ.jpg");
		//new File("C:/Users/akumar23/Desktop/Tesseract-OCR/barclays_maintenance.jpg");
		//Image image =ImageIO.read(url);
		//BufferedImage buffered =(BufferedImage)image; 
		ITesseract instance = new Tesseract();
		 
		try {
		// instance.setDatapath("C:\\Users\\akumar23\\Desktop\\Tesseract-OCR\\barclays_maintenance.jpg");
		String result = instance.doOCR(imageFile);
		System.out.println(result);
		 
		} catch (TesseractException e) {
		System.err.println(e.getMessage());
		}
		}

	
}
