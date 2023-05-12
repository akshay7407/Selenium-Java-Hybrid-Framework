package Page_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;

import Util_package.utilClass;

public class facebookCreate extends baseClass {
	
	@FindBy(name="firstname")
	WebElement firstname    ;
	
	@FindBy(name="lastname")
	WebElement   surname  ;
	
	@FindBy(name="reg_email__")
	WebElement  mobilenumber   ;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	WebElement  newPass   ;
	
	@FindBy(xpath="//select[@id='day']")
	WebElement  dayy   ;
	
	@FindBy(xpath="//select[@id='month']")
	WebElement  monthh   ;
	
	@FindBy(xpath="//select[@id='year']")
	WebElement  yearr   ;
	
	public facebookCreate() {
		
		PageFactory.initElements(driver, this);
	}

	public  void username(String name)
	{
		firstname.sendKeys(name);
	
	}

	public void pass(String surnamee) {
		surname.sendKeys(surnamee);
	}
	
	public void mobile(String mobile) {
		mobilenumber.sendKeys(mobile);
	}
	
	public void newpass(String Pass) {
		newPass.sendKeys(Pass);
	}
	
	public void dayy(String day) {
		utilClass.selectbyText(dayy, day);
	}
	
	public void monthh(String month) {
		utilClass.selectbyText(monthh, month);
}
		public void yearr(String year) {
		utilClass.selectbyText(yearr, year);
	}
	
	
	
	
	
	
	
}
