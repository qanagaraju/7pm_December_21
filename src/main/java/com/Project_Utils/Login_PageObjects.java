package com.Project_Utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PageObjects {
	
	static WebDriver driver;
	@FindBy(name="user")WebElement username;
	@FindBy(name = "pass")WebElement password;
	@FindBy(name="btnSubmit")WebElement loginbutton;
	@FindBy(xpath="//*[@id=\"user_bar\"]/ul/li[1]/a")WebElement signout;
	@FindBy(id = "right_col_top_err")WebElement user_message;
	
	
	
	static CaptureScreens capture = new CaptureScreens();
	
	
	public Login_PageObjects getusername(String un) throws IOException {
		
	
		
	username.sendKeys(un);
	capture.capturescreens(driver, username, "username");
		
		return this;
	}
	
	
	public Login_PageObjects getpassword(String pw) throws IOException {
		
		password.sendKeys(pw);
		capture.capturescreens(driver, password, "password");
		return this;
	}

	
	public Login_PageObjects getloginbutton() {
	
		if(loginbutton.isEnabled()) {
			loginbutton.click();
			
			try {
				
				System.out.println(user_message.getText()+"\t"+"Invalid Login");
			
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		return this;
	}

	
	public Login_PageObjects getsignout() {
		
		if(signout.isDisplayed() && signout.isEnabled()) {
			signout.click();
			System.out.println("Login Success"+"\t"+"verified valid login");
			
						
		}
		
		return this;
		
	}
	
	
	

}
