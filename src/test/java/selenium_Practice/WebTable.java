package selenium_Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		WebElement wb =driver.findElement(By.xpath("//table[@id='customers']"));
		
		List <WebElement> rows =driver.findElements(By.tagName("tr")); 
		
		System.out.println("list of rows +++++++"+ rows.size());
		
		for (WebElement row :rows) {
			String abc=row.getText();

			if (abc.contains("Maria Anders"))

			{
				System.out.println("test case 1 is passed ");
			}
		}
		
		List <WebElement> tableData =driver.findElements(By.tagName("td")); 
		
		for (WebElement ui:tableData) 
		{
			String all= ui.getText();

			System.out.println("cell value---"+all);

			if(all.equalsIgnoreCase("China"))

			{
				System.out.println("test case 2 is passed");
			}

		}
		
		driver.quit();
		

	}

}
