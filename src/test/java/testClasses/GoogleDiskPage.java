package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static testClasses.Selectors.*;

public class GoogleDiskPage {

	private WebDriver driver;

	public GoogleDiskPage(WebDriver driver) {
		super();
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs("Мій диск – Google Диск"));
	}

	public void createFolder(WebDriver driver, String folderName) {
		clickButton(driver, "div[class='j-Ta-pb f-e f-e-dg a-Da-e']");
		clickButton(driver, "div[class='a-D-P']");
		driver.findElement(By.cssSelector("input[class='kb-r-Mj f-Wh']")).sendKeys(folderName);
		clickButton(driver, "button[name='ok']");
	}

	public void deleteFolder(WebDriver driver, String folderName) {
		clickButton(driver, "div[aria-label='" + folderName + "']");
		clickButton(driver, "div[aria-label='Вилучити']");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
