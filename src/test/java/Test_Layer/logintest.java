package Test_Layer;

import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;


public class logintest extends  baseClass {
  
	@Test
	public void loginFunctionality() {
	
		initalization();
		
		LoginPage obj=new LoginPage();
		
		obj.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		
		driver.quit();
		
	}



}
