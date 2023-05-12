package Test_Layer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.AdminPage;
import Page_Layer.HomePage;
import Page_Layer.LoginPage;
import Page_Layer.subscribe;


public class subscribetest extends baseClass{
	HomePage objj;
	
	@BeforeClass
	
	public void setup() {
		baseClass.initalization();
		LoginPage  obj1=new LoginPage();
		obj1.loginFunctionality("Admin", "admin123");
		
	}
	
	@Test(priority=1)
	
	public void returnpage() {
		
		subscribe obj=new subscribe();
		 objj=new HomePage();
		obj.myinfoo();
		
	}
	
	  @Test(priority=2)	
	  
	  public void feeldata() {
		  objj.ClickonAdmin();
	      AdminPage data=new AdminPage();
	      data.enterinfo("Alice Duval","alice.duval99", "akautomation", "akautomation", 1, 0);
	
	}
 @AfterClass
 
 public void teardwon() {
	 driver.close();
 }


}
