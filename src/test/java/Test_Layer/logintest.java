package Test_Layer;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;
import listenerPackage.Listneres;


public class logintest extends  baseClass {
  
	@Test (description = "This is the login test ")
	public void loginFunctionality() {
	
		initalization();
		
		LoginPage obj=new LoginPage();
		
		Listneres.test.log(Status.INFO, "Login to the page using username and credetials");
		
		obj.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		
		Listneres.test.log(Status.INFO, "Close the chrome browser");
		
		driver.quit();
		
	}



}
