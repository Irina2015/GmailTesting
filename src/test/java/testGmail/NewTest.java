package testGmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testClasses.GoogleDiskPage;
import testClasses.InboxPage;
import testClasses.LoginPage;
import testClasses.Setup;

public class NewTest {

	private static WebDriver driver = null;
	private static final String userName = "testUser@gmail.com";
	private static final String password = "password";
	private static final String folderName = "NewFolder";
	private static final String titleAfterLogOut = "Gmail";

	@BeforeMethod
	// parameter value will be retrieved from testng.xml file's <parameter> tag.
	@Parameters({ "browser" })
	public void setup(String browser) {
		driver = Setup.loadWebBrowser(driver, browser, LoginPage.loginURL);
	}

	// All given tests will be executed In three browsers

	@Test
	public void testLogIn() {
		LoginPage loginPage = new LoginPage(driver);
		InboxPage inboxPage = loginPage.loginAs(userName, password);
		Assert.assertEquals(inboxPage.getLoggedinUserName(), userName);
	}

	@Test
	public void testCreateFolder() {
		LoginPage loginPage = new LoginPage(driver);
		InboxPage inboxPage = loginPage.loginAs(userName, password);
		GoogleDiskPage googleDiskPage = inboxPage.openGDfromInbox(driver);
		googleDiskPage.createFolder(driver, folderName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String selector = "div[aria-label='" + folderName + "']";
		Assert.assertTrue(driver.findElement(By.cssSelector(selector)).isDisplayed());
	}

	@Test(dependsOnMethods = { "testCreateFolder" })
	public void deleteFolder() {
		LoginPage loginPage = new LoginPage(driver);
		InboxPage inboxPage = loginPage.loginAs(userName, password);
		GoogleDiskPage googleDiskPage = inboxPage.openGDfromInbox(driver);
		googleDiskPage.deleteFolder(driver, folderName);
	}

	@Test
	public void testLogOut() {
		LoginPage loginPage = new LoginPage(driver);
		InboxPage inboxPage = loginPage.loginAs(userName, password);
		loginPage = inboxPage.logOut(driver);
		String title = driver.getTitle();
		Assert.assertEquals(title, titleAfterLogOut);
	}

	@AfterMethod
	public void ClosingBrowser() {
		driver.close();
	}

}
