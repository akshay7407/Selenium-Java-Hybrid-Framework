package Page_Layer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;

import Util_package.Javascriptexe;
import io.qameta.allure.Step;

public class LoginPage {
	
	WebDriver driver ;
	
	// POM with page story

		@FindBy(name = "username")
		WebElement username;

		@FindBy(name = "password")
		WebElement password;

		@FindBy(xpath = "//button[@type='submit']")
		WebElement loginButton;

		public LoginPage(WebDriver driver) {
			this.driver =driver ;
			PageFactory.initElements(driver, this);
		}

		// assiociated methods
		@Step("User Enter credentials in OrangeHRM site")
		public  void loginFunctionality(String uname, String pass) {
			username.sendKeys(uname);
			password.sendKeys(pass);
			Javascriptexe.ClickonElementUsingJS(loginButton);
		}

  }
 
 
 
