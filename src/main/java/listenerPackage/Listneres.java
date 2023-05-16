package listenerPackage;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Util_package.utilClass;
import extentReportPackage.ExtentReporterNg;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

@Listeners

public class Listneres extends utilClass implements ITestListener{
     public static ExtentTest test ;
	ExtentReports extent = ExtentReporterNg.getReporterObject();
	ThreadLocal <ExtentTest> extentTest = new ThreadLocal <ExtentTest>() ; //Thread safe
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Akshay Gaikwad").assignCategory("Testing").assignDevice("windows");
	    extentTest.set(test); // unique thread ID
		
	}

	
	public void onTestSuccess(ITestResult result) {
//		extentTest.get().log(Status.PASS, result.getMethod().getDescription());
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName());
		System.out.println(result.getMethod().getMethodName()+ ":  Passed");
		
	}
	 @Attachment(value = "Screenshot of {0}", type = "image/png")
	    public byte[] saveScreenshot(String name, WebDriver driver) {
	        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
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
		   saveScreenshot(result.getName(), driver);
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
			// To open extent report after test run 
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"//report//extentReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
