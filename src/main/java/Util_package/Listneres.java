package Util_package;

import java.io.IOException;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReportPackage.ExtentReporterNg;

@Listeners

public class Listneres extends utilClass implements ITestListener{
     ExtentTest test ;
	ExtentReports extent = ExtentReporterNg.getReporterObject();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test case is passed ");
		
	}


	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
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
		
	}
	

}
