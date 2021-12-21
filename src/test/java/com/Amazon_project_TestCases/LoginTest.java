package com.Amazon_project_TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Project_Utils.BrowwserFactory;
import com.Project_Utils.Login_PageObjects;


public class LoginTest  {
	
	public WebDriver driver;
	//How to work with page objects elements
	public Login_PageObjects loginpage;	
	public BrowwserFactory browser = new BrowwserFactory();
	
	
	@BeforeTest
	public void getbrowser() {
		
		driver = browser.startBrowser("chrome", "https://www.mycontactform.com/");
		
	}
	
	  
	  @Parameters({"username","password"})
	  @Test(priority=0)
	  public void verify_valid_login(String username,String password) throws IOException {
		  
		  loginpage = PageFactory.initElements(driver, Login_PageObjects.class);
		  loginpage.getusername(username).getpassword(password).getloginbutton().getsignout();
		  Reporter.log("Login Success"+"\t"+"verified valid login");
	  }
	  
	  @Parameters({"uname","password"})
	  @Test(priority=1)
	  public void verify_invalid_login(String uname,String password) throws IOException {
		  loginpage = PageFactory.initElements(driver, Login_PageObjects.class);
		  loginpage.getusername(uname).getpassword(password).getloginbutton();
		  Reporter.log("Login fail");
	  }
	  
	 
	  
	  
	  @AfterTest
	  public void closetest() {
		 
		  driver.close();
		  
		  
	  }
	 
	

}
