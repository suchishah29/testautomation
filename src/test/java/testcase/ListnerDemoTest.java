package testcase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class ListnerDemoTest extends BaseTest {
	@Test(retryAnalyzer = common.Retry.class)
	public void launachapp() {
		driver.get("https://google.com");
	}
	
	@Test
	public void testTitle() {
		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals("", "+");
		softAssert.assertEquals("", "");
	}
}
