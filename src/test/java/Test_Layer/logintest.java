package Test_Layer;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listenerPackage.Listneres;


public class logintest extends  baseClass {
  
	@Test (description = "This is the login test ")
	@Severity(SeverityLevel.CRITICAL)
	public void loginFunctionality() {
	
		initalization("url");
		
		LoginPage obj=new LoginPage();
		
		Listneres.test.log(Status.INFO, "Login to the page using username and credetials");
		
		
		obj.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		
		Listneres.test.log(Status.INFO, "Close the chrome browser");
		
		driver.quit();
		
	}



}
