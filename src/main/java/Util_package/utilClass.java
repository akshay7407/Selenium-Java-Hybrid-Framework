package Util_package;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_Layer.baseClass;

public class utilClass extends baseClass{
	
public static Select sel;
	
	public static void selectbyindex(WebElement wb,int index) {
		
		sel=new Select (wb);
		sel.selectByIndex(index);
	}
	
	public static void selectbyText(WebElement wb,String text) {
		
		sel=new Select(wb);
		sel.selectByVisibleText(text);
	}
	
public static int CountDropDownIteams(WebElement wb, String text) {
		
	    sel=new Select(wb);
		sel.selectByVisibleText(text);
		List<WebElement> ls =sel.getOptions();
		int dpCount=ls.size();
		return dpCount;
	}
	
	// Take Screen Shot
	public   String TakeScreenShot(String testcasename) throws IOException {
		File f =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dist=System.getProperty("user.dir");
		
		FileUtils.copyFile(f, new File(dist +"reports//Screenshot//"+testcasename +".png"));
		
		return dist+"reports//Screenshot//"+testcasename +".png";
			
		
	}
	
	// explict wait
	
	public static void explicitwait(By wb) {
		
		WebDriverWait wait=new WebDriverWait(driver, 40);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(wb));
		
	}
	
	//animation invisibility class
	public static void animationInvisibility(By wb) {
		
		WebDriverWait wait=new WebDriverWait(driver, 40);	
		wait.until(ExpectedConditions.invisibilityOfElementLocated(wb));
		
	}
	
	//ParentFrame
	public static void MainFrame(WebElement wb) {
		driver.switchTo().frame(wb);
	}
	
	//child Frame
	
	public static void ChildFrame(WebElement wb) {
		driver.switchTo().frame(wb);
	}
	
	// Switch to top frame
	public static void switchTotopFrame() {
		driver.switchTo().defaultContent();
	}
	
	//to return all links under UI selector
	public static void ClickLinkInUl(WebDriver driver, String linkText, String locator) {
        WebElement ulElement = driver.findElement(By.xpath(locator));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        for (WebElement li : liElements) {
            WebElement a = li.findElement(By.tagName("a"));
            String text = a.getText();
            if (text.equals(linkText)) {
                a.click();
                break;
            }
        }
    }
	

}
