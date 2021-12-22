package com.Project_Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propert_Loader {
	
	public static Properties prop;
	
	
	public Propert_Loader() {
		
	//Checked Exceptions
		
		File file = new File("./My_Files/login.properties");
		
		try {
			
		
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
			
		
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally {
			
			if(file.exists()) {
				System.out.println("Exception created");
				System.out.println("verified");
			}
			else
			{
				System.out.println("Does not created");
				System.out.println("not verified");
			}
		}

	
		
	}
	
	
	//create methods for each sql property
	public  String getexcelfile() {
		return prop.getProperty("excelFile");
	}
	
	public String getsqlsetup() {
		return prop.getProperty("sqlsetup");
	}
	
	public String getsqlpath() {
		return prop.getProperty("sqlpath");
	}
	
	public String getsqlusername() {
		return prop.getProperty("sqlusername");
	}
	
	public String getsqlpassword() {
		return prop.getProperty("sqlpassword");
	}
	
	public String getsqlquery() {
		return prop.getProperty("sqlquery");
	}
	
	
	
	//create a methods for each property
	
	public String geturl() {
		
		return prop.getProperty("url");
		
	}
	
	public String getusername() {
		return prop.getProperty("name");
	}
	
	public String getpassword() {
		return prop.getProperty("password");
	}
	
	
	//Create methods for elements
	public String getunelement() {
		return prop.getProperty("unelement");
	}
	
	public String getpwelement(){
		return prop.getProperty("pwelement");
	
}
	
	public String getsubmit() {
		return prop.getProperty("submit");
	}
	
	
	
	
	public String getlogout() {
		return prop.getProperty("logout");
	}
	
	}
	
	
	
	
	
	
