package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public static final String loginURL = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/&hl=ru";

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs("Gmail"));
	}

	public InboxPage loginAs(String username, String password) {
		executeLogin(username, password);
		return new InboxPage(driver, username);
	}

	private void executeLogin(String username, String password) {
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).submit();
	}

}
