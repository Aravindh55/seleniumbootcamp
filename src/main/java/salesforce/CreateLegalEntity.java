package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLegalEntity {
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
		driver.findElement(By.xpath("//input[contains(@placeholder,'s')]")).sendKeys("sales");
		driver.findElement(By.xpath("//p[contains(@class,'s')]")).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//one-app-nav-bar-item-dropdown//div[contains(@class,'context-bar')])[15]")));
		driver.findElement(By.xpath("(//one-app-nav-bar-item-dropdown//div[contains(@class,'context-bar')])[15]")).click();
		Thread.sleep(4000);
		WebElement findElement3 = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", findElement3);
		driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys("Salesforce Automation by AravindhR");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='uiOutputText'])[1]")));
		String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
		if (text.equals("Salesforce Automation by AravindhR")) {
			System.out.println("The legal entity is created");
			
		}else {
			System.out.println("The legal entity is not created");
			
		}
		driver.close();
		
		
		
		
		
		
	}

}
