package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTitleTest {
	@Test(groups = { "regression", "smoke" })
	public void testTitle() {
		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals("", "+");
		softAssert.assertEquals("", "");
	}



	@Test(groups = { "regression" })

	public void testTitle2() {
		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals("", "");
		softAssert.assertEquals("", "");
	}
}