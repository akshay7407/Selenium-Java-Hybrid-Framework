package Page_Layer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;

public class PurchaseTestPom extends baseClass {

	String pro = "adidas original";
	
	@FindBy(css = "#userEmail")
	WebElement txtUserName;

	@FindBy(css = "#userPassword")
	WebElement txtPass;

	@FindBy(css = "#login")
	WebElement btnSubmit;

	@FindBy(css = ".mb-3")
	List<WebElement> products;

//	
//	@FindBy (css ="")
//	WebElement ;
	
	
	// Passing dynamic locator 
	public WebElement buttonAddTocart(String dynamicValue) {
        String locator = String.format("//b[text()='%s']/../following-sibling::button[2]", dynamicValue);
        return driver.findElement(By.xpath(locator));
    }

	public PurchaseTestPom() {
		PageFactory.initElements(driver, this);
	}

	public void loginToPurchasePage() {

		txtUserName.sendKeys("widam62568@ascalus.com");
		txtPass.sendKeys("Akshay@6128");
		btnSubmit.click();
	}

	public void filterProduct() {

		buttonAddTocart("adidas original").click();
	}
}
