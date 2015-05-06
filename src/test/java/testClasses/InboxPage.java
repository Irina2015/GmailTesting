package testClasses;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static testClasses.Selectors.*;

public class InboxPage {

	private WebDriver driver;
	private String userName;

	public InboxPage(WebDriver driver, String username) {
		super();
		this.driver = driver;
		this.userName = username;
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.titleIs("Âõ³äí³ - " + username + " - Gmail"));
	}

	public String getLoggedinUserName() {
		clickButton(driver, "span[class='gb_d gbii']");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='gb_E']")));
		return driver.findElement(By.cssSelector("div[class='gb_E']")).getText();
	}

	public GoogleDiskPage openGDfromInbox(WebDriver driver) {
		clickButton(driver, "a[class='gb_ga gb_2']");
		clickButton(driver, "a[id='gb49']");
		Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		String window2 = (String) AllWindowHandles.toArray()[1];
		driver.close();
		driver.switchTo().window(window2);
		return new GoogleDiskPage(driver);
	}
	
	public LoginPage logOut(WebDriver driver){
		clickButton(driver, "span[class='gb_d gbii']");
		clickButton(driver, "a[id='gb_71']");
		return new LoginPage(driver);
	}

}
