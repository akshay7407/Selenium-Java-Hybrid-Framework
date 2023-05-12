package selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/documentation/");

		driver.manage().window().maximize();

		// Scroll window by pixel

		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		js.executeScript("window.scrollBy(0,1500)", "");

		// Scrolling page till we find element

//		WebElement header = driver.findElement(By.xpath("//h2[text()=\"Selenium Level Sponsors\"]"));
//
//		js.executeScript("arguments[0].scrollIntoView()", header);
		
		//scroll to bottom
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		

	}

}
