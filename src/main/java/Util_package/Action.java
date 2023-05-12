package Util_package;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base_Layer.baseClass;

public class Action extends baseClass{
public static Actions act;
	
	public static void MouseOverOnElement(WebElement wb) {
	
	 act=new Actions(driver);	
		act.moveToElement(wb).build().perform();
	
	}
	
	public static void DoubleClickOnElement(WebElement wb) {
		act=new Actions(driver);
		act.doubleClick(wb).build().perform();
	}
	
	public static void RightClickOnElement(WebElement wb) {
		act=new Actions(driver);
		act.contextClick(wb).build().perform();
	}
	
   public static void clickOnElement(WebElement wb)
   {
	   act=new  Actions (driver);
	   act.click(wb).build().perform();
   }

   
}
