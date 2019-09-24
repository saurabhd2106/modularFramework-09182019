package in.amazon.tests;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import comonLibs.implementation.CommonDriver;
import in.amazon.pages.AmazonHomePage;

public class BaseTest {

	CommonDriver cmnDriver;

	String url = "https://www.amazon.in/";

	AmazonHomePage amazonHomepage;

	WebDriver driver;

	static String currentWorkingDirectory;
	static String projectName;
	static String executionStartTime;
	static String reportFileName;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest extentTest;

	static {

		Date date = new Date();
		executionStartTime = String.valueOf(date.getTime());

		currentWorkingDirectory = System.getProperty("user.dir");

		projectName = "AmazonProject";

		reportFileName = String.format("%s/reports/%s_%s.html", currentWorkingDirectory, projectName,
				executionStartTime);
	}

	@BeforeSuite(alwaysRun=true)
	public void preSetup() {

		htmlReporter = new ExtentHtmlReporter(reportFileName);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

	}

	@BeforeClass(alwaysRun=true)
	public void setup() throws Exception {

		extentTest = extent.createTest("Setup - Invoking Browser and navigating to base URL");

		String browserType = "chrome";

		extentTest.log(Status.INFO, "The browser type is - " + browserType);
		cmnDriver = new CommonDriver(browserType);

		int elementDetectionTimeout = 10;
		extentTest.log(Status.INFO, "Implicit wait was set to - " + elementDetectionTimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		int pageLoadTimeout = 20;
		extentTest.log(Status.INFO, "Page load timeout was set to - " + pageLoadTimeout);
		cmnDriver.setPageloadTimeout(pageLoadTimeout);

		extentTest.log(Status.INFO, "Base URL - " + url);
		cmnDriver.navigateToFirstUrl(url);

		driver = cmnDriver.getDriver();

		amazonHomepage = new AmazonHomePage(driver);
	}

	@AfterClass(alwaysRun=true)
	public void cleanUp() throws Exception {

		extentTest = extent.createTest("Clean Up");

		extentTest.log(Status.INFO, "Close all the browsers");
		cmnDriver.closeAllBrowsers();

	}

	@AfterSuite(alwaysRun=true)
	public void postCleanUp() {

		extent.flush();

	}

}
