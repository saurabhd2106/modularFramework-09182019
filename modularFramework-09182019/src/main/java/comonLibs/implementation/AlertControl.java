package comonLibs.implementation;

import org.openqa.selenium.WebDriver;

import comonLibs.contracts.IAlert;

public class AlertControl implements IAlert {
	private WebDriver driver;

	public AlertControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void acceptAlert() throws Exception {

		driver.switchTo().alert().accept();

	}

	@Override
	public void rejectAlert() throws Exception {
		driver.switchTo().alert().dismiss();

	}

	@Override
	public String getMessageFromAlert() throws Exception {

		return driver.switchTo().alert().getText();
	}

	@Override
	public boolean checkAlertPresent(int timeoutInseconds) throws Exception {

		return false;
	}

}
