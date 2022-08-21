package salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssetTestCase {
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[contains(@class,'username')]")).sendKeys("saturn@testleaf.com");
		driver.findElement(By.xpath("//input[contains(@class,'password')]")).sendKeys(" Bootcamp$123");
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Closed']/following-sibling::lightning-formatted-text")));
		String text = driver
				.findElement(By.xpath("//span[text()='Closed']/following-sibling::lightning-formatted-text")).getText();
		String replace1 = text.replaceAll("\\D", "");
		int open = Integer.parseInt(replace1);
		String text2 = driver
				.findElement(By.xpath("//span[contains(text(),'Open')]/following-sibling::lightning-formatted-text"))
				.getText();
		String replace2 = text2.replaceAll("\\D", "");
		int closed = Integer.parseInt(replace2);
		int total = open + closed;
		String string = Integer.toString(total);
		System.out.println(string);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@inputmode='decimal']")).clear();
		driver.findElement(By.xpath("//input[@inputmode='decimal']")).sendKeys(string);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement findElement3 = driver.findElement(By.xpath("//a[@title='Dashboards']"));
		driver.executeScript("arguments[0].click();", findElement3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='New Dashboard']")));
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		WebElement findElement2 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(findElement2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboardNameInput")));
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Aravindh_Workout");
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("testing");
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement findElement4 = driver.findElement(By.xpath("(//iframe[@title='dashboard'])[1]"));
		driver.switchTo().frame(findElement4);
        driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.switchTo().defaultContent();
		driver.executeScript("arguments[0].click();", findElement3);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search recent dashboard')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search recent dashboard')]"))
				.sendKeys("Aravindh_Workout");
		String text3 = driver.findElement(By.xpath("//span[contains(@class,'highlight')]")).getText();
		if (text3.contains("Aravindh")) {
			System.out.println("The dashboard is created");

		} else {
			throw new RuntimeException();
		}
		WebElement findElement5 = driver.findElement(By.xpath("//span[contains(@class,'highlight')]"));
		driver.executeScript("arguments[0].click();", findElement5);
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[2]")));
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[text()='Daily']")).click();
		Select drp = new Select(driver.findElement(By.id("time")));
		drp.selectByVisibleText("10:00 AM");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		WebElement findElement6 = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
		String text4 = findElement6.getText();
		if (text4.contains("started")) {
			System.out.println("The subscription is all set");

		} else {
			throw new RuntimeException();
		}
		driver.executeScript("arguments[0].click();", findElement3);
		WebElement findElement7 = driver.findElement(By.xpath("//div[@class='slds-truncate']//span"));
		wait.until(ExpectedConditions.visibilityOf(findElement7));
		String text5 = findElement7.getText();
		System.out.println(text5);
		if (text5.contains("True")) {
			System.out.println("The Newly created dashboard is available");

		} else {
			throw new RuntimeException();

		}
		driver.findElement(By.xpath("(//span[contains(@class,'slds-grid slds-a')])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Delete']")));
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Delete'])[2]")));
		driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Private Dashboards']")).click();
		Thread.sleep(3000);
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='slds-truncate']//span"));
		int count = 0;
		for (WebElement sub : findElements) {
			String text6 = sub.getText();
			if (text6.contains("True")) {
				count++;
			}
		}
		if (count==0) {
			System.out.println("The dashboard is deleted");
			
		}else {
			throw new RuntimeException();
		}
		

	}

}
