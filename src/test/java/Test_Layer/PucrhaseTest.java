package Test_Layer;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.PurchaseTestPom;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class PucrhaseTest extends baseClass {
	PurchaseTestPom element;

	@BeforeClass
	public void initalize() {
        initalization("purchaseUrl");
		element = new PurchaseTestPom();
	}

	@Test (description = "Create purchase order")
    @Severity(SeverityLevel.NORMAL)
	public void createPurchaseOrder() {
		element.loginToPurchasePage(prop.getProperty("user"), prop.getProperty("pass"));
		String title =driver.getTitle();
		assertEquals(title, "Let's Shop");
		element.filterProduct();
	}

}
