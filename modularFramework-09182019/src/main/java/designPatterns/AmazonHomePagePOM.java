package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comonLibs.implementation.DropdownControl;
import comonLibs.implementation.ElementControl;

public class AmazonHomePagePOM {

	private WebElement searchBox;

	private WebElement searchCat;

	private WebElement searchButton;

	private WebElement searchResult;

	private ElementControl elementControl;
	private DropdownControl dropdownControl;

	public AmazonHomePagePOM(WebDriver driver) {

		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchCat = driver.findElement(By.id("searchDropdownBox"));

		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

		searchResult = driver.findElement(By.xpath("//span[@data-component-type='s-result-info-bar']"));

		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();

	}

	public void searchProduct(String product, String category) throws Exception {

		elementControl.setText(searchBox, product);

		dropdownControl.selectViaVisibleText(searchCat, category);

		elementControl.clickElement(searchButton);

		String result = elementControl.getText(searchResult);

		System.out.println("Resultsssssssssss : " + result);

	}

}
