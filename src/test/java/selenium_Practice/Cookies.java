package selenium_Practice;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.amazon.com/");

		// get the cookies
		Set<Cookie> cookies = driver.manage().getCookies();

		// get the cookies size
		System.out.println("Size of cookies " + cookies.size());


		// Print specific cookie name
		System.out.println(driver.manage().getCookieNamed("session-id-time"));
		
		// add new cookie to session
		
		Cookie cook = new Cookie("myCookie", "281009996");
		
		driver.manage().addCookie(cook);
		
//		 print and read all the cookies
		for (Cookie cookie :cookies) {
			System.out.println(cookie.getName()+" "+ cookie.getValue());
		}
		

	}

}
