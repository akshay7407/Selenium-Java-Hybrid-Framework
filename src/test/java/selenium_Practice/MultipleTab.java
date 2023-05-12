package selenium_Practice;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleTab {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("window.open('https://www.flipkart.com/')");
		js.executeScript("window.open('https://www.amazon.in/')");
		
		Set<String> win=driver.getWindowHandles();
		
     	ArrayList<String> arr=new ArrayList<String>(win);
     	
     	for (String abc : arr) {
     		
     		driver.switchTo().window(abc);
     		System.out.println(driver.getCurrentUrl());
     	}
		
		driver.switchTo().window(arr.get(2));
		
		String t=driver.getTitle();
		
		System.out.println("Print flipkart title :::::::::::"+t);
		
		driver.switchTo().window(arr.get(1));
		String p=driver.getTitle();
		
		System.out.println("Print amazon title :::::::::::"+p);
         
		driver.quit();
		
		
	}

}