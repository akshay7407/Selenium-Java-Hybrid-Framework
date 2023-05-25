package Base_Layer;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;

import Util_package.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener listner;
	public static EventFiringWebDriver EventDriver;

	public baseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\Config\\Config.Properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initalization(String url) {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browsername.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\hybrid_framework\\msedgedriver.exe");
			driver = new EdgeDriver();

		} else if (browsername.equals("opera")) {
			System.setProperty("webdriver.opera.driver",
					System.getProperty("user.dir") + "\\hybrid_framework\\operadriver.exe");
			driver = new OperaDriver();

		}

		listner = new WebEventListener();
		EventDriver = new EventFiringWebDriver(driver);
		// we have registred Custom class in util package..--- Web Event Listener
		EventDriver.register(listner);
		driver = EventDriver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty(url));

	}

	@AfterTest
	public void tearDown() {
		System.gc();
		driver.quit();
	}

}
