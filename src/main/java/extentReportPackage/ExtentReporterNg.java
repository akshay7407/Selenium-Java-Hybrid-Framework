package extentReportPackage;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNg {

	public static ExtentReports getReporterObject() {
    // Ensure the report directory exists
    String reportDir = System.getProperty("user.dir") + java.io.File.separator + "reports";
    java.io.File dir = new java.io.File(reportDir);
    if (!dir.exists()) {
        dir.mkdirs();
        System.out.println("Created reports directory: " + reportDir);
    }
    String path = reportDir + java.io.File.separator + "extentReport.html";
    System.out.println("ExtentReports will be generated at: " + path);
    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    reporter.config().setReportName("Web Automation by Akshay");
    reporter.config().setDocumentTitle("Test results");
    reporter.config().setTheme(Theme.DARK);
    ExtentReports extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Automation Tester", "Akshay Gaikwad");
    System.out.println("ExtentReports instance created successfully");
    return extent;
}

}
