package Page_Layer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base_Layer.baseClass;
import Util_package.Action;

import Util_package.utilClass;

public class AdminPage extends baseClass {
	
	public Actions act ;
	
	

	@FindBy(xpath="//span[text()='Admin']")
	WebElement admin;
	
	@FindBy (xpath="//span[text()='User Management ']")
	WebElement usermanagement;
	
	@FindBy(xpath="//a[text()='Users']")
	WebElement users;
	
	@FindBy(xpath="//div[@class=\"orangehrm-header-container\"]/button")
	WebElement addbutton;
	
	@FindBy(xpath="(//div[contains(@class , 'oxd-select-text')])[1]")
	WebElement dropdown1;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement entername;
	
	@FindBy(xpath="//label[text()='Username']/../following-sibling::div//input")
	WebElement systemusername;
	
	@FindBy(xpath="(//div[contains(@class , 'oxd-select-text')])[4]")WebElement dropdown2;
	
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement password;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
    WebElement connfirmpass;
	
	@FindBy (xpath="//button[text()=' Save ']")
	WebElement save;
	
	
	public AdminPage () {
		PageFactory.initElements(driver, this);
	}
	 public void adminclick() {
		 
		  act=new Actions(driver);
		 
		 act.click(admin).build().perform();
		 act.click(usermanagement).build().perform();;
		 act.moveToElement(users).click().build().perform();
	 
	 }
	public void enterinfo(String name,String username,String pass,String cpass,int drop1,int drop2) {
		
		addbutton.click();
		act.click(dropdown1).build().perform();
	    act.sendKeys(Keys.ARROW_DOWN).build().perform();
		entername.sendKeys(name);
		act.click(dropdown2).build().perform();
	    act.sendKeys(Keys.ARROW_DOWN).build().perform();
		systemusername.sendKeys(username);
		
		connfirmpass.sendKeys(cpass);
		password.sendKeys(pass);
		Action.clickOnElement(save);
	}
	
	
	
	
}
