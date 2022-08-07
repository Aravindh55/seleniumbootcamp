package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLegalEntity {
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		WebElement findElement = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(findElement));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		WebElement findElement2 = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		wait.until(ExpectedConditions.visibilityOf(findElement2));
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys("Salesforce Automation by Aravindh");
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer'])[2]//div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='uiMenuItem']/a")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@role='textbox'])[2]")).sendKeys("SalesForce");
		WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Status']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", findElement3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'None')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='uiMenuItem uiRadioMenuItem']/a[@title='Active']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//th[@class='slds-cell-edit cellContainer']//a)[1]")).click();
		WebElement findElement4 = driver.findElement(By.xpath("(//div[@class='slds-form-element__control']//span)[2]"));
		wait.until(ExpectedConditions.visibilityOf(findElement4));
		String text = findElement4.getText();
		if (text.equals("Active")) {
			System.out.println("The Legal Entity is Edited Successfully");
			
		}else {
			System.out.println("The Legal Entity is not Edited");
		}
		driver.close();
		
		
		
	}

}
