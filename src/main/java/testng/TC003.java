package testng;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003 {
	ChromeDriver driver;

	@Test(dataProvider = "data1")
	public void runMethod1(String name, int age) {
		System.out.println(name);
		System.out.println(age);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		Assert.assertTrue(false);
	}

	@Test(dataProvider = "data2")
	public void runmethod2(String name) {
		System.out.println(name);

	}

	@DataProvider
	public Object[][] data1() {
		return new Object[][] { { "aravindh", 27 } };
	}

	@DataProvider
	public String[][] data2() {
		return new String[][] { { "aravindh" }, { "guru" } };
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			File src = screenshot.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(src, new File("./images/" + result.getName() + ".png"));

		}

	}
}
