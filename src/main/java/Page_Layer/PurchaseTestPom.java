package Page_Layer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base_Layer.baseClass;
import Util_package.Action;
import Util_package.Javascriptexe;
import Util_package.utilClass;
import io.qameta.allure.Step;

public class PurchaseTestPom extends baseClass{

  public  static String product = "zara coat 3";
  public static String Country = "india";

	@FindBy(css = "#userEmail")
	WebElement txtUserName;

	@FindBy(css = "#userPassword")
	WebElement txtPass;

	@FindBy(css = "#login")
	WebElement btnSubmit;

	@FindBy(css = ".mb-3")
	List<WebElement> products;

//	
	@FindBy (css ="#toast-container")
	WebElement popUpProductAdd;
	
	@FindBy(css="[routerlink*=\"cart\"]")
	WebElement   btnCart ;
	
	@FindBy(css=".cartSection h3")
	WebElement  cartProducts ;
//	
	@FindBy(css=".totalRow button")
	WebElement  btnCheckout   ;
//	
	@FindBy(css="[placeholder='Select Country']")
	WebElement  ddSelectCountry  ;
	
	@FindBy(css ="a.action__submit")
	WebElement btnPlaceOrder ;
	
	@FindBy(css ="button.ta-item:nth-of-type(2)")
	WebElement country ;
	
	@FindBy(css =".hero-primary")
	WebElement confirmMsg ;

	// Passing dynamic locator
	public WebElement buttonAddTocart(String dynamicValue) {
		String locator = String.format("//b[text()='%s']/../following-sibling::button[2]", dynamicValue);
		return driver.findElement(By.xpath(locator));
	}

	public PurchaseTestPom() {
		PageFactory.initElements(driver, this);
	}

	@Step("Login to shoppping website")
	public void loginToPurchasePage(String username , String pass) {

		txtUserName.sendKeys(username);
		txtPass.sendKeys(pass);
		btnSubmit.click();
	}

	@Step("Add product to kart")
	public void getProductByName(String productName) {

		buttonAddTocart(productName).click();
		utilClass.explicitwait(By.cssSelector("#toast-container"));
		utilClass.animationInvisibility(By.cssSelector(".ng-animating"));
	}
	
	@Step("Click on cart and verify products")
	
	public String verifyProductAddToCart() {
		btnCart.click();
		String status =cartProducts.getText();
		btnCheckout.click();
		return status ;	
	}
	
	@Step("Enter shipping info and payment information and Place the order")
	public String enterShippingInfo(String countryName)  {
		
		Action.pressKey(ddSelectCountry,countryName);
	     country.click();
	     Javascriptexe.ClickonElementUsingJS(btnPlaceOrder);
	     String confirmation = confirmMsg.getText();
	     return confirmation ;
	}
}
