package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriverWait wait;
	protected  RemoteWebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void precondition(String parameter) {
		if (parameter.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}else if (parameter.toLowerCase().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options =new EdgeOptions();
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver();
			
		} 
			
			
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[contains(@class,'username')]")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[contains(@class,'password')]")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[contains(@class,'button')]")).click();

	}
	@AfterMethod
	public void close() {
		driver.quit();

	}
}
