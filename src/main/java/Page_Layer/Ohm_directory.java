package Page_Layer;

import org.apache.poi.hssf.util.HSSFColor.SEA_GREEN;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;
import Util_package.Action;
import Util_package.Javascriptexe;
import Util_package.utilClass;

public class Ohm_directory extends baseClass {

	Actions act;

	String links = "//ul[@class=\"oxd-main-menu\"]";

	@FindBy(xpath = "//span[text()=\"Directory\"]")
	WebElement Directory;

	@FindBy(css = ".oxd-autocomplete-wrapper")
	WebElement empname;

	@FindBy(xpath = "(//div[text()=\"-- Select --\"])[1]")
	WebElement jobtitle;

	@FindBy(xpath = "(//div[text()=\"-- Select --\"])[2]")
	WebElement location;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchbtn;

	public Ohm_directory() {

		PageFactory.initElements(driver, this);
	}

	public void Directorydata() {
		act = new Actions(driver);
		utilClass.ClickLinkInUl(driver, "Directory", links);
//		Directory.click();
	Javascriptexe.sendKeysToElementByXpath(empname, "Cecil  Bonaparte");
//		empname.click();
//		empname.sendKeys("Cecil  Bonaparte");
		jobtitle.click();
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		location.click();
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		Javascriptexe.ClickonElementUsingJS(searchbtn);

	}

	public void clickon() {
		Action.clickOnElement(searchbtn);
	}
}
