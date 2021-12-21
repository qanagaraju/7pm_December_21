package com.Project_Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class BrowwserFactory 
{
	
	static WebDriver driver;
	
	public  WebDriver startBrowser(String browsertype,String appurl) {
		
		if(browsertype.equals("chrome")) {

			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximizied");
			
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver = new ChromeDriver(options);
			
		}else if(browsertype.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browsertype.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
		}
		
		
		
		driver.get(appurl);
		
		return driver;
		
		
	}
	
   
}
