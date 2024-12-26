package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = "regression")
public class GroupDemoTest {
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@Test(priority = 1, groups = "regression")
	public void beforeGroup() {
		System.out.println("beforeGroup");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}
}
