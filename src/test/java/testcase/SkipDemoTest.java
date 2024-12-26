package testcase;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipDemoTest {
	Boolean datsetup = false;

	@Test(enabled = false)
	public void skipTest1() {
		System.out.println("it is not complete");
	}

	@Test

	public void skipTest12() {
		System.out.println("it is not complete skipTest12");
		throw new SkipException("skipping this test skipTest12");
	}

	@Test

	public void skipTest123() {
		System.out.println("skip based on condition");
		if (datsetup == true) {
			System.out.println("execute");

		} else {
			System.out.println("do not execute");
			throw new SkipException("do not execute further");

		}
	}
}
