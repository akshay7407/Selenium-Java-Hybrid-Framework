package Test_Layer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;
import Page_Layer.Ohm_directory;
import io.qameta.allure.Step;

public class Ohm_directoryTest extends baseClass {
	Ohm_directory obj ;
	
	@BeforeMethod
	@Step("Basic Initalization of browser and login process")
	public void basicIntialization() {
		baseClass.initalization("url");
		LoginPage obj1 = new LoginPage();
		obj1.loginFunctionality("Admin", "admin123");
	}
	@Test (description = "Enter directory tab and search the user")
	
	public void directory() {
	  obj=new Ohm_directory();
		obj.Directorydata();
	}
	
	
	
	@AfterClass
	@Step("Close the browser")
	
	public void teardown() {
		driver.quit();
	}

}
