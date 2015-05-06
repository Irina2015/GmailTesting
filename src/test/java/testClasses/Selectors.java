package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Selectors {

	static WebDriver driver;

	// Method for clicking a button with a given selector
	public static void clickButton(WebDriver driver, String selector) {
		driver.findElement(By.cssSelector(selector)).click();
	}

}
