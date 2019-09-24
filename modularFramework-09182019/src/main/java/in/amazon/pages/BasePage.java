package in.amazon.pages;

import org.openqa.selenium.WebDriver;

import comonLibs.implementation.DropdownControl;
import comonLibs.implementation.ElementControl;
import comonLibs.implementation.MouseControl;

public class BasePage {

	protected ElementControl elementControl;
	protected DropdownControl dropdownControl;
	protected MouseControl mouseControl;

	public BasePage(WebDriver driver) {
		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();

		mouseControl = new MouseControl(driver);
	}

}
