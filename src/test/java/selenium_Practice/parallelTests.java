package selenium_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parallelTests {
	
	@Test
	
	public void CromeOPs() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		
	}
	
	@Test
	public void Edgeops() {
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver() ;
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		driver.close();
		
	}
	@Test
	public void firefox() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver() ;
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
