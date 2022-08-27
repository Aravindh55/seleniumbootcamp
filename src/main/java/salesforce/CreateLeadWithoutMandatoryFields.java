package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadWithoutMandatoryFields {
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
		driver.findElement(By.xpath("//input[contains(@placeholder,'s')]")).sendKeys("Leads");
		driver.findElement(By.xpath("//p[contains(@class,'s')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='New']")));
		driver.findElement(By.xpath("//div[@title='New']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@name,'salut')]")));
		driver.findElement(By.xpath("//button[contains(@name,'salut')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@title,'Mr.')]")));
		driver.findElement(By.xpath("//span[contains(@title,'Mr.')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ganesh");
		WebElement findElement = driver.findElement(By.xpath("//input[@name='Company']"));
		driver.executeScript("arguments[0].scrollIntoView();", findElement);
		findElement.sendKeys("TestLeaf");
		WebElement findElement2 = driver.findElement(By.xpath("//button[contains(@name,'SaveEdit')]"));
		driver.executeScript("arguments[0].scrollIntoView();", findElement2);
		driver.findElement(By.xpath("//button[contains(@name,'SaveEdit')]")).click();	
		Thread.sleep(3000);
		Boolean displayed = driver.findElement(By.xpath("//h2[contains(text(),'snag')]")).isDisplayed();
		if (displayed) {
			System.out.println("Validation is displayed");
			
		}else {
			throw new RuntimeException();
		}
		//test
	
		
	}
}
