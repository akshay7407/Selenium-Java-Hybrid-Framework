package Test_Layer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.AdminPage;
import Page_Layer.HomePage;
import Page_Layer.LoginPage;

public class adminpagetest extends baseClass {
	LoginPage loginpage;
	HomePage homepage;
	AdminPage obj;
	
	@BeforeClass
	
	public void setup() {
		initalization();
		loginpage = new LoginPage();
		loginpage.loginFunctionality("Admin", "admin123");
		homepage = new HomePage();
		
	     obj=new AdminPage();
	}

	@Test
	
	public void userinfo() {
		
		
		obj.adminclick();
		obj.enterinfo("Isaiah  Hill","charllie.123", "charli123", "charli123", 0, 0);
		driver.close();
		
		
	}
	
	
	
	
	
	
	
	
}
