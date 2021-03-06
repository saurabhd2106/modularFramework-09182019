package in.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class AmazonHomePageTests extends BaseTest {

	@Test(priority = 0)
	public void verifySearchProduct() throws Exception {
		extentTest = extent.createTest("TC - 001 - Verify Search product functionality");

		String product = "Apple Watch";
		String category = "Electronics";

		extentTest.log(Status.INFO, "Search Product - " + product + " and cateory was - " + category);
		amazonHomepage.searchProduct(product, category);
	}

	@Test(priority = -1000)
	public void verifyTitleOfTheWebpage() throws Exception {
		extentTest = extent.createTest("TC - 002 - Verify Title of the page");

		String expectedTitle = "Amazon Home Page";

		String actualTitle = cmnDriver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
