package selenium_Practice;



import java.util.HashMap;

import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;


public class HashMapTest extends baseClass  {
	
	static LoginPage obj ;
	
	static  HashMap <String, String> logindata(){
	HashMap <String, String > hm=new HashMap <String, String>();
	hm.put("x", "Admin@admin123");
	hm.put( "y" ,"mercuryl@mercuryl" ) ;
	hm.put( "z","mercury2@nercury2");
	return hm;
	}

	@Test
	
	public void hashMapT() {
		String cred = logindata().get("x");
		String arr []=cred.split("@");
		initalization("url");
		obj = new LoginPage(driver);
		obj.loginFunctionality(arr[0],arr[1]);
		System.out.println(arr[0]+"}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
		System.out.println(arr[1]+"}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
		driver.quit();
		

	}
}
