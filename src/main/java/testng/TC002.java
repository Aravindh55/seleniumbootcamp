package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC002 extends BaseClass {

	

	@Test
	public void runTC002() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'slds-icon-w')]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-w')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'View')]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'s')]")).sendKeys("sales");
		driver.findElement(By.xpath("//p[contains(@class,'s')]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//one-app-nav-bar-item-dropdown//div[contains(@class,'context-bar')])[15]")));
		driver.findElement(By.xpath("(//one-app-nav-bar-item-dropdown//div[contains(@class,'context-bar')])[15]"))
				.click();
	}
}