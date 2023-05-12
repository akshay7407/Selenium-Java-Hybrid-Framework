package Util_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base_Layer.baseClass;

public class Javascriptexe extends baseClass {
	public static JavascriptExecutor js;

	public static void ClickonElementUsingJS(WebElement wb) {

		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", wb );
	}

	public static void alertpopJS () {
		js=(JavascriptExecutor)driver;

		js.executeScript("alert('User is sucessfully login to home page');");
	}
	public static void  refreshBrowserJS() {

		js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}


	public static void gettitleJS()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("return document.title;").toString();
	}

	public static void scrolltopageJS(WebElement wb)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",wb);

	}


	public static void openurlJS() {

		js=(JavascriptExecutor)driver;

		js.executeScript("window.open('https://www.facebook.com')");

	}
	public static void HighlightElement(WebElement wb)
	{

		js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].style.border='3px dotted red'",wb);
	}
	
	public static void sendKeysToElementByXpath(WebElement element, String keysToSend) {
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].value = arguments[1];", element, keysToSend);
	}

}
