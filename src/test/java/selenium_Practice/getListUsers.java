package selenium_Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getListUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.findElement(By.xpath("//span[text()='User Management ']")).click();
		driver.findElement(By.xpath("//a[text()='Users']")).click();
		List<WebElement> users = driver.findElements(By.xpath("//div[@class='oxd-table-card']/div/div[2]/div"));
		System.out.println("Count of users :::: " + users.size());
		for (WebElement user : users) {

			String adminUsers = user.getText();
			System.out.println(adminUsers);
		}
		driver.quit();
	}

}
