package factorydesignpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
public static WebDriver driver;

public static WebDriver getdriver(String browsername) {
	browsertype browser = browsertype.valueOf(browsername.toUpperCase());
	switch (browser) {
	case CHROME:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case FIREFOX:
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		break;
	
	default:
		throw new RuntimeException("The browser is not working as expected");
	}
	return driver;
}
}

