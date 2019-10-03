package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	private WebDriver driver;

	private WebElement pageLink;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void navigateToPage(String pagename) throws Exception{

		pageLink = driver.findElement(By.linkText(pagename));
		elementControl.clickElement(pageLink);

	}
}
