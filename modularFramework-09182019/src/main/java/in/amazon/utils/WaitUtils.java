package in.amazon.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static void waitTillElementVisible(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitTillAlertIsPresent(WebDriver driver, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitTillElementClickable(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
