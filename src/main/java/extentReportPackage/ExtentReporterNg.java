package extentReportPackage;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNg {

	public static ExtentReports getReporterObject() {
		String path =System.getProperty("user.dir")+"//report//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation by Akshay");
		reporter.config().setDocumentTitle("Test results");
		reporter.config().setTheme(Theme.DARK);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Akshay Gaikwad");
		return extent ;
	}

}
