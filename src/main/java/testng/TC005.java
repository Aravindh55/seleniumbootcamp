package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005 {
	@Test
	public void method1() {
		System.out.println("method1");
	}

	@Test
	public void method2() {
		Assert.assertEquals(true, false);
		System.out.println("method2");
	}

	@Test
	public void method3() {
		System.out.println("method3");

	}
}
