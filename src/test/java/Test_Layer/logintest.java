package Test_Layer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import listenerPackage.Listneres;


public class logintest extends  baseClass {
	  
	@Test (description = "This is the login test ")
	@Severity(SeverityLevel.CRITICAL)
	public void loginFunctionality() {
		
		initalization("url");
		
		System.out.println("Browser setup by Thread Login "+Thread.currentThread().getId());
		 
		LoginPage obj=new LoginPage(driver);
		
		Listneres.test.log(Status.INFO, "Login to the page using username and credetials");
		
		
		obj.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		
		Listneres.test.log(Status.INFO, "Close the chrome browser");
		
	}
	
	@AfterMethod
	@Step("Close the browser")
	public void tearDown() {
		driver.close();
	}
	

}
