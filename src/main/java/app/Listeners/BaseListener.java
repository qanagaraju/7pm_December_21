package app.Listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class BaseListener extends TestListenerAdapter {
	
	@Override
	public void onTestStart(ITestResult itr) {
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		log("Test Started......");
		log("Test starting"+itr.getName()+datename);
		
		System.out.println(datename);
	}
	
	@Override
	public void onTestSuccess(ITestResult itr) {
		log("Test" +itr.getName() + "Passed");
		log(itr.getTestClass());
		log("Prority of the method is " + itr.getMethod().getPriority());
	}
	
	@Override
	public void onTestFailure(ITestResult itr) {
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		log("Test" +itr.getName() +" Failed");
		log("Priority of the method is " +datename+ itr.getMethod().getPriority());
		
		System.out.println(datename);
		//BrowserDriver.takeScreenShot();
	}
	
	
	
	@Override
	public void onTestSkipped(ITestResult itr) {
		log("Test" +itr.getName() + "Skipped");
	}
	
	private void log(String methodName) {
		System.out.println(methodName);
	}
	
	private void log(IClass testClass) {
		System.out.println(testClass);
	}

}
