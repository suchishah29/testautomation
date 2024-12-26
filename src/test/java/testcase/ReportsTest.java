package testcase;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReportsTest {
	@Test
	public void ReportsTest1() {
		Reporter.log("it is ReportsTest1");
		System.out.println("it is ReportsTest1");
	}

	@Test
	public void ReportsTest2() {
		Reporter.log("it is ReportsTest2");

		System.out.println("it is ReportsTest2");
	}

	@Test
	public void ReportsTest3() {
		Reporter.log("it is ReportsTest3");

		System.out.println("it is ReportsTest3");
	}
}
