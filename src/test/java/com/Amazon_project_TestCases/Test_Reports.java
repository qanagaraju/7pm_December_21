package com.Amazon_project_TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Project_Utils.CaptureScreens;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.TestNG_Listeners.BaseListener.class)
public class Test_Reports {

	static WebDriver driver;
	static CaptureScreens screen;
	static WebElement gmail,images_link;
	static ExtentReports report;
	static ExtentTest test;
	
	//Download extent report jar dependancy and bind
	//How to work with selenium test reports
	//console,assertions,html,log4j,extent reports, capture screen
	
	@BeforeSuite
	public void setupsuite() {
		screen = new CaptureScreens();
		report = new ExtentReports("./ExtentReport/MyTestReport.html");
		test = report.startTest("Verifying Gmail Links");
	}
	
	
	
	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		test.log(LogStatus.INFO, "Starting browser");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Mamimizing Screen");
	}
	
	
	@Test(priority=0,description="TestCase1")
	public void verify_gmail_link() throws IOException {
		
		gmail = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"));
		
		String exp = gmail.getText();
		test.log(LogStatus.INFO, exp);
		//System.out.println(exp);
		String act = "gmail";
		Assert.assertEquals(exp, act);
		
		
		
	}
	
	
	
	@Test(priority=1)
	public void verify_imageslink() {
		
		images_link = driver.findElement(By.xpath("//a[contains(text(),'Images')]"));
		String explink = images_link.getText();
		String actlink = "images";
		Assert.assertEquals(explink, actlink);
		
	}
	
	
	
	@AfterMethod
	public void failed_report(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			try {
				
				
				test.log(LogStatus.FAIL, "Image link fail",test.addScreenCapture(screen.capturescreens(driver,  images_link, "image link Step failed")));
				Thread.sleep(3000);
				test.log(LogStatus.FAIL, "Gmail Link fail",test.addScreenCapture(screen.capturescreens(driver,  gmail, "image link Step failed")));
				
				screen.capturescreens(driver,  images_link, "image link Step failed");
				Thread.sleep(3000);
				screen.capturescreens(driver,  gmail, "gmail link Step failed");
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
	}
	
	
	
	
	@AfterTest
	public void closebrowser() {
		
		report.flush();
		driver.close();
	}
	
}
