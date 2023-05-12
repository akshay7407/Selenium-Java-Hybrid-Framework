package selenium_Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Set system property for Chrome driver
    	WebDriverManager.chromedriver().setup();

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();

      //Open URL OF app
        driver.get("https://mvnrepository.com/");
        
        //wait 
        Thread.sleep(5000);

        // Get all the links on the webpage 
        List<WebElement> links = driver.findElements(By.tagName("a"));
         
        // print the count of links 
        System.out.println(links.size()+"++++++ Count of links");
        
        for (int b=0 ;b<= links.size();b++) {
        	WebElement ele = links.get(b);
        	String url = ele.getAttribute("href");
        	
        	URL link = new URL(url) ;
        			
        	//create connection using URL object "link"
        	HttpURLConnection httpCon =  (HttpURLConnection) link.openConnection() ;
        	
        	//wait 
        	Thread.sleep(2000);
        	
        	//establish connection 
        	httpCon.connect();
        	
        	int code =httpCon.getResponseCode();
        	
        	if (code >= 400) {
        		System.out.println(url +"-----"+ "is broken link");
        	}
        	else {
        		System.out.println(url +"-----"+ "is valid link");
        	}
        	
        }
        
		driver.quit();
    }
}
