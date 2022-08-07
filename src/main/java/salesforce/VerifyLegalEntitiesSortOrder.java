package salesforce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLegalEntitiesSortOrder {
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[contains(@class,'username')]")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[contains(@class,'password')]")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[contains(@class,'button')]")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'slds-icon-w')]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-w')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'View')]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'s')]")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[contains(@class,'s')]")).click();
		WebElement findElement2 = driver
				.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		wait.until(ExpectedConditions.visibilityOf(findElement2));
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"))
				.sendKeys("Salesforce Automation by Aravindh");
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> findElements = driver.findElements(By.xpath("//span[contains(@class,'uiOutputDateTime')]"));

		List<String> original = new ArrayList<String>();

		for (WebElement webElement : findElements) {
			String attribute = webElement.getText();
			original.add(attribute);
		}

		Collections.sort(original);
		Thread.sleep(5000);
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Last Modified Date']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement).click().perform();
		Thread.sleep(3000);
		actions.click().perform();
		Thread.sleep(3000);

		List<WebElement> findElements2 = driver.findElements(By.xpath("//span[contains(@class,'uiOutputDateTime')]"));
		List<String> sorted = new ArrayList<String>();
		for (WebElement date : findElements2) {
			String text = date.getText();
			sorted.add(text);
		}
		System.out.println(original);
		System.out.println(sorted);
		int count = 0;
		for (int i = 0; i < sorted.size(); i++) {

			if (original.get(i).equals(sorted.get(i))) {
				count++;
			}
		}
		if (count == sorted.size()) {
			System.out.println("The dates are sorted ");

		} else {
			System.out.println("The dates are not sorted");
		}

	}
}
