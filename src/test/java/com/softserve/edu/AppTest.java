package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void testApp() {
		int i = 1;
		Assert.assertTrue(i + 1 == 2);
		Assert.assertTrue(true);
	}

}
