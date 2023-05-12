package dataDrivenTestng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
	    driver =new ChromeDriver();
		
	
	}
	
	@Test(dataProvider="fbdata")
	
	
	public void login (String name ,String surname,String pass,String mobile, String day,String month, String year )  {
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php");
        driver.findElement(By.name("firstname")).sendKeys(name);
		driver.findElement(By.name("lastname")).sendKeys(surname);
		driver.findElement(By.name("reg_email__")).sendKeys(mobile);
		driver.findElement(By.name("reg_passwd__")).sendKeys(pass);
		WebElement wb=	driver.findElement(By.xpath("//select[@id='day']"));
		WebElement wb1=driver.findElement(By.xpath("//select[@id='month']"));
		WebElement wb2=driver.findElement(By.xpath("//select[@id='year']"));
    Select sel2=new Select(wb2);
    
    sel2.selectByVisibleText(year);
	
	Select sel=new Select (wb);
	sel.selectByVisibleText(day);
	
	Select sel1=new Select (wb1);
	sel1.selectByVisibleText(month);
	
	List<WebElement>size=sel.getOptions();
	System.out.println(size.size());
	
	}
	@AfterMethod
	public void end() {
		
		
		driver.close();
		
	}
	
	
	@DataProvider(name="fbdata")
	
	public Object [][] getdta () throws Exception {
		ExcelReader obj=new ExcelReader(System.getProperty("user.dir")+"\\abc.xlsx");
		
		int ib=obj.getrowCount(2);
		
		System.out.println("+++++++++++++++++"+ib);
		
		Object[][] data=new Object[ib-1][7];
		
		for (int i=0;i<ib-1;i++)
		{
    		data[i][0]=obj.getdata(i, 0, 2);
			data[i][1]=obj.getdata(i, 1, 2);
			data[i][2]=obj.getdata(i, 2, 2);
      		data[i][3]=obj.getdata(i, 3, 2);
      		data[i][4]=obj.getdata(i, 4, 2); 
      		data[i][5]=obj.getdata(i, 5, 2);
      		data[i][6]=obj.getdata(i, 6, 2);
			
		}
		
		return data;
	
	}
	
}
