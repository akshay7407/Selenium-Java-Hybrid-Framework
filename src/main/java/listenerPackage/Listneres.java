package listenerPackage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Util_package.utilClass;
import extentReportPackage.ExtentReporterNg;

@Listeners

public class Listneres extends utilClass implements ITestListener{
     ExtentTest test ;
	ExtentReports extent = ExtentReporterNg.getReporterObject();
	ThreadLocal <ExtentTest> extentTest = new ThreadLocal <ExtentTest>() ; //Thread safe
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Akshay Gaikwad").assignCategory("Testing").assignDevice("windows");
	    extentTest.set(test); // unique thread ID
		
	}

	
	public void onTestSuccess(ITestResult result) {
//		extentTest.get().log(Status.PASS, "test case is passed ");
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName());
		System.out.println(result.getMethod().getMethodName()+ ":  Passed");
		
	}


	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
        String filepath = null ;
		try {
		 filepath =TakeScreenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath ,result.getMethod().getMethodName());
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"//report//extentReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
