package com.Project_Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptureScreens {
	
	static WebDriver driver;
	
	public String capturescreens(WebDriver driver,WebElement element,String screename) throws IOException {
		
		//File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file = element.getScreenshotAs(OutputType.FILE);
		
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		File dest = new File("./TsetScreens/"+screename+datename+".png");
		
		String destpath = dest.getAbsolutePath();
		
		
		FileUtils.copyFile(file, dest);
		
		return destpath;
		
		
		
	}
	

}
