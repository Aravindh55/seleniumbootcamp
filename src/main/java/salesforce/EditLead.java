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

public class EditLead {
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
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Lead-search-input']")));
	driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Kumar");
	driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys(Keys.ENTER);
	Thread.sleep(4000);
    WebElement findElement = driver.findElement(By.xpath("(//span[contains(@class,'utility-down')])[1]"));
    driver.executeScript("arguments[0].scrollIntoView();", findElement);
	Thread.sleep(5000);
	findElement.click();
	driver.findElement(By.xpath("//a[@title='Edit']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ganesh");
	WebElement findElement2 = driver.findElement(By.xpath("(//button[contains(@aria-haspopup,'list')])[4]"));
	driver.executeScript("arguments[0].scrollIntoView();", findElement2);
	Thread.sleep(3000);
	findElement2.click();
	driver.findElement(By.xpath("//span[contains(@title,'W')]")).click();
	driver.findElement(By.xpath("//button[contains(@name,'SaveE')]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'forceInlineEdit')]/a)[1]")));
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//span[contains(@class,'forceInlineEdit')]/a)[1]")).click();
	Thread.sleep(5000);
	String text = driver.findElement(By.xpath("//lightning-formatted-name[@slot='primaryField']")).getText();
	if (text.contains("Ganesh")) {
		System.out.println("The Leads is editted successfully");
		
	}else {
		throw new RuntimeException();
	}
	
	
	
	
	
	}
}
