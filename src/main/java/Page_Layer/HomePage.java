package Page_Layer;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;

public class HomePage extends baseClass  {

	@FindBy(xpath="//img[@alt='client brand banner']")
	WebElement Logo;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminButton;
	
	@FindBy(xpath="//b[text()='PIM']")
	WebElement PIMButton;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo() {
		Boolean logoStatus=Logo.isDisplayed();
		return logoStatus;
	}
	
	public String verifyTitle() {
		String actualTitle=driver.getTitle();
		
    	return actualTitle;
	}
	public String verifyURL() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public AdminPage ClickonAdmin() {
		
		adminButton.click();
		
		return new AdminPage();
		
	}
}
