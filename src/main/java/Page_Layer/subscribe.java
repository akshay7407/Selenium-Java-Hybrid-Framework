package Page_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;

public class subscribe extends baseClass {

	
	@FindBy(xpath="//b[contains(text(),'My Info')]")
	WebElement    myinfo;
	

	public subscribe() {
		PageFactory.initElements(driver, this);
	}
	
	public Ohm_directory myinfoo() {
		myinfo.click();
		return new Ohm_directory();
	}
	
	
	
	
	
	
	
	
	
	
}
