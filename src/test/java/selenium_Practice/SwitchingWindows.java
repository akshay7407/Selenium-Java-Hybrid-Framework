package selenium_Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Windows.html");
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//a[@href=\"http://www.selenium.dev\"]")).click();
		
		
		
		Set<String> handle = driver.getWindowHandles();
		
		for (String i : handle) {
			
			String win =driver.switchTo().window(i).getCurrentUrl();
			System.out.println(win);
			
			if (win.contains("demo.automationtesting.in/Windows.html")) {
				driver.close();
			}
		}
		
		

	}

}
