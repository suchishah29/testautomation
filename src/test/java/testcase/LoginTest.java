package testcase;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

@Test
public class LoginTest {

	@BeforeSuite
	public void cleanupdata() {
		System.out.println("cleanupdata");

	}

	@AfterSuite
	public void cleanupdataAgain() {
		System.out.println("cleanupdataAgain");

	}

	@BeforeTest
	public void login() {
		System.out.println("login");

	}

	@AfterTest
	public void logout() {
		System.out.println("logout");

	}

	@BeforeMethod
	public void methodset() {
		System.out.println("methodset");

	}

	@Test
	public void psvm() {
		System.out.println("rrr");

	}

	@Test(priority = 0, description = "gggg")
	public void fsvm2() {
		System.out.println("rrr2");

	}
}
