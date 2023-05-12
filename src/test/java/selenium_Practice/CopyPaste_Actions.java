package selenium_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CopyPaste_Actions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php");

		WebElement fName = driver.findElement(By.name("firstname"));

		WebElement LName = driver.findElement(By.name("lastname"));

		fName.sendKeys("Akshay Gaikwad INfobeans");
		Actions a = new Actions(driver);

		a.keyDown(Keys.CONTROL).sendKeys("a").build().perform();

		a.keyDown(Keys.CONTROL).sendKeys("c").build().perform();

		a.keyDown(LName, Keys.CONTROL).sendKeys("v").build().perform();

		driver.close();

	}

}
