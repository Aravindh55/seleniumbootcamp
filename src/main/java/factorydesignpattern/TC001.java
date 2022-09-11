package factorydesignpattern;

import org.openqa.selenium.WebDriver;

public class TC001 {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		driver= BrowserFactory.getdriver("chrome");
		driver.get("https://www.google.co.in/");
		
	}
}
