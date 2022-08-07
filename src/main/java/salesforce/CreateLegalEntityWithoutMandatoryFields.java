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



public class CreateLegalEntityWithoutMandatoryFields {
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]")));
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]")).click();
		Thread.sleep(4000);
		WebElement findElement3 = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", findElement3);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@role='textbox'])[2]")).sendKeys("SalesForce");
		WebElement findElement4 = driver.findElement(By.xpath("//span[text()='Status']"));
		driver.executeScript("arguments[0].scrollIntoView()", findElement4);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'None')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='uiMenuItem uiRadioMenuItem']/a[@title='Active']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		boolean displayed = driver.findElement(By.xpath("//li[contains(text(),'Complete')]")).isDisplayed();
		if (displayed) {
			System.out.println("'Complete this field' message is displayed");
		}else {
			throw new RuntimeException();
		}
		driver.close();
		

}
}
