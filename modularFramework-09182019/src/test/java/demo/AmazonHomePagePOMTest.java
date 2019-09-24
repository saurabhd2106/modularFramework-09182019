package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comonLibs.implementation.CommonDriver;
import designPatterns.AmazonHomePagePOM;

public class AmazonHomePagePOMTest {

	CommonDriver cmnDriver;

	String url = "https://www.amazon.in/";

	AmazonHomePagePOM amazonHomepage;

	WebDriver driver;

	@BeforeClass
	public void invokeBrowser() throws Exception {

		cmnDriver = new CommonDriver("chrome");

		cmnDriver.setElementDetectionTimeout(10);
		cmnDriver.setPageloadTimeout(20);

		cmnDriver.navigateToFirstUrl(url);

		driver = cmnDriver.getDriver();

		amazonHomepage = new AmazonHomePagePOM(driver);
	}

	@Test(priority = 0)
	public void verifySearchProduct() throws Exception {
		amazonHomepage.searchProduct("Apple Watch", "Electronics");
	}

	@AfterClass
	public void closeBrowser() throws Exception{

		cmnDriver.closeAllBrowsers();

	}

}
