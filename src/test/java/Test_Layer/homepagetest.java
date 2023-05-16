package Test_Layer;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Base_Layer.baseClass;
import Page_Layer.AdminPage;
import Page_Layer.HomePage;
import Page_Layer.LoginPage;
import io.qameta.allure.Step;
import listenerPackage.Listneres;

public class homepagetest extends baseClass {
	public static LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setUp() {
		initalization();
		loginpage = new LoginPage();
		loginpage.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
	}

	@Test(priority = 1)
	@Step("Verify the logo of homePage")
	public void verifyHomepage() {

		Boolean actualLogo = homepage.verifyLogo();
		Assert.assertSame(actualLogo, true);

	}

	@Test(priority = 2 ,description = "Verify the orangeHrm title after login")
	@Step("Verify the title of OrangeHrm")
	public void verifytitle() {
		Listneres.test.log(Status.INFO, "Get the String of title");
		String actualTile = homepage.verifyTitle();
		Listneres.test.log(Status.INFO, "Add the expected title");
		String expectedTitle = "OrangeHRM";
		Listneres.test.log(Status.INFO, "Verify that title is equal to expected title");
		Assert.assertEquals(actualTile, expectedTitle);
	}

	@Test
	@Step("Verify the URL of OrangeHrm")
	public void VerifyUrl() {

		SoftAssert soft = new SoftAssert();
		soft.assertAll();
		String url = homepage.verifyURL();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(url, expectedURL);
		homepage.ClickonAdmin();

	}

	@AfterMethod
	@Step("Close the browser")
	public void tearDown() {
		driver.close();
	}

}
