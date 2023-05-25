package Test_Layer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.AdminPage;
import Page_Layer.HomePage;
import Page_Layer.LoginPage;
import io.qameta.allure.Step;

public class adminpagetest extends baseClass {
	LoginPage loginpage;
	HomePage homepage;
	AdminPage obj;
	
	@BeforeClass
	
	public void setup() {
		initalization("url");
		loginpage = new LoginPage(driver);
		loginpage.loginFunctionality("Admin", "admin123");
		homepage = new HomePage(driver);
		
	     obj=new AdminPage(driver);
	}

	@Test
	@Step("Click on Admin and create user")
	public void userinfo() {
		
		
		obj.adminclick();
		obj.enterinfo("Isaiah  Hill","charllie.123", "charli123", "charli123", 0, 0);
		
		
	}
	
	@AfterClass
	@Step("Close the broser")
	public void closeSession() {
		driver.close();
	}
	
	
	
	
	
	
	
	
}
