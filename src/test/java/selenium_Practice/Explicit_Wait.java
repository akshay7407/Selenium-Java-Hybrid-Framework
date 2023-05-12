package selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_Wait {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		WebDriverWait wait= new WebDriverWait(driver,1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
		
		driver.findElement(By.linkText("Gmail")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();

	}

}
