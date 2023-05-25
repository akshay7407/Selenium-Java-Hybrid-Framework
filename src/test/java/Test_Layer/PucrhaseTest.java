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
		element = new PurchaseTestPom(driver);
		element.loginToPurchasePage(prop.getProperty("user"), prop.getProperty("pass"));
	}

	@Test(description = "Create purchase order", priority = 0)
	@Severity(SeverityLevel.NORMAL)
	public void TC001() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Let's Shop");
		element.getProductByName(element.product);
	}

	@Test(priority = 1, description = "Verify Product Is Added To Cart")

	public void TC002() throws InterruptedException {
		String cartProduct = element.verifyProductAddToCart();
		Assert.assertEquals(cartProduct, "ZARA COAT 3");
	}

	@Test(priority = 2, description = "Confirm Shipping And Place Order")
	public void TC003() {
		String confirmation = element.enterShippingInfo(element.Country);
		Assert.assertTrue(confirmation.equalsIgnoreCase("Thankyou for the order."));

	}

}
