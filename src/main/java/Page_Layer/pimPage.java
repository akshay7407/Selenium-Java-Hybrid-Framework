package Page_Layer;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;
import Util_package.utilClass;

public class pimPage extends baseClass {
	
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	WebElement PIM;
	
	@FindBy(xpath="//input[@id='empsearch_employee_name_empName']")
	WebElement name ;
	
	@FindBy(xpath="//input[@id='empsearch_id']")
	WebElement id ;
	
	@FindBy(xpath="//select[@id='empsearch_employee_status']")
	WebElement empStatus ;
	
	@FindBy(xpath="//select[@id='empsearch_termination']")
	WebElement include ;
	
	
	@FindBy(xpath="//input[@id='ohrmList_chkSelectRecord_5']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	WebElement delete;
	
	@FindBy(xpath="//input[@id='dialogDeleteBtn']")
	WebElement alert;
	
	public pimPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void testtdata(String Ename,String Eid,String drop1,String drop2) {
		PIM.click();
		name.sendKeys(Ename);
		id.sendKeys(Eid);
		utilClass.selectbyText(empStatus, drop1);
		utilClass.selectbyText(include, drop2);
		
	}
	public void pimClick() {
		PIM.click();
		}
	
	public void  pimElement()
	{
		PIM.click();
		checkbox.click();
		delete.click();
		alert.click();
	}
	
	
	
	
	
	
	
	
	

}
