package selenium_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_list_test {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();

		// get url
		driver.get("https://www.facebook.com/r.php");
		// timer set 4 seconds
		Thread.sleep(4000);

		// find element on webpage
		WebElement wb = driver.findElement(By.name("firstname"));
		wb.sendKeys("akshay");
		String a = wb.getAttribute("value");
		System.out.println(a);
		Thread.sleep(4000);
		driver.findElement(By.name("lastname")).sendKeys("gaikwad");
		driver.findElement(By.name("reg_email__")).sendKeys("7276697407");
		driver.findElement(By.name("reg_passwd__")).sendKeys("123655478");

		WebElement day = driver.findElement(By.id("day"));
		System.out.println("day drop down value :-  " + day.isDisplayed());
		Select select = new Select(day);
		select.selectByVisibleText("28");
		List<WebElement> list = select.getOptions();
		int t = list.size();
		System.out.println("Number of days count ::-" + t);

		// print using enhance for loop
		for (WebElement akg : list)
			System.out.println(akg.getText());

//		for (int i=0;i<t;i++)
//		System.out.println("days list ====="+list.get(i).getText());

		WebElement month = driver.findElement(By.id("month"));
		Select sel = new Select(month);
		sel.selectByValue("10");
		List<WebElement> ui = sel.getOptions();

		// printing using enhance for loop

		for (WebElement mon : ui) {
			System.out.println(mon.getText());
			String cont = mon.getText();

			// confirming the word is present in the list by using equals method
			if (cont.equals("Mar")) {
				System.out.println("yes its present --march");
			}

			// confirming contains methods by using contains
			if (cont.equalsIgnoreCase("mar"))
				System.out.println("yes january and march both are present in the class");
		}
		// for counting the size of month

		int yu = ui.size();
		System.out.println("count of months in year ::-"+yu);

		WebElement yea = driver.findElement(By.id("year"));
		Select year = new Select(yea);
		year.selectByVisibleText("1996");
		List<WebElement> red = year.getOptions();
//		for (WebElement o:red)
//        System.out.println("year value to the extension "+o.getText());
		int w = red.size();
		System.out.println("size of years :-" + w);

		WebElement kl = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		boolean q = kl.isSelected();
		System.out.println("radio button not selected :-  " + q);
		kl.click();
		boolean e = kl.isSelected();
		System.out.println("radio button is selecteed  :- " + e);

		String title = driver.getTitle();
		System.out.println("title of page :-" + title);

		driver.close();

	}

}
