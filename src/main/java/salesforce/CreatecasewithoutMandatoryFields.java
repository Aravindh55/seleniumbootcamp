package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecasewithoutMandatoryFields {
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

		WebElement findElement = driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.executeScript("arguments[0].scrollIntoView();", findElement);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='More']")));
		driver.findElement(By.xpath("//span[text()='More']")).click();
		WebElement findElement2 = driver.findElement(By.xpath("//span[@class='slds-truncate']/span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", findElement2);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@title='Cases']/following-sibling::one-app-nav-bar-item-dropdown")));
		driver.findElement(By.xpath("//a[@title='Cases']/following-sibling::one-app-nav-bar-item-dropdown")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Case']")));
		WebElement findElement3 = driver.findElement(By.xpath("//span[text()='New Case']"));
		driver.executeScript("arguments[0].click();", findElement3);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[text()='New']")));
		driver.findElement(By.xpath("//button/span[text()='New']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='--None--']")));
		driver.findElement(By.xpath("//span[@title='--None--']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'autocomplete')]/input)[1]")).sendKeys("Kumar");
		driver.findElement(By.xpath("//div[@title='Kumar R']")).click();
		
		WebElement findElement4 = driver.findElement(By.xpath("//label/span[text()='Subject']"));
		driver.executeScript("arguments[0].scrollIntoView();", findElement4);
		driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input"))
				.sendKeys("testing");
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea"))
				.sendKeys("dummy");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'genericNotification')]/span")));
		String text = driver.findElement(By.xpath("//div[contains(@class,'genericNotification')]/span")).getText();
		if (text.contains("Review")) {
			System.out.println("case is not created successfully");
			
		}else {
			throw new RuntimeException();
		}
		
		

	}

}
