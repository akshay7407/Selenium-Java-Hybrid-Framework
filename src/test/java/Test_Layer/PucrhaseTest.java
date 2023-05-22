package Test_Layer;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.PurchaseTestPom;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;


public class PucrhaseTest extends baseClass {
	PurchaseTestPom element;

	@BeforeClass
	@Step("Initialize the browser")
	public void initalize() {
        initalization("purchaseUrl");
		element = new PurchaseTestPom();
	}

	@Test (description = "Create purchase order" ,priority = 0)
    @Severity(SeverityLevel.NORMAL)
	public void createPurchaseOrder() {
		element.loginToPurchasePage(prop.getProperty("user"), prop.getProperty("pass"));
		String title =driver.getTitle();
		Assert.assertEquals(title, "Let's Shop");
		element.filterProduct();
	}
	
	@Test (priority = 1)
	
	public void verifyProductIsAddedToCart() throws InterruptedException {
		String cartProduct =element.verifyProduct();
		Assert.assertEquals(cartProduct , element.pro);
	}
	
	@Test (priority = 2)
	
	public void confirmShipping()  {
     element.enterShippingInfo();
		
	}
}
