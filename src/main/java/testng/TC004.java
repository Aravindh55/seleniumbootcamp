package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004 {
@Test
	public void HardAssert() {
	Assert.assertEquals(true, false);
		System.out.println("hardassert");
		WebDriverManager.chromedriver().setup();

	}
@Test
public void softAssert() {
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(true, false);
	System.out.println("softassert");
}
}

