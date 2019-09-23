package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comonLibs.implementation.DropdownControl;
import comonLibs.implementation.ElementControl;

public class AmazonHomePage {

	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;

	@CacheLookup
	@FindBy(id="searchDropdownBox")
	private WebElement searchCat;

	@CacheLookup
	@FindBy(xpath="//input[@value='Go']")
	private WebElement searchButton;

	@FindBy(xpath="//span[@data-component-type='s-result-info-bar']")
	private WebElement searchResult;

	private ElementControl elementControl;
	private DropdownControl dropdownControl;

	public AmazonHomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();

	}

	public void searchProduct(String product, String category) throws Exception {

		elementControl.setText(searchBox, product);

		dropdownControl.selectViaVisibleText(searchCat, category);

		elementControl.clickElement(searchButton);

		String result = elementControl.getText(searchResult);

		System.out.println("Result : " + result);

	}

}
