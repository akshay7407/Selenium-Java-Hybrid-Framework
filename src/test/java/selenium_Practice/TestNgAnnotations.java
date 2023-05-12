package selenium_Practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TestNgAnnotations {
  String url="https://www.google.com";
	WebDriver driver;
	
	@BeforeClass
	public void start()
	{
		System.out.println("It executed before all tests");
	}
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("It executed before each tests");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test (priority = 1)
	
	public void naviagate() {
	
	System.out.println(driver.getTitle());
	Assert.assertEquals("Google", driver.getTitle());
	System.out.println("test 1 executed");
		
	}
	@Test (priority = 2)
	public void scrrenshot() throws IOException
	
	{
		driver.get("https://www.amazon.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
	File fs=	ts.getScreenshotAs(OutputType.FILE);
	
	//File dist=new File("C:\\Users\\lenovo\\Desktop\\notes\\goole.png");
	
	FileUtils.copyFile(fs, new File("C:\\Users\\Akshay Gaikwad\\Desktop\\screnshot\\"+System.currentTimeMillis()+"goole.png"));
	System.out.println("test 2 executed");
		
	}
	
	@Test (dependsOnMethods={"naviagate"},alwaysRun=true) 
	public void url()
	{
		
		System.out.println(driver.getCurrentUrl());
		System.out.println("test 3 executed");
	}
	
   
    @AfterMethod
    public void statement() {
    	driver.close();
    	System.out.println("It executed after each tests");
    }
    @AfterClass
    
    public void end()
    {
    	System.out.println("It executed after all tests");
    }
}
