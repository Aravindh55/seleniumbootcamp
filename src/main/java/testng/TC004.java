package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC004 {

	@Test
	public void tryhardAssert() {
		
		System.out.println("Hard Assertion");
	}

	public void trysoftAssert() {

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(true, false);
		System.out.println("softassertion");

	}
}
