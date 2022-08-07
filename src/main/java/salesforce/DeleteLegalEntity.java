package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLegalEntity {
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
		WebElement findElement2 = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		wait.until(ExpectedConditions.visibilityOf(findElement2));
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys("Salesforce Automation by AravindhR");
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer'])[2]//div")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Delete')]")));
	    driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
		WebElement findElement3 = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		wait.until(ExpectedConditions.visibilityOf(findElement3));
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys("Salesforce Automation by AravindhR");
		Thread.sleep(5000);
		boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'No items')]")).isDisplayed();
		if (displayed) {
			System.out.println("The Legal Entity is deleted");
			
		}else {
			throw new RuntimeException();
		}
		
		
	}

}
