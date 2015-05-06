package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Setup {

	private static final String pathToCRMdriver = "D:\\JavaLibraries\\chromedriver_win32\\chromedriver.exe";
	private static final String pathToIEdriver = "D:\\JavaLibraries\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe";

	public static WebDriver loadWebBrowser(WebDriver driver, String browser, String startURL) {
		if (browser.equals("FFX")) {
			System.out.println("Test Starts Running In Firefox Browser.");
			driver = new FirefoxDriver();
		} else if (browser.equals("CRM")) {
			System.out.println("Test Starts Running In Google Chrome.");
			System.setProperty("webdriver.chrome.driver", pathToCRMdriver);
			driver = new ChromeDriver();
		} else if (browser.equals("IE")) {
			System.out.println("Test Starts Running In Internet Explorer.");
			System.setProperty("webdriver.ie.driver", pathToIEdriver);
			driver = new InternetExplorerDriver();
		}

		driver.get(startURL);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

}
