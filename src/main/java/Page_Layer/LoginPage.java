package Page_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;

import Util_package.Javascriptexe;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginPage  extends  baseClass {
	
	// POM with page story

		@FindBy(name = "username")
		WebElement username;

		@FindBy(name = "password")
		WebElement password;

		@FindBy(xpath = "//button[@type='submit']")
		WebElement loginButton;

		public LoginPage() {
			PageFactory.initElements(EventDriver, this);
		}

		// assiociated methods
		@Step("User Enter credentials in OrangeHRM site")
		public  void loginFunctionality(String uname, String pass) {
			username.sendKeys(uname);
			password.sendKeys(pass);
			Javascriptexe.ClickonElementUsingJS(loginButton);
		}

  }
 
 
 
