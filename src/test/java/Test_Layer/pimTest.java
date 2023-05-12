package Test_Layer;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.HomePage;
import Page_Layer.LoginPage;
import Page_Layer.pimPage;

public class pimTest extends baseClass {
	LoginPage loginpage;
	HomePage homepage;
	pimPage pimpage;
	
	@BeforeMethod
	
	public void setup() {
		initalization();
		loginpage = new LoginPage();
		loginpage.loginFunctionality("Admin", "admin123");
		homepage = new HomePage();
		pimpage=new pimPage();
	}

	@Test
	
	public void operationDelete() {
		
		pimpage.pimElement();
		
	
	}
	
	@AfterMethod
	
	public void teardown () throws InterruptedException {
		
		Thread.sleep(4000);
		driver.close();
		
	}
	

	
}
