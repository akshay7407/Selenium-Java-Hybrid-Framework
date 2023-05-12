package Test_Layer;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base_Layer.baseClass;
import Page_Layer.HomePage;
import Page_Layer.LoginPage;



public class homepagetest extends baseClass{
	public static LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setUp() {
		initalization();
		loginpage = new LoginPage();
		loginpage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
	}

	@Test(priority=1)
	public void verifyHomepage() {

		Boolean actualLogo = homepage.verifyLogo();
		Assert.assertSame(actualLogo, true);

	}

	@Test(priority=2)
	public void verifytitle() {

		String actualTile= homepage.verifyTitle();
		String expectedTitle = "OrangeHRM";
       	Assert.assertEquals(actualTile, expectedTitle);
	}
       	@Test
       	
       	public void VerifyUrl () {
       		
       	SoftAssert soft=new SoftAssert();
       	soft.assertAll();
       	String  url=	homepage.verifyURL();
       	String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
       	Assert.assertEquals(url, expectedURL);
       	homepage.ClickonAdmin();
       	
       	}
     
	

	@AfterMethod
	
	public void tearDown() {
		driver.close();
	}
	
}
