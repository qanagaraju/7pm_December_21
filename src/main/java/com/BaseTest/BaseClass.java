package com.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Project_Utils.BrowwserFactory;
import com.Project_Utils.Login_PageObjects;
import com.Project_Utils.Propert_Loader;

public class BaseClass {
	
	public WebDriver driver;
	//How to work with page objects elements
	public Login_PageObjects loginpage;	
	public BrowwserFactory browser;
	public Propert_Loader prop;
	
	
	@BeforeSuite
	public void setup_Project_Suite() {
		browser = new BrowwserFactory();
		prop = new Propert_Loader();
	}
	
	@BeforeTest
	public void getbrowser() {
		
		
		
		driver = browser.startBrowser("chrome", prop.geturl());
		
	}
	
	
	
	
	 @AfterTest
	  public void closetest() {
		 
		  driver.close();
		  
		  
	  }

}
