package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comonLibs.implementation.DropdownControl;
import comonLibs.implementation.ElementControl;

public class AmazonHomePage {

	private WebElement searchBox;

	private WebElement searchCat;

	private WebElement searchButton;

	private ElementControl elementControl;
	private DropdownControl dropdownControl;

	public AmazonHomePage(WebDriver driver) {

		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchCat = driver.findElement(By.id("searchDropdownBox"));

		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();

	}

	public void searchProduct(String product, String category) throws Exception {

		elementControl.setText(searchBox, product);

		dropdownControl.selectViaVisibleText(searchCat, category);

		elementControl.clickElement(searchButton);

	}

}
