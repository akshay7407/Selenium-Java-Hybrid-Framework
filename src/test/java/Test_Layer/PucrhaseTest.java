package Test_Layer;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.PurchaseTestPom;


public class PucrhaseTest extends baseClass {
	PurchaseTestPom ele;

	@BeforeClass
	public void initalize() {
		System.out.println(prop.getProperty("purchaseUrl"+"}}}}}}}}}}}}}}}}}}}}}}}}}}}}}"));
        initalization("purchaseUrl");
		ele = new PurchaseTestPom();
	}

	@Test

	public void createPurchaseOrder() {
		ele.loginToPurchasePage();
		ele.filterProduct();
	}

}
